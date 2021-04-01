package cn.edu.dgut.epidemic.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.dgut.epidemic.mapper.VolunteerEnrollMapper;
import cn.edu.dgut.epidemic.mapper.VolunteerServiceMapper;
import cn.edu.dgut.epidemic.pojo.CampusUserInfo;
import cn.edu.dgut.epidemic.pojo.CustomUser;
import cn.edu.dgut.epidemic.pojo.VolunteerEnroll;
import cn.edu.dgut.epidemic.pojo.VolunteerEnrollExample;
import cn.edu.dgut.epidemic.pojo.VolunteerService;
import cn.edu.dgut.epidemic.pojo.VolunteerServiceExample;
import cn.edu.dgut.epidemic.service.ActivitiService;
import cn.edu.dgut.epidemic.util.Constants;

@Service
public class ActivitiServiceImpl implements ActivitiService {

	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private VolunteerServiceMapper volunteerServiceMapper;
	@Autowired
	private VolunteerEnrollMapper volunteerEnrollMapper;

	// 部署流程定义
	@Override
	public void saveNewDeploy(InputStream in, String filename) {
		try {
			// 将File类型的文件转化成ZipInputStream流
			ZipInputStream zipInputStream = new ZipInputStream(in);
			repositoryService.createDeployment()// 创建部署对象
					.name(filename)// 添加部署名称
					.addZipInputStream(zipInputStream).deploy();// 完成部署
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 保存并启动流程实例
	@Override
	public void startProcess(Long id, String name, Integer flag) {
		// 活动审核业务和流程信息进行关联 BUSSINSS_KEY
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", name);

		// 定义规则
		String BUSSINSS_KEY = Constants.Activity_KEY + "." + id;
		if (flag == 2) {
			BUSSINSS_KEY = Constants.Enroll_KEY + "." + id;
		}

		map.put("objId", BUSSINSS_KEY);

		// 使用流程定义的key，启动流程实例，同时设置流程变量，同时向正在执行的执行对象表中的字段BUSINESS_KEY添加业务数据，同时让流程关联业务
		this.runtimeService.startProcessInstanceByKey(Constants.Activity_KEY, BUSSINSS_KEY, map);
	}

	// 根据待办人名称查询任务
	@Override
	public List<Task> findTaskListByName(String name, Integer flag) {
		// flag==1为活动流程，flag==2为报名流程
		String procDeResName = Constants.Activity_KEY;
		if (flag == 2) {
			procDeResName = Constants.Enroll_KEY;
		}
		// 获得流程定义
		ProcessDefinition processDefinition = this.repositoryService.createProcessDefinitionQuery()
				.processDefinitionResourceNameLike("%" + procDeResName + "%").singleResult();
		if (processDefinition != null) {
			String id = processDefinition.getId();
			// 根据待办人名称查询任务
			List<Task> list = this.taskService.createTaskQuery().taskAssignee(name).processDefinitionId(id)
					.orderByTaskCreateTime().desc().list();
			return list;
		}
		return null;
	}

	// 根据taskId获取活动信息
	@Override
	public VolunteerService findVolunteerServiceByTaskId(String taskId) {
		// 先根据任务id取出task任务
		Task task = this.taskService.createTaskQuery().taskId(taskId).singleResult();

		// 再根据任务中流程实例id 取出 流程实例对象
		ProcessInstance processInstance = this.runtimeService.createProcessInstanceQuery()
				.processInstanceId(task.getProcessInstanceId()).singleResult();

		// 然后再从流程实例中取出bussiness_key
		String businessKey = processInstance.getBusinessKey();

		// 然后从bussinessKey中切割出 volunteerService的campusId
		String activityId = "";
		if (businessKey != null && !"".equals(businessKey)) {
			activityId = businessKey.split("\\.")[1];
		}

		// 根据activityId查询出当前活动信息
		VolunteerServiceExample volunteerServiceExample = new VolunteerServiceExample();
		VolunteerServiceExample.Criteria createCriteria = volunteerServiceExample.createCriteria();
		createCriteria.andCampusIdEqualTo(Long.parseLong(activityId));
		List<VolunteerService> list = this.volunteerServiceMapper.selectByExample(volunteerServiceExample);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;

	}

	// 根据taskId获取报名信息
	@Override
	public VolunteerEnroll findVolunteerEnrollByTaskId(String taskId) {
		// 先根据任务id取出task任务
		Task task = this.taskService.createTaskQuery().taskId(taskId).singleResult();

		// 再根据任务中流程实例id 取出 流程实例对象
		ProcessInstance processInstance = this.runtimeService.createProcessInstanceQuery()
				.processInstanceId(task.getProcessInstanceId()).singleResult();

		// 然后再从流程实例中取出bussiness_key
		String businessKey = processInstance.getBusinessKey();

		// 然后从bussinessKey中切割出VolunteerEnroll的campusId
		String enrollId = "";
		if (businessKey != null && !"".equals(businessKey)) {
			enrollId = businessKey.split("\\.")[1];
		}

		// 根据leaveid 查询出当前请假单信息
		VolunteerEnrollExample volunteerEnrollExample = new VolunteerEnrollExample();
		VolunteerEnrollExample.Criteria createCriteria = volunteerEnrollExample.createCriteria();
		createCriteria.andCampusIdEqualTo(Long.parseLong(enrollId));
		List<VolunteerEnroll> list = this.volunteerEnrollMapper.selectByExample(volunteerEnrollExample);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 完成任务，推进流程
	@Override
	public void submitTask(Integer id, String taskId, String comment, String outcome, CampusUserInfo userInfo,
			Integer flag) {
		/**
		 * 1：在完成之前，添加一个批注信息，向act_hi_comment表中添加数据，用于记录对当前申请人的一些审核信息
		 */
		// 使用任务ID，查询任务对象，获取流程流程实例ID
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();

		// 获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		/**
		 * 注意：添加批注的时候，由于Activiti底层代码是使用： String userId =
		 * Authentication.getAuthenticatedUserId(); CommentEntity comment = new
		 * CommentEntity(); comment.setUserId(userId);
		 * 所有需要从Session中获取当前登录人，作为该任务的办理人（审核人），对应act_hi_comment表中的User_ID的字段，不过不添加审核人，该字段为null
		 * 所以要求，添加配置执行使用Authentication.setAuthenticatedUserId();添加当前任务的审核人
		 */
		// 加当前任务的审核人
		Authentication.setAuthenticatedUserId(userInfo.getFullName());
		// 添加批注
		taskService.addComment(taskId, processInstanceId, comment);
		/**
		 * 2：如果连线的名称是“默认提交”，那么就不需要设置，如果不是，就需要设置流程变量 在完成任务之前，设置流程变量，按照连线的名称，去完成任务
		 * 流程变量的名称：outcome 流程变量的值：连线的名称
		 */
		// 完成任务
		CustomUser customUser = (CustomUser) SecurityUtils.getSubject().getPrincipal();
		Map<String, Object> map = new HashMap<String, Object>();
		// 判断完成流程是否需要对应参数
		if (outcome != null && outcome.equals("提交申请")) {
			map.put("role", customUser.getRoleId());
			// 3：使用任务ID，完成当前人的个人任务，同时流程变量
			taskService.complete(taskId, map);
		} else if (outcome != null && !outcome.equals("提交")) {
			map.put("message", outcome);
			// 3：使用任务ID，完成当前人的个人任务，同时流程变量
			taskService.complete(taskId, map);
		} else {
			taskService.complete(taskId);
		}

		// 获取流程实例
		ProcessInstance processInstance = this.runtimeService.createProcessInstanceQuery()
				.processInstanceId(processInstanceId)// 使用流程实例ID查询
				.singleResult();

		/**
		 * 5：在完成任务之后，判断流程是否结束 如果流程结束了，更新各自的审核状态（审核中-->审核完成）
		 */
		if (flag == 1) {
			if (processInstance == null) {
				// 把活动审核状态更新为已完成
				VolunteerService volunteerService = volunteerServiceMapper.selectByPrimaryKey(id);
				volunteerService.setState("3");
				volunteerServiceMapper.updateByPrimaryKeySelective(volunteerService);
			}
		} else if (flag == 2) {
			// 流程结束了
			if (processInstance == null) {
				// 更新报名状态从1变成2（审核中-->审核完成）
				VolunteerEnroll volunteerEnroll = volunteerEnrollMapper.selectByPrimaryKey(id);
				volunteerEnroll.setState("3");
				volunteerEnrollMapper.updateByPrimaryKey(volunteerEnroll);
			}
		}

	}

	// 根据任务id查询流程定义对象
	@Override
	public ProcessDefinition findProcessDefinitionByTaskId(String taskId) {
		// 使用任务ID，查询任务对象
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		// 获取流程定义ID
		String processDefinitionId = task.getProcessDefinitionId();
		// 查询流程定义的对象
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()// 创建流程定义查询对象，对应表act_re_procdef
				.processDefinitionId(processDefinitionId)// 使用流程定义ID查询
				.singleResult();
		return pd;
	}

	// 勾画出当前流程坐标信息图
	@Override
	public Map<String, Object> findCoordingByTask(String taskId) {
		// 存放坐标
		Map<String, Object> map = new HashMap<String, Object>();
		// 使用任务ID，查询任务对象
		Task task = taskService.createTaskQuery()//
				.taskId(taskId)// 使用任务ID查询
				.singleResult();
		// 获取流程定义的ID
		String processDefinitionId = task.getProcessDefinitionId();
		// 获取流程定义的实体对象（对应.bpmn文件中的数据）
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService
				.getProcessDefinition(processDefinitionId);
		// 流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		// 使用流程实例ID，查询正在执行的执行对象表，获取当前活动对应的流程实例对象
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()// 创建流程实例查询
				.processInstanceId(processInstanceId)// 使用流程实例ID查询
				.singleResult();
		// 获取当前活动的ID
		String activityId = pi.getActivityId();
		// 获取当前活动对象
		ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);// 活动ID
		// 获取坐标
		map.put("x", activityImpl.getX());
		map.put("y", activityImpl.getY());
		map.put("width", activityImpl.getWidth());
		map.put("height", activityImpl.getHeight());
		return map;
	}

	// 使用部署对象ID和资源图片名称，获取图片的输入流
	@Override
	public InputStream findImageInputStream(String deploymentId, String imageName) {
		return repositoryService.getResourceAsStream(deploymentId, imageName);
	}

	// 根据BUSSINESS_KEY查询任务信息
	@Override
	public Task findTaskByBussinessKey(String bUSSINESS_KEY) {
		Task task = this.taskService.createTaskQuery().processInstanceBusinessKey(bUSSINESS_KEY).singleResult();
		return task;
	}

	// 查询部署对象信息
	@Override
	public List<Deployment> findDeploymentList() {
		List<Deployment> list = repositoryService.createDeploymentQuery()// 创建部署对象查询
				.orderByDeploymenTime().asc().list();
		return list;
	}

	// 查询流程定义的信息
	@Override
	public List<ProcessDefinition> findProcessDefinitionList() {
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()// 创建流程定义查询
				.orderByProcessDefinitionVersion().asc().list();
		return list;
	}

	// 使用ID，查询历史的批注信息
	@Override
	public List<Comment> findCommentById(Integer id, Integer flag) {
		String bussiness_key = Constants.Activity_KEY + "." + id;
		if (flag == 2) {
			bussiness_key = Constants.Enroll_KEY + "." + id;
		}
		// 根据bussiness_key获取历史流程实例
		HistoricProcessInstance pi = this.historyService.createHistoricProcessInstanceQuery()
				.processInstanceBusinessKey(bussiness_key).singleResult();
		// 根据请假单ID查询历史批注
		List<Comment> commentList = this.taskService.getProcessInstanceComments(pi.getId());

		return commentList;
	}

	// 根据taskId获取批注信息
	@Override
	public List<Comment> findCommentListByTaskId(String taskId) {
		// 先根据任务id取出task任务
		Task task = this.taskService.createTaskQuery().taskId(taskId).singleResult();

		// 根据taskId对应的流程实例id 查询出当前批注信息
		List<Comment> list = this.taskService.getProcessInstanceComments(task.getProcessInstanceId());

		return list;
	}

	// 获取对应身份的审核功能信息
	@Override
	public List<String> findOutComeListByTaskId(String taskId) {
		// 返回存放连线的名称集合
		List<String> list = new ArrayList<String>();
		// 1:使用任务ID，查询任务对象
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		// 2：获取流程定义ID
		String processDefinitionId = task.getProcessDefinitionId();
		// 3：查询ProcessDefinitionEntiy对象
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService
				.getProcessDefinition(processDefinitionId);
		// 使用任务对象Task获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		// 使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
				.processInstanceId(processInstanceId)// 使用流程实例ID查询
				.singleResult();
		// 获取当前活动的id
		String activityId = pi.getActivityId();
		// 4：获取当前的活动
		ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);
		// 5：获取当前活动完成之后连线的名称
		List<PvmTransition> pvmList = activityImpl.getOutgoingTransitions();
		if (pvmList != null && pvmList.size() > 0) {
			for (PvmTransition pvm : pvmList) {
				String name = (String) pvm.getProperty("name");
				if (StringUtils.isNotBlank(name)) {
					list.add(name);
				} else {
					list.add("提交");
				}
			}
		}
		return list;
	}

	// 根据部署id删除流程定义
	@Override
	public void deleteProcessDefinitionByDeploymentId(String deploymentId) {
		this.repositoryService.deleteDeployment(deploymentId, true);
	}

	// 根据员工id查询出请假单信息
	// @Override
	// public List<VolunteerService> findActivity(Long id) {
	// VolunteerServiceExample volunteerServiceExample = new
	// VolunteerServiceExample();
	// VolunteerServiceExample.Criteria criteria =
	// volunteerServiceExample.createCriteria();
	// criteria.andCampusIdEqualTo(id);
	// List<VolunteerService> list =
	// this.volunteerServiceMapper.selectByExample(volunteerServiceExample);
	// return list;
	// }

	// @Override
	// public BaoxiaoBill findBaoxiaoBillByTaskId(String taskId) {
	// Task task = this.taskService.createTaskQuery().taskId(taskId).singleResult();
	// ProcessInstance pi = this.runtimeService.createProcessInstanceQuery()
	// .processInstanceId(task.getProcessInstanceId()).singleResult();
	// String bussiness_key = pi.getBusinessKey();
	// System.out.println(bussiness_key);
	// String id = "";
	// if (StringUtils.isNotBlank(bussiness_key)) {
	// id = bussiness_key.split("\\.")[1];
	// }
	//
	// BaoxiaoBill bill = baoxiaoBillMapper.selectByPrimaryKey(Long.parseLong(id));
	//
	// return bill;
	// }

}

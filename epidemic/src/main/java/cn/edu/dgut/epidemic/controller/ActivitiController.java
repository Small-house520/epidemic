package cn.edu.dgut.epidemic.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.dgut.epidemic.pojo.CampusUserInfo;
import cn.edu.dgut.epidemic.pojo.CustomUser;
import cn.edu.dgut.epidemic.pojo.VolunteerEnroll;
import cn.edu.dgut.epidemic.pojo.VolunteerService;
import cn.edu.dgut.epidemic.service.ActivitiService;
import cn.edu.dgut.epidemic.service.ProcessService;
import cn.edu.dgut.epidemic.service.UserService;
import cn.edu.dgut.epidemic.util.Constants;

@Controller
@RequestMapping("/activiti")
public class ActivitiController {

	@Autowired
	private ActivitiService activitiService;
	@Autowired
	private ProcessService processService;
	@Autowired
	private UserService userService;

	// 部署流程
	@RequestMapping("/deployProcess")
	public String deployProcess(String processName, MultipartFile fileName) {
		try {
			// 传入一个文件输入流和部署名字
			this.activitiService.saveNewDeploy(fileName.getInputStream(), processName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/activiti/processDefinitionList";
	}

	// 保存活动信息，开启活动审核流程
	@RequestMapping("/activityProcess")
	public String saveStartActivity(String sponsor, VolunteerService volunteerService) {

		// 设置活动发起时间
		volunteerService.setInitiateTime(new Date());

		// 1为未提交申请，2为审核中，3为活动发起成功
		volunteerService.setState("1");

		// 保存活动信息
		this.processService.saveActivity(volunteerService);

		// 启动流程(待办人)
		this.activitiService.startProcess(volunteerService.getVolunteerServiceId(), sponsor, null, 1);

		// 这种方法是隐藏了参数，链接地址上不直接暴露，
		// 用(@ModelAttribute(value = "prama")String prama)的方式获取参数。

		// 这种方法相当于在重定向链接地址上追加传递的参数
		// redirectAttributes.addFlashAttribute("flag", 1);
		return "redirect:/activiti/myTaskList?flag=1";
	}

	// 保存报名信息，开启报名审核流程
	@RequestMapping("/enrollProcess")
	public String saveStartEnroll(VolunteerEnroll volunteerEnroll, String sponsor, HttpSession session) {
		// CampusUser user = (CampusUser)
		// session.getAttribute(Constants.GLOBLE_USER_SESSION);
		CustomUser customUser = (CustomUser) SecurityUtils.getSubject().getPrincipal();
		CampusUserInfo userInfo = this.userService.getUserInfo(customUser.getCampusId());

		volunteerEnroll.setCampusId(customUser.getCampusId());
		// 设置当前时间为报名时间
		volunteerEnroll.setEnrollTime(new Date());
		// 设置录用状态为待定
		volunteerEnroll.setEmployOrNot("w");

		// 1为未提交报名，2为审核中，3为已审核
		volunteerEnroll.setState("1");

		// 保存报名信息
		this.processService.saveEnroll(volunteerEnroll);

		this.activitiService.startProcess(volunteerEnroll.getVolunteerId(), userInfo.getFullName(), sponsor, 2);

		// 这种方法是隐藏了参数，链接地址上不直接暴露，
		// 用(@ModelAttribute(value = "prama")String prama)的方式获取参数。

		// 这种方法相当于在重定向链接地址上追加传递的参数
		// redirectAttributes.addFlashAttribute("flag", 2);
		return "redirect:/activiti/myTaskList?flag=2";
	}

	// 根据待办人名称查询流程任务，并跳转到前台显示
	@RequestMapping("/myTaskList")
	// @ModelAttribute("")接收重定向携带的隐藏参数
	public ModelAndView getTaskList(Integer flag, HttpSession session) {
		ModelAndView mv = new ModelAndView();

		// 获取session中的user
		// CampusUser user = (CampusUser)
		// session.getAttribute(Constants.GLOBLE_USER_SESSION);
		CustomUser customUser = (CustomUser) SecurityUtils.getSubject().getPrincipal();
		CampusUserInfo userInfo = this.userService.getUserInfo(customUser.getCampusId());

		// 根据待办人查询任务
		List<Task> list = this.activitiService.findTaskListByName(userInfo.getFullName(), flag);

		// 将查询到的list 保存model域中
		mv.addObject("taskList", list);
		mv.addObject("flag", flag);

		mv.setViewName("transaction/mytransaction");
		return mv;
	}

	// 根据taskId查询出活动或报名信息和对应的审核信息
	@RequestMapping("/viewTaskForm")
	public String findTask(String taskId, Integer flag, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		String uri = "";
		if (flag == 1) {
			uri = "transaction/activity_approve";
			// 获取活动信息
			VolunteerService volunteerService = this.activitiService.findVolunteerServiceByTaskId(taskId);
			CampusUserInfo userInfo = this.userService.getUserInfo(volunteerService.getCampusId());
			map.put("userInfo", userInfo);
			map.put("volunteerService", volunteerService);
		} else {
			uri = "transaction/enroll_approve";
			// 获取报名信息
			VolunteerEnroll volunteerEnroll = this.activitiService.findVolunteerEnrollByTaskId(taskId);
			CampusUserInfo userInfo = this.userService.getUserInfo(volunteerEnroll.getCampusId());
			map.put("userInfo", userInfo);
			map.put("volunteerEnroll", volunteerEnroll);
		}

		// 获取对应身份的审核功能信息
		List<String> outcomeList = this.activitiService.findOutComeListByTaskId(taskId);
		if (outcomeList != null && (outcomeList.get(0).contains("提交") || outcomeList.get(0).contains("报名"))) {
			outcomeList.clear();
			outcomeList.add("提交申请");
		}
		map.put("outcomeList", outcomeList);

		// 获取批注信息
		List<Comment> comments = this.activitiService.findCommentListByTaskId(taskId);

		// 用map接收获取到的信息
		map.put("commentList", comments);
		map.put("taskId", taskId);
		// 把设置到model
		model.addAllAttributes(map);

		return uri;
	}

	// 办理任务
	@RequestMapping("/submitTask")
	public String submitTask(Integer id, String taskId, String comment, String outcome, Integer flag,
			HttpSession session, Model model) {
		// 获取个人信息
		// CampusUser user = (CampusUser)
		// session.getAttribute(Constants.GLOBLE_USER_SESSION);
		CustomUser customUser = (CustomUser) SecurityUtils.getSubject().getPrincipal();
		CampusUserInfo userInfo = this.userService.getUserInfo(customUser.getCampusId());

		// 添加批注，并把流程往前面推进
		this.activitiService.submitTask(id, taskId, comment, outcome, userInfo, flag);

		model.addAttribute("flag", flag);
		return "redirect:/process/myprocess";
	}

	// 查看当前流程图（查看当前活动节点，并使用红色的框标注）
	@RequestMapping("/viewCurrentImage")
	public String viewCurrentImage(String taskId, ModelMap model) {
		/** 一：查看流程图 */
		// 1：获取任务ID，获取任务对象，使用任务对象获取流程定义ID，查询流程定义对象
		ProcessDefinition pd = this.activitiService.findProcessDefinitionByTaskId(taskId);

		model.addAttribute("deploymentId", pd.getDeploymentId());
		model.addAttribute("imageName", pd.getDiagramResourceName());
		/** 二：查看当前活动，获取当期活动对应的坐标x,y,width,height，将4个值存放到Map<String,Object>中 */
		Map<String, Object> map = this.activitiService.findCoordingByTask(taskId);

		model.addAttribute("acs", map);
		return "process/imageview";
	}

	// 查看流程图
	@RequestMapping("/viewImage")
	public String viewImage(String deploymentId, String imageName, HttpServletResponse response) throws Exception {

		// 2：获取资源文件表（act_ge_bytearray）中资源图片输入流InputStream
		InputStream in = this.activitiService.findImageInputStream(deploymentId, imageName);
		// 3：从response对象获取输出流
		OutputStream out = response.getOutputStream();
		// 4：将输入流中的数据读取出来，写到输出流中
		for (int b = -1; (b = in.read()) != -1;) {
			out.write(b);
		}
		out.close();
		in.close();
		return null;
	}

	// 显示当前流程图的位置
	@RequestMapping("/viewCurrentImageById")
	public String viewCurrentImageById(Long id, Integer flag, ModelMap model) {
		String BUSSINESS_KEY = Constants.Activity_KEY + "." + id;
		if (flag == 2) {
			BUSSINESS_KEY = Constants.Enroll_KEY + "." + id;
		}

		// 根据BUSSINESS_KEY查询出任务信息
		Task task = this.activitiService.findTaskByBussinessKey(BUSSINESS_KEY);
		/** 一：查看流程图 */
		// 1：获取任务ID，获取任务对象，使用任务对象获取流程定义ID，查询流程定义对象
		ProcessDefinition pd = this.activitiService.findProcessDefinitionByTaskId(task.getId());

		model.addAttribute("deploymentId", pd.getDeploymentId());
		model.addAttribute("imageName", pd.getDiagramResourceName());
		/** 二：查看当前活动，获取当期活动对应的坐标x,y,width,height，将4个值存放到Map<String,Object>中 */
		Map<String, Object> map = this.activitiService.findCoordingByTask(task.getId());

		model.addAttribute("acs", map);
		return "process/viewimage";
	}

	// 查询流程信息
	@RequestMapping("/processDefinitionList")
	public ModelAndView processDefinitionList() {
		ModelAndView mv = new ModelAndView();

		// 1:查询部署对象信息，对应表（act_re_deployment）
		List<Deployment> depList = this.activitiService.findDeploymentList();
		// 2:查询流程定义的信息，对应表（act_re_procdef）
		List<ProcessDefinition> pdList = this.activitiService.findProcessDefinitionList();
		// 放置到上下文对象中
		mv.addObject("depList", depList);
		mv.addObject("pdList", pdList);

		mv.setViewName("process/process_list");
		return mv;
	}

	// 查看历史的批注信息
	@RequestMapping("/viewHisComment")
	public String viewHisComment(Integer id, Integer flag, ModelMap model) {

		String uri = "transaction/activity_comments";
		// 1：根据活动ID，查询活动信息对象
		VolunteerService volunteerService = this.processService.findActivityById(id);
		model.addAttribute("volunteerService", volunteerService);
		// 2：使用活动ID，查询历史的批注信息
		List<Comment> commentList = this.activitiService.findCommentById(id, flag);
		if (flag == 2) {
			uri = "transaction/enroll_comments";
			// 1：使用报名ID，查询报名对象
			VolunteerEnroll volunteerEnroll = this.processService.findEnrollById(id);
			model.addAttribute("volunteerEnroll", volunteerEnroll);
			// 2：使用报名ID，查询历史的批注信息
			commentList = this.activitiService.findCommentById(id, flag);
		}
		model.addAttribute("flag", flag);
		model.addAttribute("commentList", commentList);

		return uri;
	}

	// 删除部署信息
	@RequestMapping("/deploymentdel")
	public String delDeployment(String deploymentId) {
		// 使用部署对象ID，删除流程定义
		this.activitiService.deleteProcessDefinitionByDeploymentId(deploymentId);
		return "redirect:/activiti/processDefinitionList";
	}

}

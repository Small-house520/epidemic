package cn.edu.dgut.epidemic.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;

import cn.edu.dgut.epidemic.pojo.CampusUserInfo;
import cn.edu.dgut.epidemic.pojo.VolunteerEnroll;
import cn.edu.dgut.epidemic.pojo.VolunteerService;

public interface ActivitiService {

	/**
	 * 部署流程
	 * 
	 * @param in
	 * @param filename
	 */
	void saveNewDeploy(InputStream in, String filename);

	/**
	 * 启动流程(待办人)
	 * 
	 * @param id
	 * @param name
	 * @param flag：1为活动审核流程，2为报名流程
	 */
	void startProcess(Long id, String name, Integer flag);

	/**
	 * 根据待办人查询任务
	 * 
	 * @param name
	 * @param flag
	 * @return
	 */
	List<Task> findTaskListByName(String name, Integer flag);

	/**
	 * 根据taskId获取活动信息
	 * 
	 * @param taskId
	 * @return
	 */
	VolunteerService findVolunteerServiceByTaskId(String taskId);

	/**
	 * 根据taskId获取报名信息
	 * 
	 * @param taskId
	 * @return
	 */
	VolunteerEnroll findVolunteerEnrollByTaskId(String taskId);

	/**
	 * 办理任务
	 * 
	 * @param id
	 * @param taskId
	 * @param comemnt
	 * @param outcome
	 * @param userInfo
	 * @param flag
	 */
	void submitTask(Integer id, String taskId, String comemnt, String outcome, CampusUserInfo userInfo, Integer flag);

	/**
	 * 使用任务对象获取流程定义ID，查询流程定义对象
	 * 
	 * @param taskId
	 * @return
	 */
	ProcessDefinition findProcessDefinitionByTaskId(String taskId);

	/**
	 * 查看当前活动，获取当期活动对应的坐标x,y,width,height，将4个值存放到Map<String,Object>中
	 * 
	 * @param taskId
	 * @return
	 */
	Map<String, Object> findCoordingByTask(String taskId);

	/**
	 * 获取资源文件表（act_ge_bytearray）中资源图片输入流InputStream
	 * 
	 * @param deploymentId
	 * @param imageName
	 * @return
	 */
	InputStream findImageInputStream(String deploymentId, String imageName);

	/**
	 * 根据BUSSINESS_KEY查询出任务信息
	 * 
	 * @param bUSSINESS_KEY
	 * @return
	 */
	Task findTaskByBussinessKey(String bUSSINESS_KEY);

	/**
	 * 查询部署对象信息，对应表（act_re_deployment）
	 * 
	 * @return
	 */
	List<Deployment> findDeploymentList();

	/**
	 * 查询流程定义的信息，对应表（act_re_procdef）
	 * 
	 * @return
	 */
	List<ProcessDefinition> findProcessDefinitionList();

	/**
	 * 使用ID，查询历史的批注信息
	 * 
	 * @param id
	 * @return
	 */
	List<Comment> findCommentById(Integer id, Integer flag);

	/**
	 * 根据taskId获取批注信息
	 * 
	 * @param taskId
	 * @return
	 */
	List<Comment> findCommentListByTaskId(String taskId);

	/**
	 * 获取对应身份的审核功能信息
	 * 
	 * @param taskId
	 * @return
	 */
	List<String> findOutComeListByTaskId(String taskId);

	/**
	 * 使用部署对象ID，删除流程定义
	 * 
	 * @param deploymentId
	 */
	void deleteProcessDefinitionByDeploymentId(String deploymentId);

	// List<Comment> findCommentByTaskId(String taskId);
}

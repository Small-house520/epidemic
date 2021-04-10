package cn.edu.dgut.epidemic.util;

import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import cn.edu.dgut.epidemic.service.UserService;

/**
 * 监听类：activiti 工作流会签，一人通过即可进入下一环节
 */
public class MangerTaskHandlerCandidateUsers implements TaskListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask delegateTask) {
		// 获取到spring容器
		// WebApplicationContext webApplicationContext =
		// ContextLoader.getCurrentWebApplicationContext();
		UserService userService = (UserService) SpringUtil.getBean("userService");
		// 根据roleId查询管理员的用户名
		short roleId = 4;
		List<String> admin = userService.findAdmin(roleId);
		// 添加审批的人员，以下任何一人通过即可进入下一环节
		delegateTask.addCandidateUsers(admin);
		// String[] admin = { "admin", "管理员" };
		// delegateTask.addCandidateUsers(Arrays.asList(admin));

	}

}

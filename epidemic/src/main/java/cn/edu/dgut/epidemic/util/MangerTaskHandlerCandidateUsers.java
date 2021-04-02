package cn.edu.dgut.epidemic.util;

import java.util.Arrays;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * 监听类：activiti 工作流会签，一人通过即可进入下一环节
 */
public class MangerTaskHandlerCandidateUsers implements TaskListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask delegateTask) {
		// 添加审批的人员，以下任何一人通过即可进入下一环节
		String[] admin = { "admin", "管理员" };
		delegateTask.addCandidateUsers(Arrays.asList(admin));

	}

}

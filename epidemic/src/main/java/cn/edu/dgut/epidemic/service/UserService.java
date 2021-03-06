package cn.edu.dgut.epidemic.service;

import java.util.List;

import cn.edu.dgut.epidemic.pojo.CampusUser;
import cn.edu.dgut.epidemic.pojo.CampusUserInfo;
import cn.edu.dgut.epidemic.pojo.GradeClass;

public interface UserService {
	/**
	 * 添加账号（账号信息）
	 * 
	 * @param campusUser
	 * @return
	 */
	void accountAdd(CampusUser campusUser);

	/**
	 * 删除账号（账号信息）
	 * 
	 * @param ids
	 */
	void accountDel(String ids);

	/**
	 * 根据用户的账号获取用户信息
	 *
	 * @param campusId
	 *            账号，即校内人员编号
	 * @return 用户信息
	 */
	CampusUser findByCampusId(String campusId);

	/**
	 * 添加用户（包括账号信息和个人信息）
	 * 
	 * @param campusUser
	 * @param campusUserInfo
	 */
	void userAdd(CampusUser user, CampusUserInfo userInfo);

	/**
	 * 编辑账号信息
	 * 
	 * @param campusUser
	 */
	void accountEdit(CampusUser user);

	/**
	 * 查看账号信息
	 * 
	 * @return
	 */
	List<CampusUser> accountList(CampusUser user);

	/**
	 * 获取个人信息
	 * 
	 * @param campusId
	 * @return
	 */
	CampusUserInfo getUserInfo(String campusId);

	/**
	 * 编辑个人信息
	 * 
	 * @param campusUser
	 */
	void userEdit(CampusUserInfo userInfo);

	/**
	 * 查看个人信息
	 * 
	 * @param userInfo
	 * @return
	 */
	List<CampusUserInfo> userList(CampusUserInfo userInfo);

	/**
	 * 更新用户角色关系
	 * 
	 * @param campusId
	 * @param roleId
	 */
	void updateUserRole(String campusId, Short roleId);

	/**
	 * 根据用户名到数据库查询用户信息
	 * 
	 * @param username
	 * @return
	 */
	CampusUser findUserByName(String username);

	/**
	 * 获取年级班级
	 * 
	 * @return
	 */
	List<GradeClass> findClasses();

	/**
	 * 添加用户（用户个人信息）
	 * 
	 * @param userInfo
	 */
	void userInfoAdd(CampusUserInfo userInfo);

	/**
	 * 删除个人信息
	 * 
	 * @param ids
	 */
	void userDel(String ids);

	/**
	 * 根据id查询用户信息
	 * 
	 * @param ids
	 */
	List<CampusUserInfo> findUserByIds(List<String> ids);

	/**
	 * 根据roleId查询用户名
	 * 
	 * @param roleId
	 * @return
	 */
	List<String> findAdmin(Short roleId);
}

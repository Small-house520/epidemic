package cn.edu.dgut.epidemic.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.dgut.epidemic.mapper.CampusUserInfoMapper;
import cn.edu.dgut.epidemic.mapper.CampusUserMapper;
import cn.edu.dgut.epidemic.mapper.GradeClassMapper;
import cn.edu.dgut.epidemic.pojo.CampusUser;
import cn.edu.dgut.epidemic.pojo.CampusUserExample;
import cn.edu.dgut.epidemic.pojo.CampusUserExample.Criteria;
import cn.edu.dgut.epidemic.pojo.CampusUserInfo;
import cn.edu.dgut.epidemic.pojo.CampusUserInfoExample;
import cn.edu.dgut.epidemic.pojo.GradeClass;
import cn.edu.dgut.epidemic.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private CampusUserMapper userMapper;

	@Autowired
	private CampusUserInfoMapper userInfoMapper;

	@Autowired
	private GradeClassMapper classMapper;

	// 添加账号（账号信息）
	@Override
	public void accountAdd(CampusUser campusUser) {
		this.userMapper.insertSelective(campusUser);
	}

	// 删除账号（账号信息）
	@Override
	public void accountDel(String ids) {
		// 把传过来的id串拆分，并转成short[]
		String[] strs = ids.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < strs.length; i++) {
			list.add(Integer.parseInt(strs[i]));
		}
		CampusUserExample campusUserExample = new CampusUserExample();
		CampusUserExample.Criteria criteria = campusUserExample.createCriteria();
		criteria.andUserIdIn(list);
		this.userMapper.deleteByExample(campusUserExample);

	}

	// 根据用户的账号获取用户信息
	@Override
	public CampusUser findByCampusId(String campusId) {
		CampusUserExample userExample = new CampusUserExample();
		CampusUserExample.Criteria criteria = userExample.createCriteria();

		// 关联查询条件
		if (campusId != null && !"".equals(campusId)) {
			criteria.andCampusIdEqualTo(campusId);
		}

		// 根据账号查询用户信息
		List<CampusUser> users = this.userMapper.selectByExample(userExample);
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	// 添加用户（包括账号信息和个人信息）
	@Override
	public void userAdd(CampusUser campusUser, CampusUserInfo campusUserInfo) {
		this.userInfoMapper.insertSelective(campusUserInfo);
		this.userMapper.insertSelective(campusUser);
	}

	// 添加用户（用户个人信息）
	@Override
	public void userInfoAdd(CampusUserInfo userInfo) {
		this.userInfoMapper.insertSelective(userInfo);
	}

	// 删除个人信息
	@Override
	public void userDel(String ids) {
		// 把传过来的id串拆分，并转成String[]
		String[] strs = ids.split(",");
		CampusUserInfoExample userInfoExample = new CampusUserInfoExample();
		CampusUserInfoExample.Criteria criteria = userInfoExample.createCriteria();
		criteria.andCampusIdIn(Arrays.asList(strs));
		this.userInfoMapper.deleteByExample(userInfoExample);
	}

	// 编辑账号信息
	@Override
	public void accountEdit(CampusUser campusUser) {
		this.userMapper.updateByPrimaryKeySelective(campusUser);
	}

	// 查看账号信息
	@Override
	public List<CampusUser> accountList(CampusUser user) {
		List<CampusUser> list = new ArrayList<CampusUser>();
		if (user == null) {
			list = this.userMapper.selectByExample(null);
			return list;
		}
		CampusUserExample userExample = new CampusUserExample();
		Criteria criteria = userExample.createCriteria();
		if (user.getCampusId() != null && !"".equals(user.getCampusId())) {
			criteria.andCampusIdEqualTo(user.getCampusId());
		}
		if (user.getUsername() != null && !"".equals(user.getUsername())) {
			criteria.andUsernameLike("%" + user.getUsername() + "%");
		}
		list = this.userMapper.selectByExample(userExample);
		return list;
	}

	// 获取个人信息
	@Override
	public CampusUserInfo getUserInfo(String campusId) {
		CampusUserInfo userInfo = this.userInfoMapper.selectByPrimaryKey(campusId);
		return userInfo;
	}

	// 编辑个人信息
	@Override
	public void userEdit(CampusUserInfo userInfo) {
		this.userInfoMapper.updateByPrimaryKeySelective(userInfo);
	}

	// 查看个人信息
	@Override
	public List<CampusUserInfo> userList(CampusUserInfo userInfo) {
		List<CampusUserInfo> list = new ArrayList<CampusUserInfo>();
		if (userInfo == null) {
			list = this.userInfoMapper.selectByExample(null);
			return list;
		}
		CampusUserInfoExample userInfoExample = new CampusUserInfoExample();
		CampusUserInfoExample.Criteria criteria = userInfoExample.createCriteria();
		if (userInfo.getCampusId() != null && !"".equals(userInfo.getCampusId())) {
			criteria.andCampusIdEqualTo(userInfo.getCampusId());
		}
		if (userInfo.getFullName() != null && !"".equals(userInfo.getFullName())) {
			criteria.andFullNameLike("%" + userInfo.getFullName() + "%");
		}
		if (userInfo.getPost() != null && !"".equals(userInfo.getPost())) {
			criteria.andPostEqualTo(userInfo.getPost());
		}
		if (userInfo.getClassId() != null && userInfo.getClassId() > 0) {
			criteria.andClassIdEqualTo(userInfo.getClassId());
		}

		list = this.userInfoMapper.selectByExample(userInfoExample);
		return list;
	}

	// 更新用户角色关系
	@Override
	public void updateUserRole(String campusId, Short roleId) {
		// 根据campusId查询出CampusUser信息
		CampusUserExample campusUserExample = new CampusUserExample();
		CampusUserExample.Criteria criteria = campusUserExample.createCriteria();
		criteria.andCampusIdEqualTo(campusId);

		CampusUser user = this.userMapper.selectByExample(campusUserExample).get(0);
		// 跟新用户的角色信息
		user.setRoleId(roleId);
		this.userMapper.updateByPrimaryKeySelective(user);
	}

	// 根据用户名到数据库查询用户信息
	@Override
	public CampusUser findUserByName(String username) {
		CampusUserExample userExample = new CampusUserExample();
		CampusUserExample.Criteria criteria = userExample.createCriteria();

		if (username != null && !"".equals(username)) {
			criteria.andUsernameEqualTo(username);
		}
		List<CampusUser> list = this.userMapper.selectByExample(userExample);
		// 如果查询结果不为空
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 获取年级班级信息
	@Override
	public List<GradeClass> findClasses() {
		return this.classMapper.selectByExample(null);
	}

	// 根据id查询用户信息
	@Override
	public List<CampusUserInfo> findUserByIds(List<String> ids) {
		CampusUserInfoExample userInfoExample = new CampusUserInfoExample();
		CampusUserInfoExample.Criteria criteria = userInfoExample.createCriteria();
		if (ids != null && ids.size() > 0) {
			criteria.andCampusIdIn(ids);
			return this.userInfoMapper.selectByExample(userInfoExample);
		}

		return null;
	}

	// 根据roleId查询管理员的用户名
	@Override
	public List<String> findAdmin(Short roleId) {
		CampusUserExample userExample = new CampusUserExample();
		CampusUserExample.Criteria criteria = userExample.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		List<CampusUser> list = this.userMapper.selectByExample(userExample);
		List<String> admin = new ArrayList<String>();
		if (list != null && list.size() > 0) {
			for (CampusUser user : list) {
				admin.add(user.getUsername());
			}
		}
		return admin;
	}

}

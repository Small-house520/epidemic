package cn.edu.dgut.epidemic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.dgut.epidemic.mapper.CampusUserInfoMapper;
import cn.edu.dgut.epidemic.mapper.CampusUserMapper;
import cn.edu.dgut.epidemic.pojo.CampusUser;
import cn.edu.dgut.epidemic.pojo.CampusUserExample;
import cn.edu.dgut.epidemic.pojo.CampusUserExample.Criteria;
import cn.edu.dgut.epidemic.pojo.CampusUserInfo;
import cn.edu.dgut.epidemic.pojo.CampusUserInfoExample;
import cn.edu.dgut.epidemic.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private CampusUserMapper userMapper;

	@Autowired
	private CampusUserInfoMapper userInfoMapper;

	// 根据用户的账号获取用户信息
	@Override
	public CampusUser findByCampusId(Long campusId) {
		CampusUserExample userExample = new CampusUserExample();
		CampusUserExample.Criteria criteria = userExample.createCriteria();

		// 关联查询条件
		criteria.andCampusIdEqualTo(campusId);
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
		this.userMapper.insertSelective(campusUser);
		this.userInfoMapper.insertSelective(campusUserInfo);
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
		if (user.getCampusId() != null && user.getCampusId() > 0) {
			criteria.andCampusIdEqualTo(user.getCampusId());
		}
		if (user.getUsername() != null && !"".equals(user.getUsername())) {
			criteria.andUsernameLike(user.getUsername());
		}
		list = this.userMapper.selectByExample(userExample);
		return list;
	}

	// 获取个人信息
	@Override
	public CampusUserInfo getUserInfo(Long campusId) {
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
		if (userInfo.getCampusId() != null && userInfo.getCampusId() > 0) {
			criteria.andCampusIdEqualTo(userInfo.getCampusId());
		}
		if (userInfo.getFullName() != null && !"".equals(userInfo.getFullName())) {
			criteria.andFullNameLike(userInfo.getFullName());
		}
		if (userInfo.getClassId() != null && userInfo.getClassId() > 0) {
			criteria.andClassIdEqualTo(userInfo.getClassId());
		}
		if (userInfo.getPhoneNumber() != null && !"".equals(userInfo.getPhoneNumber())) {
			criteria.andPhoneNumberLike(userInfo.getPhoneNumber());
		}
		list = this.userInfoMapper.selectByExample(userInfoExample);
		return list;
	}
}

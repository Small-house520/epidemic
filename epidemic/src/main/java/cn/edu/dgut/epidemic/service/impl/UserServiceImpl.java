package cn.edu.dgut.epidemic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.dgut.epidemic.mapper.CampusUserMapper;
import cn.edu.dgut.epidemic.pojo.CampusUser;
import cn.edu.dgut.epidemic.pojo.CampusUserExample;
import cn.edu.dgut.epidemic.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private CampusUserMapper userMapper;

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
}

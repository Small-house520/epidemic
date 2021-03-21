package cn.edu.dgut.epidemic.service;

import cn.edu.dgut.epidemic.pojo.CampusUser;

public interface UserService {
    /**
     * 根据用户的账号获取用户信息
     *
     * @param campusId 账号，即校内人员编号
     * @return 用户信息
     */
    CampusUser findByCampusId(Long campusId);
}

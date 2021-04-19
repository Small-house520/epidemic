package cn.edu.dgut.epidemic.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.dgut.epidemic.pojo.CampusUserInfo;
import cn.edu.dgut.epidemic.pojo.CustomUser;
import cn.edu.dgut.epidemic.pojo.VolunteerEnroll;
import cn.edu.dgut.epidemic.pojo.VolunteerEnrollDetail;
import cn.edu.dgut.epidemic.pojo.VolunteerService;
import cn.edu.dgut.epidemic.service.UserService;
import cn.edu.dgut.epidemic.service.VolunteersService;
import cn.edu.dgut.epidemic.util.ExcelUtil;

@Controller
@RequestMapping("/volunteer")
public class VolunteerController {

	@Autowired
	private UserService userService;

	@Autowired
	private VolunteersService volunteersService;

	// 跳转到发起志愿活动页面
	@RequestMapping("/toStart")
	public String toStart(Model model, HttpSession session) {
		// 取出session中的账号信息
		// CampusUser campusUser = (CampusUser)
		// session.getAttribute(Constants.GLOBLE_USER_SESSION);
		CustomUser customUser = (CustomUser) SecurityUtils.getSubject().getPrincipal();

		CampusUserInfo userInfo = this.userService.getUserInfo(customUser.getCampusId());

		model.addAttribute("userInfo", userInfo);

		return "volunteer/start_activities";
	}

	// 发起志愿活动
	@RequestMapping("/sponsor")
	public String sponsor(VolunteerService volunteerInfo) {

		this.volunteersService.sponsor(volunteerInfo);

		return "redirect:/toStart";
	}

	// 查看志愿活动信息
	@RequestMapping("/activities")
	public String getActivities(Model model) {
		List<VolunteerService> list = this.volunteersService.getActivities(null);
		// 根据id获取活动发起者个人信息
		List<String> ids = new ArrayList<String>();
		for (VolunteerService volunteerService : list) {
			ids.add(volunteerService.getCampusId());
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);
		model.addAttribute("userInfo", userInfos);
		model.addAttribute("volunteerInfo", list);
		return "volunteer/volunteer_activities";
	}

	// 根据条件查询志愿活动信息
	@RequestMapping("/findActivities")
	@ResponseBody
	public Map<String, Object> findActivities(VolunteerService volunteerInfo) {
		List<VolunteerService> list = this.volunteersService.getActivities(volunteerInfo);
		// 根据id获取活动发起者个人信息
		List<String> ids = new ArrayList<String>();
		for (VolunteerService volunteerService : list) {
			ids.add(volunteerService.getCampusId());
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userInfo", userInfos);
		map.put("volunteerInfo", list);
		return map;
	}

	// 根据志愿活动id查询该活动的报名情况
	@RequestMapping("/findEnroll")
	public String findEnroll(Integer volunteerServiceId, Model model) {
		List<VolunteerEnroll> list = this.volunteersService.findEnrollById(volunteerServiceId);
		// 根据id获取活动发起者个人信息
		List<String> ids = new ArrayList<String>();
		for (VolunteerEnroll volunteerEnroll : list) {
			ids.add(volunteerEnroll.getCampusId());
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);

		List<VolunteerEnrollDetail> enrollDetails = new ArrayList<VolunteerEnrollDetail>();
		for (CampusUserInfo userInfo : userInfos) {
			VolunteerEnrollDetail enrollDetail = new VolunteerEnrollDetail();
			for (VolunteerEnroll volunteerEnroll : list) {
				if (userInfo.getCampusId().equals(volunteerEnroll.getCampusId())) {
					enrollDetail.setUserInfo(userInfo);
					enrollDetail.setVolunteerEnroll(volunteerEnroll);
					enrollDetails.add(enrollDetail);
					break;
				}
			}
		}

		model.addAttribute("enrollDetails", enrollDetails);
		return "volunteer/volunteer_enroll";
	}

	// 根据条件查询志愿活动报名信息
	@RequestMapping("/findEnrollDetails")
	@ResponseBody
	public Map<String, Object> findEnrollDetails(VolunteerEnroll enrollInfo) {
		List<VolunteerEnroll> list = this.volunteersService.findEnrollDetails(enrollInfo);
		// 根据id获取活动发起者个人信息
		List<String> ids = new ArrayList<String>();
		if (list != null && list.size() > 0) {
			for (VolunteerEnroll volunteerEnroll : list) {
				ids.add(volunteerEnroll.getCampusId());
			}
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);

		List<VolunteerEnrollDetail> enrollDetails = new ArrayList<VolunteerEnrollDetail>();
		if (userInfos != null && userInfos.size() > 0) {
			for (CampusUserInfo userInfo : userInfos) {
				VolunteerEnrollDetail enrollDetail = new VolunteerEnrollDetail();
				for (VolunteerEnroll volunteerEnroll : list) {
					if (userInfo.getCampusId().equals(volunteerEnroll.getCampusId())) {
						enrollDetail.setUserInfo(userInfo);
						enrollDetail.setVolunteerEnroll(volunteerEnroll);
						enrollDetails.add(enrollDetail);
						break;
					}
				}
			}
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("enrollDetails", enrollDetails);
		map.put("enrollInfo", enrollInfo);
		return map;
	}

	// 把报名志愿者名单到处excel
	@RequestMapping("/exportExcel")
	public void exportExcel(VolunteerEnroll enrollInfo, HttpServletResponse response) {
		String excelName = "报名志愿者名单.xlsx";// 文件名
		String sheetName = "报名志愿者名单";// sheetN名
		List<String> columnList = new ArrayList<String>();// 每列的标题名
		columnList.add("序号");
		columnList.add("校园编号");
		columnList.add("姓名");
		columnList.add("性别");
		columnList.add("手机号码");
		columnList.add("紧急联系人");
		columnList.add("紧急联系人手机号码");
		columnList.add("是否符合条件");
		columnList.add("是否录用");
		columnList.add("报名时间");
		columnList.add("志愿者备注");
		columnList.add("发起人备注");

		List<VolunteerEnroll> list = this.volunteersService.findEnrollDetails(enrollInfo);
		// 根据id获取活动发起者个人信息
		List<String> ids = new ArrayList<String>();
		if (list != null && list.size() > 0) {
			for (VolunteerEnroll volunteerEnroll : list) {
				ids.add(volunteerEnroll.getCampusId());
			}
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);

		List<VolunteerEnrollDetail> enrollDetails = new ArrayList<VolunteerEnrollDetail>();
		if (userInfos != null && userInfos.size() > 0) {
			for (CampusUserInfo userInfo : userInfos) {
				VolunteerEnrollDetail enrollDetail = new VolunteerEnrollDetail();
				for (VolunteerEnroll volunteerEnroll : list) {
					if (userInfo.getCampusId().equals(volunteerEnroll.getCampusId())) {
						enrollDetail.setUserInfo(userInfo);
						enrollDetail.setVolunteerEnroll(volunteerEnroll);
						enrollDetails.add(enrollDetail);
						break;
					}
				}
			}
		}

		List<List<String>> dataList = new ArrayList<>();// 导出的数据
		if (enrollDetails != null && enrollDetails.size() > 0) {
			VolunteerService volunteerService = this.volunteersService
					.findActivityById(enrollDetails.get(0).getVolunteerEnroll().getVolunteerServiceId());
			if (volunteerService != null) {
				excelName = volunteerService.getTitle() + "-报名志愿者名单.xlsx";
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			List<String> data = new ArrayList<String>();
			for (VolunteerEnrollDetail enrollDetail : enrollDetails) {
				data = new ArrayList<String>();
				data.add(enrollDetail.getUserInfo().getCampusId());
				data.add(enrollDetail.getUserInfo().getFullName());
				if ("m".equals(enrollDetail.getUserInfo().getGender())) {
					data.add("男");
				} else {
					data.add("女");
				}
				data.add(enrollDetail.getUserInfo().getPhoneNumber());
				data.add(enrollDetail.getUserInfo().getEmergencyContact());
				data.add(enrollDetail.getUserInfo().getEmergencyContactPhone());
				if ("y".equals(enrollDetail.getVolunteerEnroll().getIsQualified())) {
					data.add("是");
				} else {
					data.add("否");
				}
				if ("y".equals(enrollDetail.getVolunteerEnroll().getEmployOrNot())) {
					data.add("是");
				} else if ("n".equals(enrollDetail.getVolunteerEnroll().getEmployOrNot())) {
					data.add("否");
				} else {
					data.add("待定");
				}
				data.add(sdf.format(enrollDetail.getVolunteerEnroll().getEnrollTime()));
				data.add(enrollDetail.getVolunteerEnroll().getVolunteerRemarks());
				data.add(enrollDetail.getVolunteerEnroll().getSponsorRemarks());
				dataList.add(data);
			}
		}

		ExcelUtil.uploadExcelAboutUser(response, excelName, sheetName, columnList, dataList);
	}
}

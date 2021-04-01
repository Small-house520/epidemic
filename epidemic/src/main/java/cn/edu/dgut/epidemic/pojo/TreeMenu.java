package cn.edu.dgut.epidemic.pojo;

import java.util.List;

/**
 * 树型菜单
 */
public class TreeMenu {

	private int id;
	private String name;

	private List<Permission> subMenu;// 子菜单

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Permission> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<Permission> subMenu) {
		this.subMenu = subMenu;
	}

}

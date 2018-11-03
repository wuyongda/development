package com.product.sysmenu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.sysmenu.bean.SysMenu;
import com.product.sysmenu.bean.SysMenuDTO;
import com.product.sysmenu.bean.TreeNode;
import com.product.sysmenu.dao.ISysMenuMapper;
import com.product.sysmenu.service.ISysMenuService;

@Service
public class SysMenuServiceImpl implements ISysMenuService {

    @Autowired
    private ISysMenuMapper sysMenuMapper;
    
    @Override
    public List<TreeNode<SysMenu>> sysMenuTree(SysMenuDTO dto) {
    	List<SysMenu> sysMenus = sysMenuMapper.selectList(dto);
    	
    	List<TreeNode<SysMenu>> treeNodes = new ArrayList<TreeNode<SysMenu>>();
    	Map<Integer, TreeNode<SysMenu>> treeMap = new HashMap<Integer, TreeNode<SysMenu>>();
    	
    	for (SysMenu sysMenu : sysMenus) {
    		this.initTree(sysMenu, treeMap, treeNodes);
		}
    	
        return treeNodes;
    }

    /**
     * 基于引用传递的方式构建菜单树
     * @param sysMenu
     * @param treeMap
     * @param treeNodes
     * @return
     */
	private void initTree(SysMenu sysMenu, Map<Integer, TreeNode<SysMenu>> treeMap, List<TreeNode<SysMenu>> treeNodes) {
		
		TreeNode<SysMenu> treeNode = new TreeNode<SysMenu>();
		treeNode.setNode(sysMenu);
		
		if (treeMap.containsKey(sysMenu.getId())) {
			treeMap.get(sysMenu.getId()).setNode(sysMenu);
		} else {
			treeMap.put(sysMenu.getId(), treeNode);
		}
		
		if (sysMenu.getParentId() == 0) {
			treeNodes.add(treeMap.get(sysMenu.getId()));
		} else {
			if(treeMap.containsKey(sysMenu.getParentId())) {
				treeMap.get(sysMenu.getParentId()).addChildren(treeNode);
			} else {
				TreeNode<SysMenu> parentNode = new TreeNode<SysMenu>();
				parentNode.addChildren(treeNode);
				treeMap.put(sysMenu.getParentId(), parentNode);
			}
		}
	}

	@Override
	public List<SysMenu> selectSysMenu(SysMenu sysMenu) {
		SysMenuDTO dto = new SysMenuDTO();
		dto.setSysMenu(sysMenu);
		return sysMenuMapper.selectList(dto);
	}

}

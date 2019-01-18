package com.product.sysmenu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.security.util.SecurityUtils;
import com.product.sysmenu.bean.SysMenu;
import com.product.sysmenu.bean.TreeNode;
import com.product.sysmenu.dao.ISysMenuMapper;
import com.product.sysmenu.service.ISysMenuService;
import com.product.util.KeyGeneratorUtil;

@Service
public class SysMenuServiceImpl implements ISysMenuService {

    @Autowired
    private ISysMenuMapper sysMenuMapper;
    
    private void menuAuthorityFilter(List<SysMenu> sysMenus) {
    	// 根据当前登录人的角色信息查询菜单权限
    	List<Long> menuIds = sysMenuMapper.selectRoleMenu(SecurityUtils.getLoginUserRole());
    	
    	// 将List转化的Set
    	Set<Long> authority = new HashSet<Long>(menuIds);
    	
    	// 遍历菜单对象进行权限过滤
    	Iterator<SysMenu> iterator = sysMenus.iterator();
		while(iterator.hasNext()) {
			if (!authority.contains(iterator.next().getId())) {
				iterator.remove();
			}
		}
	}
    
    @Override
    public List<TreeNode<SysMenu>> sysMenuTree(SysMenu sysMenu) {
    	// 查询所有菜单信息
    	List<SysMenu> sysMenus = sysMenuMapper.selectList(sysMenu);
    	
    	// 根据权限过滤菜单信息
		this.menuAuthorityFilter(sysMenus);
    	
    	List<TreeNode<SysMenu>> treeNodes = new ArrayList<TreeNode<SysMenu>>();
    	Map<Long, TreeNode<SysMenu>> treeMap = new HashMap<Long, TreeNode<SysMenu>>();
    	
    	for (SysMenu menu : sysMenus) {
    		this.initTree(menu, treeMap, treeNodes);
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
	private void initTree(SysMenu sysMenu, Map<Long, TreeNode<SysMenu>> treeMap, List<TreeNode<SysMenu>> treeNodes) {
		
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
		return sysMenuMapper.selectList(sysMenu);
	}

    @Override
    public int save(SysMenu sysMenu) {
        if (sysMenu.getId() == null) {
            sysMenu.setId(KeyGeneratorUtil.getNextLong());
            return sysMenuMapper.insert(sysMenu);
        } else {
            return sysMenuMapper.updateByPrimaryKey(sysMenu);
        }
        
    }

    @Override
    public List<SysMenu> menuItems(Long id) {
    	List<SysMenu> sysMenus = sysMenuMapper.menuItems(id);
    	
    	// 根据权限过滤菜单信息
		this.menuAuthorityFilter(sysMenus);
    	
        return sysMenus;
    }

	@Override
	public List<TreeNode<SysMenu>> menuAuthority(Long roleId) {
		// 查询所有菜单信息
    	List<SysMenu> sysMenus = sysMenuMapper.selectList(new SysMenu());
    	
    	List<TreeNode<SysMenu>> treeNodes = new ArrayList<TreeNode<SysMenu>>();
    	Map<Long, TreeNode<SysMenu>> treeMap = new HashMap<Long, TreeNode<SysMenu>>();
    	
    	for (SysMenu menu : sysMenus) {
    		this.initTree(menu, treeMap, treeNodes);
		}
    	
    	List<Long> roleIds = new ArrayList<Long>();
		roleIds.add(roleId);
		
		// 根据当前登录人的角色信息查询菜单权限
    	List<Long> menuIds = sysMenuMapper.selectRoleMenu(roleIds);
    	
    	// 将List转化的Set
    	Set<Long> authority = new HashSet<Long>(menuIds);
    	// 根据权限过滤菜单信息
		this.menuAuthorityCheckedFilter(authority, treeNodes);
    	
        return treeNodes;
	}

	private void menuAuthorityCheckedFilter(Set<Long> authority, List<TreeNode<SysMenu>> treeNodes) {
    	// 遍历菜单对象进行权限过滤
    	for (int i = 0; i < treeNodes.size(); i++) {
    		TreeNode<SysMenu> node = treeNodes.get(i);
    		if (authority.contains(node.getNode().getId())) {
    			node.setChecked(Boolean.TRUE);
    			if (!node.getChildren().isEmpty()) {
					this.menuAuthorityCheckedFilter(authority, node.getChildren());
				}
			}
		}
	}

}

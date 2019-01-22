package com.product.sysuser.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.product.model.Result;
import com.product.sysrole.bean.SysRole;
import com.product.sysrole.service.ISysRoleService;
import com.product.sysuser.bean.SysUser;
import com.product.sysuser.service.ISysUserService;

@RestController
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;
    
    @Autowired
    private ISysRoleService sysRoleService;
    
    /**
     * 新增用户初始化数据
     * @param id 用户主键
     * @return
     */
    @RequestMapping("/sysUser/initAdd")
    public Result<Object> initAdd() {
    	// 查询所有角色信息
    	List<SysRole> roles = sysRoleService.findSysRoles(null);
    	
    	// 封装返回数据
    	Map<String, Object> map = new HashMap<String, Object>(3);
    	map.put("roles", roles);
    	
    	return Result.success(map);
    }
    
    /**
     * 修改用户初始化数据
     * @param id 用户主键
     * @return
     */
    @RequestMapping("/sysUser/initUpdate")
    public Result<Object> initUpdate(Long id) {
    	// 查询用户信息
    	SysUser user = sysUserService.findSysUser(id);
    	
    	// 查询用户所属角色信息
    	List<SysRole> userRoles = sysRoleService.findSysRolesByUserId(id);
    	
    	// 查询所有角色信息
    	List<SysRole> roles = sysRoleService.findSysRoles(null);
    	
    	// 封装返回数据
    	Map<String, Object> map = new HashMap<String, Object>(3);
    	map.put("user", user);
    	map.put("userRoles", userRoles);
    	map.put("roles", roles);
    	
    	return Result.success(map);
    }
    
    @RequestMapping("/sysUser/{id}")
    public Result<SysUser> findSysUser(@PathVariable Long id) {
    	SysUser sysUser = sysUserService.findSysUser(id);
    	return Result.success(sysUser);
    }
    
    @RequestMapping("/sysUser")
    public Result<PageInfo<SysUser>> findSysUsers(Page<SysUser> page, SysUser sysUser) {
    	PageHelper.startPage(page.getPageNum(), page.getPageSize());
    	List<SysUser> sysUsers = sysUserService.findSysUsers(sysUser);
    	PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(sysUsers);
    	return Result.success(pageInfo);
    }
    
    /**
     * 保存用户信息
     * @param sysUser
     * @param role
     * @return
     */
    @Transactional
    @RequestMapping("/sysUser/save")
    public Result<Long> save(SysUser sysUser, String role) {
    	// 保存用户信息
    	sysUserService.save(sysUser);
    	
    	// 删除用户的旧角色信息
    	sysRoleService.deleteSysUserRole(sysUser.getId());
    	
    	// 保存用户的新角色信息
    	if (StringUtils.isNotBlank(role)) {
    		String[] roles = role.split(",");
        	for (String roleId : roles) {
        		sysRoleService.saveSysUserRole(Long.valueOf(roleId), sysUser.getId());
    		}
		}
    	
        return Result.success(sysUser.getId());
    }
    
    /**
     * 删除用户信息
     * @param id 用户主键
     * @return
     */
    @Transactional
    @RequestMapping("/sysUser/delete")
    public Result<Long> delete(Long id) {
    	// 删除用户信息
    	sysUserService.delete(id);
    	// 删除用户的角色信息
    	sysRoleService.deleteSysUserRole(id);
    	return Result.success(id);
    }
}

package com.evan.wj.Reaml;

import com.evan.wj.Pojo.AdminPermission;
import com.evan.wj.Pojo.AdminRole;
import com.evan.wj.Pojo.User;
import com.evan.wj.Service.AdminRoleService;
import com.evan.wj.Service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

/**
 * Code by langlang on 2020/2/25
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Autowired
    AdminRoleService adminRoleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //授权逻辑
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userInfo  = (User)principals.getPrimaryPrincipal();
        //枚举用户存在的角色，根据角色id查找用户的权限
        for(AdminRole role:userInfo.getRoles()){
            authorizationInfo.addRole(role.getName());
            //通过用户的角色id查询该角色具有的权限
            AdminRole sysRole = adminRoleService.selectRoleByIdWithPermission(role.getId());//获取角色
            //将权限加入到用户授权信息中
            for(AdminPermission p:sysRole.getPerms()){
                authorizationInfo.addStringPermission(p.getUrl());
            }
        }

        //设置权限信息.
//     authorizationInfo.setStringPermissions(getStringPermissions(userInfo.getRoleList()));

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //认证逻辑
        String userName = token.getPrincipal().toString();
        User user = userService.getUserByname(userName);
        if (ObjectUtils.isEmpty(user)) {
            throw new UnknownAccountException();
        }
        String passwordInDB = user.getPassword();
        String salt = user.getSalt();
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, passwordInDB, ByteSource.Util.bytes(salt), getName());
        return authenticationInfo;
    }
}

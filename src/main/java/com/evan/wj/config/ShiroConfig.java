package com.evan.wj.config;

import com.evan.wj.Reaml.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Code by langlang on 2020/2/25
 */
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean ShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        Map<String,String> filterMap = new LinkedHashMap<String,String>();
//        filterMap.put("/addUser","authc");
//        filterMap.put("/updateUser","authc");
        filterMap.put("/index", "anon");
        filterMap.put("/login", "anon");
        filterMap.put("/regist", "anon");
        filterMap.put("/regist.do", "anon");
        filterMap.put("/RegistSuccess", "anon");
        //取消硬编码

//        filterMap.put("/addUser","perms[user:add]");
        filterMap.put("/*", "authc");

        filterFactoryBean.setLoginUrl("/tologin");

        //设置没有权限界面
        filterFactoryBean.setUnauthorizedUrl("/noAuth");

        filterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return filterFactoryBean;
    }

    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager DefaultWebSecurityManager(UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    @Bean(name = "userRealm")
    public UserRealm Realm() {
        return new UserRealm();
    }
}

package com.evan.wj.config;

//import com.evan.wj.Filter.URLPathMatchingFilter;
import com.evan.wj.Reaml.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Code by langlang on 2020/2/25
 */
@Configuration
public class ShiroConfig {


    @Bean
    public ShiroFilterFactoryBean ShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(defaultWebSecurityManager);

//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
//
//
//        filterChainDefinitionMap.put("/api/menu", "authc");
//        filterChainDefinitionMap.put("/api/admin/**", "authc");
//
//        filterChainDefinitionMap.put("/api/admin/**", "url");  // 自定义过滤器设置 3，设置过滤路径
//
//        filterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return filterFactoryBean;
    }
//
//    public URLPathMatchingFilter getURLPathMatchingFilter() {
//        return new URLPathMatchingFilter();
//    }

    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager DefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    @Bean(name = "userRealm")
    public UserRealm Realm() {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}

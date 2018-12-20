package com.lc.web.login.config.shiro;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.lc.web.login.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/14/014.
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securitymanager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securitymanager);
        Map<String,String> filterMap = new LinkedHashMap<String,String>();

        filterMap.put("/lib/**","anon");
        filterMap.put("/js/**","anon");
        filterMap.put("/staticResource/**","anon");
        filterMap.put("/login","anon");
        filterMap.put("/login/login.html","anon");




        filterMap.put("/addUser","perms[data:useradd]");
        filterMap.put("/updateUser/**","perms[data:userupdate]");
        filterMap.put("/deleteuser/**","perms[data:userdelete]");
        filterMap.put("/addPoint","perms[data:treeadd]");
        filterMap.put("/updatePoint/**","perms[data:treeupdate]");
        filterMap.put("/deletePoint/**","perms[data:treedelete]");
        filterMap.put("/**","authc");
        bean.setFilterChainDefinitionMap(filterMap);
        bean.setLoginUrl("/toLogin");
        bean.setUnauthorizedUrl("/unAuth");




        return  bean;
    }
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(UserRealm realm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        return  manager;
    }
    @Bean
    public UserRealm userRealm (){
        UserRealm realm = new UserRealm();
        return realm;
    }

    /**
     * shiro方言  支持shiro标签
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

}

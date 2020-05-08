package com.dhcc.base;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

@Configuration
public class PageHelperConfig {

	 @Bean  
     public PageHelper pageHelper() {  
         PageHelper pageHelper = new PageHelper();  
         Properties p = new Properties();  
         p.setProperty("dialect", "mysql");  
         p.setProperty("supportMethodsArguments", "true");  
         p.setProperty("returnPageInfo", "check");  
         pageHelper.setProperties(p);  
         return pageHelper;  
     }  
}

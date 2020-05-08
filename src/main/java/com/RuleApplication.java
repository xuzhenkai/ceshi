package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter; 

import com.dhcc.rule.hession.OurServiceExporter;
import com.dhcc.rule.hession.RuleServer;

@MapperScan(basePackages= {"com.dhcc.**.mapper"}) 
@SpringBootApplication
//@EnableFeignClients

//@EnableDiscoveryClient //注册eureka服务
public class RuleApplication extends SpringBootServletInitializer {
	
	@Autowired
	private RuleServer ruleServerHessian;
/**/
	public static void main(String[] args) {
		SpringApplication.run(RuleApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RuleApplication.class);
	}
	
	//发布服务
    @Bean(name = "/hessian/HessianService")
    public HessianServiceExporter accountService() {
    	OurServiceExporter exporter = new OurServiceExporter();
        exporter.setService(ruleServerHessian);
        exporter.setServiceInterface(RuleServer.class);
        return exporter;
    }

}

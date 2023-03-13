package com.tiffinservice.TiffinService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.tiffinservice.TiffinService.Repositry.UserRepositry;

@EnableJpaRepositories(basePackageClasses = UserRepositry.class)
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TiffinServiceApplication {
	
//	private UserRepositry userrepo;
	public static void main(String[] args) {
		
		 org.springframework.context.ApplicationContext context =  SpringApplication.run(TiffinServiceApplication.class, args);
		 ;//=  context.getBean(UserRepositry.class);
		 System.out.println(context.getBeanDefinitionCount());
		 
//		 System.out.println(context.getBeanDefinitionCount());
////		 UserRepositry userRepositry2 = context.getBean(UserRepositry.class);;
//		User user= new User();
//		user.setUserFirstName("Yash");
//		user.setUserLastName("Sarda");
//		user.setUserAddress("Pune");
//		
//		User k = userRepositry.save(user);
//		System.out.println(k);
//		
		
	}

}

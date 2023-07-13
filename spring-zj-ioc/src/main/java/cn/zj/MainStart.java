package cn.zj;

import cn.zj.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.zj")
public class MainStart {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(MainStart.class);
		UserServiceImpl bean = context.getBean(UserServiceImpl.class);
		bean.sayHi();


	}
}

package cn.zj.ioc;


import cn.zj.ioc.bean.Cat;
import cn.zj.ioc.bean.Dog;
import cn.zj.ioc.bean.Lion;
import cn.zj.ioc.bean.Rat;
import cn.zj.ioc.component.MyImportBeanDefinitionRegistrar;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("cn.zj.ioc")
@Import(MyImportBeanDefinitionRegistrar.class)
public class MainStart {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(MainStart.class);
		Cat cat = (Cat) context.getBean("cat");
		Dog dog = (Dog) context.getBean("dog");
		Rat tiger = (Rat) context.getBean("tiger");
		Rat rat = (Rat) context.getBean("rat");

		System.out.println("cat name:"+cat.getName());
		System.out.println("dog name "+dog.getName());
		System.out.println("tiger name "+tiger.getName());
		System.out.println("rat name "+rat.getName());

		Lion lion = (Lion) context.getBean("lion");
		System.out.println("lion name "+lion.getName());
		Lion lion2 = (Lion) context.getBean("lion2");
		System.out.println("lion2 name "+lion2.getName());


	}
}

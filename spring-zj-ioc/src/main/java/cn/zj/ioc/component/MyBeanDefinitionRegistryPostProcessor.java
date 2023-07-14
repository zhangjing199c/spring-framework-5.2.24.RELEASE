package cn.zj.ioc.component;

import cn.zj.ioc.bean.Dog;
import cn.zj.ioc.bean.Rat;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	/**
	 * 对bean 操作进行增删查改
	 * @param registry the bean definition registry used by the application context
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		// 增加bean定义,Dog类并没有加@Component注解，通过此方法加入beanDefinition后 可以通过getBean获取到
		RootBeanDefinition beanDefinition=new RootBeanDefinition();
		beanDefinition.setBeanClass(Dog.class);
		registry.registerBeanDefinition("dog",beanDefinition);

	}

	/**
	 * 修改bean定义
	 * @param beanFactory the bean factory used by the application context
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// 获得bean定义
		GenericBeanDefinition tiger = (GenericBeanDefinition) beanFactory.getBeanDefinition("tiger");
		// 修改Class
		tiger.setBeanClass(Rat.class);
		// 设置默认值 相当于xml:<property name="name" value="老鼠"/>
		tiger.getPropertyValues().addPropertyValue(new PropertyValue("name","老鼠"));

		// 设置构造函数 相当于xml:<constructor-arg index="0" value="徐庶"/>
		// car.getConstructorArgumentValues().addIndexedArgumentValue(0,"徐庶2");

		// 自动装配方式
		//car.setAutowireMode(AUTOWIRE_BY_NAME);
		// 强制依赖检查：
		// car.setDependencyCheck(AbstractBeanDefinition.DEPENDENCY_CHECK_ALL);

		//car.setInitMethodName("initMethod");

	}
}

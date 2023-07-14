package cn.zj.ioc.component;

import cn.zj.ioc.bean.Lion;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * 把bean注入到spring容器不止有 @Service @Component等注解方式；还可以实现此接口
	 * @param importingClassMetadata annotation metadata of the importing class
	 * @param registry current bean definition registry
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		BeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClassName(Lion.class.getName());
		MutablePropertyValues values = beanDefinition.getPropertyValues();
		values.addPropertyValue("age", 1);
		values.addPropertyValue("name", "lion2");
		//这里注册bean
		registry.registerBeanDefinition("lion2", beanDefinition );
	}
}

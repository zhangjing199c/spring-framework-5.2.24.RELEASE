package cn.zj.ioc.component;

import cn.zj.ioc.bean.Cat;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyInstantiationAwareBeanPostProcessor  implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		// 这里在createBean->resolveBeforeInstantiation(beanName, mbdToUse)，方法中会调用，如果这个方法返回bean就不会走下面生成Bean的方法，直接返回
		/**
		 * 		// Give BeanPostProcessors a chance to return a proxy instead of the target bean instance.
		 * 		Object bean = resolveBeforeInstantiation(beanName, mbdToUse);
		 * 		if (bean != null) {
		 * 			return bean;
		 *     }
		 */
		if(beanClass== Cat.class) {
			Cat cat = new Cat();
			cat.setName("cat-bean create by postProcessBeforeInstantiation ");
			return cat;
		}
		return null;
	}
}

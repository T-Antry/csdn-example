package org.antry.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author: T_Antry
 * @date: 2021/10/21 8:56
 * @description:
 */
public class MyBeanFactoryPostProcessor  implements BeanFactoryPostProcessor {
    public MyBeanFactoryPostProcessor() {
        super();
        System.out.println("实现类构造器：BeanFactoryPostProcessor");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition user = configurableListableBeanFactory.getBeanDefinition("user");
        user.getPropertyValues().addPropertyValue("name", "modify");
     //   BeanDefinition otherUser = configurableListableBeanFactory.getBeanDefinition("otherUser");
 //      otherUser.getPropertyValues().addPropertyValue("name", "otherModify");
        System.out.println("BeanFactoryPostProcessor=============|调用|==postProcessBeanFactory==user-------name修改成modify");
    //    System.out.println("BeanFactoryPostProcessor=============|调用|==postProcessBeanFactory==otherUser--name修改成otherUser");
    }
}

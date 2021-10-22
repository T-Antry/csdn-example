package org.antry.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;

/**
 * @author: T_Antry
 * @date: 2021/10/21 8:57
 * @description:
 */
public class MyBeanPostProcessor  implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        super();
        System.out.println("实现类构造器：BeanPostProcessor");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor====================|调用|==postProcessBeforeInitialization==对属性进行更改===在初始化之前执行的方法");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor====================|调用|==postProcessAfterInitialization===对属性进行更改===在初始化之后执行的方法");
        return bean;
    }


}

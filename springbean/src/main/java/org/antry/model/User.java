package org.antry.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author: T_Antry
 * @date: 2021/10/21 8:54
 * @description:
 */
public class User implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name ;

    public User() {
        System.out.println("【第一步】构造器: 执行无参构造创建bean实例");
    }

    private BeanFactory beanFactory;
    private String beanName;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【第二步】: 注入属性调用set方法设置属性值:"+name);
        this.name = name;
    }

    @Override//BeanFactoryAware接口方法
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【User】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    @Override//BeanNameAware接口方法
    public void setBeanName(String s) {
        System.out.println("【User】调用BeanNameAware.setBeanName():"+s);
        this.beanName  = s;
    }

    @Override//InitializingBean接口方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("【User】调用InitializingBean.afterPropertiesSet()");
    }

    @Override//DisposableBean接口方法
    public void destroy() throws Exception {
        System.out.println("【User】调用DisposableBean.destroy()");
    }
    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("【第三步】: init-method执行user-bean初始化的方法");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestory() {
        System.out.println("【第五步】: destroy-method执行user-bean销毁的方法");
    }
}

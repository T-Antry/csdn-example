package com.npt.condition;

/**
 * 使用多个Condition实例实现等待/通知机制：
 */
public class UseMoreConditionWaitNotify {
    public static void main(String[] args) throws InterruptedException {
        MyserviceMoreCondition service = new MyserviceMoreCondition();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
        Thread.sleep(3000);
        service.signalAll_A();
    }
    static public class ThreadA extends Thread {
        private MyserviceMoreCondition service;
        public ThreadA(MyserviceMoreCondition service) {
            super();
            this.service = service;
        }
        @Override
        public void run() {
            service.awaitA();
        }
    }
    static public class ThreadB extends Thread {
        private MyserviceMoreCondition service;
        public ThreadB(MyserviceMoreCondition service) {
            super();
            this.service = service;
        }
        @Override
        public void run() {
            service.awaitB();
        }
    }

}
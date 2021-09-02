package com.npt.testsyn;


/**
 * 把 synchronized 关键字加在static方法上,使用两个不同的对象调用。
 */
public class TestSyn4 {
    public static void main(String[] args) {
        TestSyn4 ts = new TestSyn4();
        TestSyn4 ts2 = new TestSyn4();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ts.test2();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ts2.test2();
            }
        }).start();
    }
    /**
     * 加锁的普通方法
     */
    public static synchronized void test2() {
        System.out.println("静态加锁方法执行");
        try {
            Thread.sleep(2000);//延时使得方法没有那么快运行结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("静态加锁方法结束");
    }
}

package com.npt.comparesleepwait;

/**
 * 线程中调用person类的synchronized修饰过的方法
 */
public class OneThread extends Thread  {
    private Person curPerson = null;
    public OneThread(Person person){
        this.curPerson = person;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " call start");
        curPerson.display();
        System.out.println(Thread.currentThread().getName() + " call end");
    }
}

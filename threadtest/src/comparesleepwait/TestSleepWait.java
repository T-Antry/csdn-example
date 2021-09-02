package comparesleepwait;

/**
 * 测试类
 */
public class TestSleepWait {
    public static void main(String[] args) {
        Person testP = new Person(); //这个类里面有是个带锁的方法，目的是多线程时，只有一个线程能够使用
        OneThread t1 = new OneThread(testP);//创建的这两个线程争夺这个资源，
        OneThread t2 = new OneThread(testP);
        t1.start();
        t2.start();
    }
}

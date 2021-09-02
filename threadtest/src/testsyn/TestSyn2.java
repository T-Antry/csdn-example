package testsyn;

/**
 * 把 synchronized 关键字加在普通方法上，使用同一个对象调用。
 */
public class TestSyn2 {
    public static void main(String[] args) {
        TestSyn2 ts = new TestSyn2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ts.test2();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ts.test2();
            }
        }).start();
    }
    /**
     * 加锁的普通方法
     */
    public synchronized void test2() {
        System.out.println("普通加锁方法执行");
        try {
            Thread.sleep(2000);//延时使得方法没有那么快运行结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("普通加锁方法结束");
    }
}
package testsyn;
/**
 * 没有使用锁时，同时运行同一个对象的普通方法效果如何
 */
public class TsetSyn1 {
    public static void main(String[] args) {
        TsetSyn1 ts = new TsetSyn1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ts.test1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ts.test1();
            }
        }).start();
    }
    /**
     * 没有加锁的普通方法
     */
    public void test1() {
        System.out.println("普通方法执行");
        try {
            Thread.sleep(2000);//延时使得方法没有那么快运行结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("普通方法结束");
    }
}

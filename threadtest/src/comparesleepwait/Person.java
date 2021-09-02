package comparesleepwait;

/**
 * 方法逻辑，展示两种方法的区别
 */
public class Person {
    public synchronized void display(){
        for(int i=1;i<=5;i++){
            System.out.println(Thread.currentThread().getName() + " " + i+"time["+ System.currentTimeMillis()/1000+"]startsleep");
            try{
                Thread.sleep(2000);   // sleep是Thread类静态方法,不会释放对象锁
            }catch(Exception ex){

            }
            System.out.println(Thread.currentThread().getName() + " " + i+"time["+ System.currentTimeMillis()/1000+"]endsleep");
            if(i==3){
                System.out.println(Thread.currentThread().getName() + " " + i+"time["+ System.currentTimeMillis()/1000+"]startwait-----------");
                try{
                    this.wait(2000); // wait是Object类实例方法,会释放对象锁
                }catch(Exception ex){

                }
                System.out.println(Thread.currentThread().getName() + " " + i+"time["+ System.currentTimeMillis()/1000+"]endwait-----------");
            }
        }
    }
}

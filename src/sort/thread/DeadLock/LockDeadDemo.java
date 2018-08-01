package sort.thread.DeadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDeadDemo {  
	  
    public static void main(String[] args){  
        final DeadLockBean deadLockBean = new DeadLockBean();  
        Thread threadA = new Thread(new Runnable() {  
            @Override  
            public void run() {  
                try {  
                    Thread.sleep(300);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
                try {  
                    deadLockBean.productDeadLock();  
                } catch (Throwable throwable) {  
                    throwable.printStackTrace();  
                }  
            }  
        },"threadA");  
        Thread threadB = new Thread(new Runnable() {  
            @Override  
            public void run() {  
                try {  
                    Thread.sleep(310);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
                try {  
                    deadLockBean.productDeadLock();  
                } catch (Throwable throwable) {  
                    throwable.printStackTrace();  
                }  
            }  
        },"threadB");  
        threadA.start();  
        threadB.start();  
        try {  
            System.out.println("main线程即将被join");  
            threadA.join();  
            threadB.join();  
            System.out.println("main线程从join中恢复");  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public static class DeadLockBean{  
        private Lock lock = new ReentrantLock();  
        public void productDeadLock() throws Throwable {  
            System.out.println(Thread.currentThread().getName() + "   进入了方法！");  
            lock.lock();  
            try{  
                System.out.println(Thread.currentThread().getName() + "   已经执行了！");  
                throw new Throwable("人为抛出异常Throwable");//关键代码行1，  
                //throw new Exception("人为抛出异常Exception");//关键代码行2，不会死锁，会在catch(Exception e中被捕获)，嵌套lock.unlock()并释放  
            }catch(Exception e){  
                System.out.println(Thread.currentThread().getName()+"   发生异常catch！");  
                //lock.unlock();//关键代码行3，不建议在这里释放，假如发生【关键代码行1】会产生死锁  
            }finally{  
                System.out.println(Thread.currentThread().getName()+"   发生异常finally！");  
                lock.unlock();//关键代码行4，无论发生何种异常，均会释放锁。  
            }  
            //lock.unlock();//关键代码行5，假如发生不能捕获异常，将跳出方法体，不执行此处  
            System.out.println(Thread.currentThread().getName() + "   tryCatch外释放锁！");  
        }  
    }  
}  


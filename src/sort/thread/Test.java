package sort.thread;

public class Test {
     public static void main(String[] args){
    	 //通过继承thread实现多线程
    	 MyThread thread1 = new MyThread("thread1");
    	 thread1.start();
    	 MyThread thread2 = new MyThread("thread2");
    	 thread2.run();
    	 //通过实现runnable接口实现多线程
    	 MyRunnable thread = new MyRunnable();
    	 Thread mythread = new Thread(thread);
    	 mythread.start();
     }
}

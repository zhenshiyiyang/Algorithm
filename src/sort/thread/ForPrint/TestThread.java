package sort.thread.ForPrint;

public class TestThread implements Runnable{
        int i = 1;
        @Override
        public void run() {
            while (true) {
                /*指代的为TestThread,因为使用的是implements方式。若使用继承Thread类的方式，使用this*/
                synchronized (this) {
                    /*唤醒另外一个线程，注意是this的方法，而不是Thread*/
                    notify();
                    try {
                        /*使其休眠100毫秒，放大线程差异*/
                        Thread.currentThread();
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i <= 100) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                        i++;
                        try {
                            /*放弃资源，等待*/
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
}

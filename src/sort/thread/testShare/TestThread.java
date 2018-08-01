package sort.thread.testShare;
/*
 * 将共享数据封装成另外一个对象，然后将这个对象逐一传递给各
 * 个Runnable对象，每个线程对共享数据的操作方法也分配到那个
 * 对象身上完成，这样容易实现针对数据进行各个操作的互斥和通信.
 * 将Runnable对象作为一个类的内部类，共享数据作为这个类的成员
 * 变量，每个线程对共享数据的操作方法也封装在外部类，以便实现
 * 对数据的各个操作的同步和互斥，作为内部类的各个Runnable对象
 * 调用外部类的这些方法。
 */
public class TestThread {  
	  
    /**  
    * @param args  
    */    
   public static void main(String[] args) {    
       final MyData data = new MyData();    
       for(int i=0;i<2;i++){    
           new Thread(new Runnable(){    
   
               public void run() {    
                   data.add();    
                   
               }    
               
           }).start();    
           new Thread(new Runnable(){    
                
               public void run() {    
                   data.dec();    
                   
               }    
               
           }).start();    
       }    
   }    
   
}  
 
class MyData {    
   private int j=0;    
   public  synchronized void add(){    
       j++;    
       System.out.println("线程"+Thread.currentThread().getName()+"j为："+j);    
   }    
   public  synchronized void dec(){    
       j--;    
       System.out.println("线程"+Thread.currentThread().getName()+"j为："+j);    
   }    
 
}    
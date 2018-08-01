package sort.thread.testShare;
//模拟售票系统，用同一个Runnable实现数据共享
public class SellTicket {  
	  
    /**  
    * @param args  
    */    
   public static void main(String[] args) {    
       Ticket t = new Ticket();    
       new Thread(t).start();    
       new Thread(t).start();    
   }    
}  
class Ticket implements Runnable{    
   private int ticket = 10;    
   public void run() {    
       while(ticket>0){    
           ticket--;    
           System.out.println(Thread.currentThread().getName()+"当前票数为："+ticket);    
       }    
           
   }    
   
}   
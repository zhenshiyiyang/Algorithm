package sort.thread;

//java多线程
public class MyThread extends Thread{
	private String name;
	 
    public MyThread(String name){
        this.name = name;
    }
 
    @Override
    public void run() {
        System.out.println("name:"+name+" 子线程ID:"+Thread.currentThread().getId());
    }
}

	

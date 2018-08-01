package sort.thread;

public class MyRunnable implements Runnable{
    public MyRunnable(){
    	
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("子线程:"+Thread.currentThread().getId());
	}

}

package sort.thread;

import java.util.Date;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Object>{
	private String taskNum;  
	 
	MyCallable(String taskNum) {  
	   this.taskNum = taskNum;  
	}  
	 
	public Object call() throws Exception {  
	   System.out.println(">>>" + taskNum + "任务启动");  
	   Date dateTmp1 = new Date();  
	   Thread.sleep(1000);  
	   Date dateTmp2 = new Date();  
	   long time = dateTmp2.getTime() - dateTmp1.getTime();  
	   System.out.println(">>>" + taskNum + "任务终止");  
	   return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";  
	}
    
}

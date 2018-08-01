package train.fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class testInvoke {
	private String name = "hello";     
    public  long number = 10;

    public String getName() {     
        return name;     
    }    
    
    public void setName(String name) {
        this.name = name;
    }
    public long getNumber(){
    	return this.number;
    }

    public static void main(String[] args) throws Exception {
    	testInvoke pt = new testInvoke();     
        
        Class<testInvoke> clazz = testInvoke.class;     
             
        Field[] field = clazz.getDeclaredFields(); 
        for(int i=0;i<field.length;i++){
        	System.out.println(field[i].getName());
        }
        Method[] method = clazz.getDeclaredMethods();
        for(int j=0;j<method.length;j++){
        	System.out.println(method[j].toString());
        }
        //反射获取setName方法
        Method msetName = clazz.getDeclaredMethod("setName", new Class[]{String.class});
        Object[] args1 = {new String("刘欣")};
        //动态改变对象成员变量内容
        msetName.invoke(pt, args1);
        Method mgetName = clazz.getDeclaredMethod("getName", null);
        System.out.println(mgetName.invoke(pt, null));
        Method mgetNumber = clazz.getDeclaredMethod("getNumber", null);
        Long lon =(Long) mgetNumber.invoke(pt, null);
        System.out.println(lon.intValue());
    }
}

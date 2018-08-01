package Extend;

public class Test {
	public static void main(String args[]){
	    Teacher t=new Teacher("张三");//实例化子类
	    //t.name="张三";
	    t.sex='男';
	    t.age=10;
	    t.country="中国";
	    System.out.println(t.getName());
	    t.speak();
	  }
}

package Extend;

public class Person {
	  private String name;
	  public int age;
	  protected char sex;
	  String country;
	  public Person(String name){
		  this.name=name;
	  }
	  public String getName(){
	    return name;
	  }
	  private void setName(String name){
	    this.name=name;
	  }
	   
	  public void speak(){
	    System.out.println(name+"正在说话！");
	  }
}

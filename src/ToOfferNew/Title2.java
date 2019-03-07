package ToOfferNew;

public class Title2 {
    private volatile static Title2 title2 = null;
    private Title2(){}
    public static Title2 getTitle2(){
        if(title2==null){
            synchronized (Title2.class){
                if(title2==null){
                    title2 = new Title2();
                }
            }
        }
        return title2;
    }

}

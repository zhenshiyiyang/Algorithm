package ToOfferNew;
//数值的整数次方
public class Title11 {
    public static double pow(double base,int exp){
        if(base==0){
            return 0;
        }
        if(exp==0){
            return 1;
        }
        if(exp==1){
            return base;
        }
        double result = pow(base,exp>>1);
        result *= result;
        if((exp&1)==1){
            result *= base;
        }
        return result;
    }
}

package ToOffer.Array;

public class FindNumWithSum {
    public static void main(String[] args){
    	
    }
    public static boolean find(int[] data,int length,int sum,int num1,int num2){
    	boolean found = false;
    	if(length<1){
    		return found;
    	}
    	int head = length-1;
    	int behind = 0;
    	while(head>behind){
    		long curSum = data[head]+data[behind];
    		if(curSum==sum){
    			num1 = data[behind];
    			num2 = data[head];
    			System.out.println(num1+"+"+num2);
    			found = true;
    			break;
    		}
    		else if(curSum > sum){
    			head--;
    		}else{
    			behind++;
    		}
    	}
    	return found;
    }
}

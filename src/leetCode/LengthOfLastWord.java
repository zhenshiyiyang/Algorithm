package leetCode;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        if(s==null || s.length()==0)
            return 0;
        int len = s.length();
        int count = 0;
        for(int i=len-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                count++;
            }else if(s.charAt(i)==' '&& count!=0){
                return count;
            }
        }
        return count;
    }
}

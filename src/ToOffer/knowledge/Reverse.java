package ToOffer.knowledge;
/*
  输入一个英文句子，翻转句子中单词的顺序，但单词内字符但顺序不变。
  思路：（1）先翻转整个句子
  （2）再对每个单词进行翻转
 */
public class Reverse {
    public static void main(String[] args){
        String str = "I am a student.";
        char[] data = str.toCharArray();
        System.out.println(String.valueOf(ReverseSentence(data)));
        String str2 = "abcdefg";
        char[] data2 = str2.toCharArray();
        System.out.println(LeftRotateString(data2,2));
    }
    public static void reverse(char[] ch,int begin,int end){
        if(ch==null || ch.length<0 || begin<0 || begin>end){
            return;
        }
        while(begin<end){
            char temp = ch[begin];
            ch[begin++] = ch[end];
            ch[end--] = temp;
        }
    }
    public static char[] ReverseSentence(char[] data){
        if(data==null || data.length<2){
            return null;
        }
        //对整个句子进行翻转
        reverse(data,0,data.length-1);
        //翻转句子中的每个单词
        int pBegin = 0;//记录每个单词起始位置
        int pEnd = 0;//单词的终止位置
        while(pEnd<data.length){
            if(data[pEnd]!=' '){
                if(pEnd==data.length-1){//最后一个单词无空格
                    reverse(data,pBegin,pEnd);
                }
                pEnd++;
            }else if(data[pEnd]==' '){//当遇到空格时，把空格之前的单词翻转，并且把pBegin置为pEnd
                reverse(data,pBegin,pEnd-1);
                pEnd++;
                pBegin = pEnd;//下一个单词的起始位置
            }
        }
        return data;
    }
    /*
       左旋字符串:将字符串前面的若干个字符转移到字符串的尾部。
     */
    public static char[] LeftRotateString(char[] data,int n){
        if(data != null){
            int nlength = data.length;
            if(nlength>0 && n>0 && n<nlength){
                int first = 0;
                int firstEnd = n-1;
                int second = n;
                int secondEnd = nlength-1;
                reverse(data,first,firstEnd);
                reverse(data,second,secondEnd);
                reverse(data,first,secondEnd);
            }
        }
        return data;
    }
}

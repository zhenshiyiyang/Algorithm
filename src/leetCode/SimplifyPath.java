package leetCode;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        System.out.println(simplifyPath(path));
    }
    public static String simplifyPath(String path){
        String[] Names = path.split("/");
        Stack<String> S = new Stack<String>();
        for(int i=0;i<Names.length;++i){
            if(".".equals(Names[i])||"".equals(Names[i]))
                continue;
            if("..".equals(Names[i])){
                if(!S.empty())
                    S.pop();
            }else {
                S.push(Names[i]);
            }
        }
        StringBuilder R = new StringBuilder();
        while(!S.empty()){
            R.insert(0,S.pop());
            R.insert(0,"/");
        }
        if(R.length()==0)
            R.append("/");
        return R.toString();
    }
}

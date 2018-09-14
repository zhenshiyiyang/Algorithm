package 搜狐;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class first {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        String s1 = s[0];
        String s2 = s[1];
        boolean bool = buddy(s1, s2);
        if(bool == true){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }
    public static boolean buddy(final String A, final String B) {
        if (null == A || null == B) {
            return false;
        }

        if (A.length() != B.length()) {
            return false;
        }

        if (A.equals(B)) {
            final Set<Character> record = new HashSet<Character>();
            for (final Character ch : A.toCharArray()) {
                if (record.contains(ch)) {
                    return true;
                } else {
                    record.add(ch);
                }
            }
        } else {
            final char[] differs = new char[2];
            boolean finished = false;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (finished) {
                        return false;
                    }
                    if ('\u0000' == differs[0]) {
                        differs[0] = A.charAt(i);
                        differs[1] = B.charAt(i);
                    } else {
                        if (differs[1] == A.charAt(i) && differs[0] == B.charAt(i)) {
                            finished = true;
                        } else {
                            return false;
                        }
                    }
                }
            }

            return finished;

        }

        return false;
    }

}
package ToOfferNew;

public class Title6 {
    public static class Node{
        int value = 0;
        Node left = null;
        Node right = null;
        public Node(int value){
            this.value = value;
        }
    }
    public static Node Construct(int[] preOrder,int[] inOrder){
        Node root = new Node(preOrder[0]);
        if(preOrder.length==1){
            root.left = null;
            root.right = null;
            return root;
        }
        int loc;
        for(loc=0;loc<inOrder.length;loc++){
            if(inOrder[loc]==root.value){
                 break;
            }
        }
        if(loc>0){
            int[] in_left = new int[loc+1];
            int[] pre_left = new int[loc+1];
            for (int i = 0; i < loc; i++) {
                in_left[i] = inOrder[i];
            }
            for (int j = 0; j < loc; j++) {
                pre_left[j] = preOrder[j+1];
            }
            root.left = Construct(pre_left,in_left);
        }else{
            root.left = null;
        }
        if(inOrder.length-loc-1>0){
            int[] in_right = new int[inOrder.length-loc-1];
            int[] pre_right = new int[preOrder.length-loc-1];
            for (int i = loc+1; i < inOrder.length; i++) {
                in_right[i-loc-1] = inOrder[i];
                pre_right[i-loc-1] = preOrder[i];
            }
            root.right = Construct(pre_right,in_right);
        }else{
            root.right = null;
        }
        return root;
    }
}

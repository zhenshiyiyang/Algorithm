package ToOfferNew;
//树的镜像
public class Title19 {
    public class Node{
        int value = 0;
        Node left = null;
        Node right = null;
        public Node(int value){
            this.value = value;
        }
    }
    public static void Mirror(Node root){
        if(root==null){
            return;
        }
        if(root.left==null || root.right==null){
            return;
        }
        //先序遍历
        //交换
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left!=null){
            Mirror(root.left);
        }
        if(root.right!=null){
            Mirror(root.right);
        }
    }
}

package ToOffer.Tree;

public class TreeDepth {
    static class Node{
        int data = 0;
        Node left = null;
        Node right = null;
        public Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args){

    }
    //得到左子树和右子树的深度
    public static int getDepth(Node root){
        if(root == null){
            return 0;
        }
        int nleft = getDepth(root.left);
        int nright = getDepth(root.right);
        return (nleft>nright)?(nleft+1):(nright+1);
    }
    //判断是否为平衡二叉树，先序遍历，但是会造成节点重复遍历的问题。
    public static boolean isBalance(Node root){
        if(root==null){
           return true;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        int diff = left-right;
        if(diff>1 || diff<-1){
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
    //利用后序遍历，记录遍历过的深度，避免相同节点重复访问。
    public static boolean isBalanceLast(Node root,int depth){
        if(root==null){
            depth = 0;
            return true;
        }
        int left=0;
        int right=0;
        if(isBalanceLast(root.left,left)&&isBalanceLast(root.right,right)){
            int diff = left-right;
            if(diff<=1 && diff>=-1) {
                depth = 1 + (left > right ? left : right);
                return true;
            }
        }
        return false;
    }

}

package ToOfferNew;

public class Title24 {
    public static void main(String[] args) {
        int[] tree = {5,7,6,9,11,10,8};
        System.out.println(isBST(tree,0,tree.length-1));
    }
    //二叉搜索树的后序遍历序列
    public static boolean isBST(int[] tree,int begin,int end){
        if(tree==null || begin<0 || end<0 || begin>end){
            return false;
        }
        int i = begin;
        int root = tree[end];
        //左子树
        for ( ;i < end; i++) {
             if(tree[i]>root){
                break;
             }
        }
        //右子树
        int j = i;
        for (; j < end; j++) {
            if(tree[j]<root){
                return false;
            }
        }
        //判断左子树是不是搜索二叉树。
        boolean left = true;
        if(i>begin){
            left = isBST(tree,begin,i-1);
        }
        boolean right = true;
        if(i<end){
            right  = isBST(tree,i,end-1);
        }
        return (left&&right);
    }
    //二叉搜索树的先序遍历序列
    public static boolean isBSTPreOrder(int[] tree,int begin,int end){
        if(tree==null || begin<0 || end<0 || begin>end){
            return false;
        }
        int i = begin+1;
        int root = tree[begin];
        //左子树
        for (; i < end; i++) {
            if(tree[i]>root){
                break;
            }
        }
        //右子树
        int j = i;
        for (; j < end; j++) {
            if(tree[j]<root){
                return false;
            }
        }
        //判断左子树是不是搜索二叉树
        boolean left = true;
        if(i>begin+1){
            left = isBSTPreOrder(tree,begin+1,i);
        }
        //判断右子树是不是搜索二叉树
        boolean right = true;
        if(i<end){
            right = isBSTPreOrder(tree,i,end);
        }
        return left&&right;
    }
}

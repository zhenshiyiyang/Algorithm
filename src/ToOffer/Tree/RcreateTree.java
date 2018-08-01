package ToOffer.Tree;
//知道树的前序和中序，构造树。还有一种情况：可以知道树的后序和中序，也可以构造树。
public class RcreateTree {
    public static class TreeNode{
    	int value;
    	TreeNode left = null;
    	TreeNode right = null;
    	public TreeNode(int value){
    		this.value = value;
    	}
    	public int getValue(){
    		return value;
    	}
    }
    public static void main(String[] args){
    	int[] pre = new int[]{1,2,4,7,3,5,6,8};
    	int[] in = new int[]{4,7,2,1,5,3,8,6};
    	TreeNode root = Rcreate(pre,in);
    }
    public static TreeNode Rcreate(int[] pre,int[] in){
    	//先序遍历第一个数为根节点.
    	TreeNode root = new TreeNode(pre[0]);
    	if(pre.length==1){
    		root.left = null;
    		root.right = null;
    		return root;
    	}
    	int loc;
    	//中序遍历根位置
    	for(loc=0;loc<in.length-1;loc++){
    		if(in[loc]==root.value){
    			break;
    		}
    	}
    	if(loc>0){
    		//左子树
    		int[] in_left = new int[loc+1];
    		int[] pre_left = new int[loc+1];
    		//中序遍历左子树
    		for(int i=0;i<loc;i++){
    			in_left[i] = in[i];
    		}
    		//先序遍历左子树
    		for(int j=0;j<loc;j++){
    			pre_left[j] = pre[j+1];
    		}
    		root.left = Rcreate(pre_left,in_left);
    	}else{
    		root.left = null;
    	}
    	if(in.length-loc-1>0){
    		//右子树
    		int[] pre_right = new int[in.length-loc-1];
    	    int[] in_right = new int[in.length-loc-1];
    	    for(int i=loc+1;i<in.length;i++){
    	    	//中序遍历右子树
    	        in_right[i-loc-1] = in[i];
    	        //先序遍历右子树
    	    	pre_right[i-loc-1] = pre[i];
    	    }
    	    root.right = Rcreate(pre_right,in_right);
    	}else{
    		root.right = null;
    	}
    	return root;
    }
    
}

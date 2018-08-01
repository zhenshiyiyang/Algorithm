package ToOffer.Tree;
//判断树A是否含有树B
public class HaveSubTree {
	  public static class Node{
		  int value;
		  Node left = null;
		  Node right = null;
		  public Node(int value){
			  this.value = value;
		  }
	  }
      public static boolean hasSubTree(Node treeA,Node treeB){
    	  boolean result = false;
    	  if(treeA!=null && treeB!=null){
	    	  if(treeA.value==treeB.value){
	    		  result = AhasB(treeA,treeB);
	    	  }
	    	  if(!result){
	    		  result = hasSubTree(treeA.left,treeB);
	    	  }
	    	  if(!result){
	    		  result = hasSubTree(treeA.right,treeB);
	    	  }
    	  }
		  return result;  
      }
      public static boolean AhasB(Node treeA,Node treeB){
		  if(treeB == null){
			  return true;
		  }
		  if(treeA == null){
			  return false;
		  }
		  if(treeA.value!=treeB.value){
			  return false;
		  }
    	  return AhasB(treeA.left,treeB.left) && AhasB(treeA.right,treeB.right);
      }
}

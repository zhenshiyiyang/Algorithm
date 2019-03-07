package ToOfferNew;
/*
 树的子结构
 */
public class Title18 {
    public class Node{
        int value = 0;
        Node left = null;
        Node right = null;
        public Node(int value){
            this.value = value;
        }
    }
    public static boolean hasSubTree(Node root1,Node root2){
        boolean flag = false;
        if(root1!=null && root2!=null){
            if(root1.value==root2.value){
                flag = doesTree1HasTree2(root1,root2);
            }
            if(!flag){
                flag = doesTree1HasTree2(root1.left,root2);
            }
            if(!flag){
                flag = doesTree1HasTree2(root1.right,root2);
            }
        }
        return flag;
    }
    public static boolean doesTree1HasTree2(Node root1,Node root2){
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.value!=root2.value){
            return false;
        }
        return doesTree1HasTree2(root1.left,root2.left)&&doesTree1HasTree2(root1.right,root2.right);
    }
}

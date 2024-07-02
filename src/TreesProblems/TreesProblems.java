package TreesProblems;
import java.util.ArrayList;
import java.util.List;

import static TreesImplementation.Trees.Node;

public class TreesProblems {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right  = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
          int ans[] = printPathRootToNode(node,7);
        System.out.println(printLeafNode(node));

    }
    //Given two trees tell us they are identical or not (same structure and same value)
//    public int isSameTree(TreeNode A, TreeNode B) {
//
//
//    }
    public static int[] printPathRootToNode(Node A,int k)
    {
        List<Integer> list = new ArrayList<>();
        boolean res =helper(A,k,list);
        int []ans = new int[list.size()];
        System.out.println(list);

        return ans;

    }
    private static boolean helper(Node root,int k,List<Integer> l)
    {
        if(root == null) return false;
        l.add(root.val);
        if(root.val == k) return true;

        if(helper(root.left,k,l) || helper(root.right,k,l)) return true;
        l.remove(l.size()-1);
        return false;
    }

    private static List<Integer> printLeafNode(Node root){
        List<Integer> ans = new ArrayList<>();
        leafNode(root,ans);
        return ans;
    }
    private static void leafNode(Node root,List<Integer> ans)
    {
        if(root.left == null && root.right==null)
        {
            ans.add(root.val);
            return;
        }
        if(root.left!=null) leafNode(root.left,ans);
        if(root.right!=null) leafNode(root.right,ans);
        return;
    }
}

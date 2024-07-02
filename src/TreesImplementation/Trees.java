package TreesImplementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Trees {
    public static class Node{
       public  Node left;
      public  Node right;
      public  int val;

        public Node() {
        }

        public Node(int val)
        {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right  = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        List<List<Integer>> ans  = levelOrder(node);
//        for(List<Integer> l : ans) System.out.println(l);

        System.out.println(solve(node));
    }
    public static List<List<Integer>> levelOrder(Node root)
    {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root!=null) q.add(root);

        while(!q.isEmpty())
        {
            int n = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                  if(q.peek()!=null) {
                      if (q.peek().left != null) q.add(q.peek().left);
                      if (q.peek().right != null) q.add(q.peek().right);
                      l.add(q.peek().val);
                      q.poll();
                  }
            }
            ans.add(l);
        }
        return ans;
    }
  static  int max,count;
    public static int solve(Node A) {
        max = Integer.MIN_VALUE;
        count=0;
        preOrder(A);
        return count;
    }
    private static void preOrder(Node A)
    {
        if(A==null) return;
        if(A.val>max)
        {
            count++;
            max = A.val;
        }
        preOrder(A.left);
        preOrder(A.right);
        return;
    }


}

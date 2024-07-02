package TreesAlgorithmns;

import TreesImplementation.Trees;

import java.util.ArrayList;
import java.util.List;

import static TreesImplementation.Trees.*;

public class preOrder {
    public static List<Integer> preOrder(Node root)
    {
        List<Integer> ans = new ArrayList<>();
        return solvePreOrder(root,ans);
    }
    public static List<Integer> solvePreOrder(Node root, List<Integer> ans)
    {
        if(root == null) return ans;
        ans.add(root.val);
        solvePreOrder(root.left,ans);
        solvePreOrder(root.right,ans);
        return ans;
    }
}

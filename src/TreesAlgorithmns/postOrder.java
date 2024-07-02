package TreesAlgorithmns;

import java.util.ArrayList;
import java.util.List;

import static TreesImplementation.Trees.Node;

public class postOrder {
    public static List<Integer> preOrder(Node root)
    {
        List<Integer> ans = new ArrayList<>();
        return solvePreOrder(root,ans);
    }
    public static List<Integer> solvePreOrder(Node root, List<Integer> ans)
    {
        if(root == null) return ans;
        solvePreOrder(root.left,ans);
        solvePreOrder(root.right,ans);
        ans.add(root.val);
        return ans;
    }
}

import java.util.*;


public class ClosestBinarySearchTreeValueII {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
			left = null;
			right = null; 
		}
	}
	public static void main(String[] args) {
		//Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
		//Given target value is a floating point.
		//You may assume k is always valid, that is: k less or equal to total nodes.
		//You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
	}
    public static List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null || k == 0) return res;
        TreeNode cur = root; 
        Stack<TreeNode> lStack = new Stack<>();
        Stack<TreeNode> rStack = new Stack<>();
        while (cur != null) {
            if (cur.val < target) {
                lStack.push(cur);
                cur = cur.right;
            }
            else {
                rStack.push(cur);
                cur = cur.left;
            }
        }
        while (k > 0) {
            if (!lStack.isEmpty() && !rStack.isEmpty()) {
                int lVal = lStack.peek().val, rVal = rStack.peek().val;
                if (Math.abs(lVal - target) < Math.abs(rVal - target)) {
                    res.add(removeLeft(lStack));
                }   
                else res.add(removeRight(rStack));
            }
            else if (!lStack.isEmpty()) {
                res.add(removeLeft(lStack));
            }
            else if (!rStack.isEmpty()) {
                res.add(removeRight(rStack));
            }
            else break; 
            k--; 
        }
        return res; 
    }
    private static Integer removeLeft(Stack<TreeNode> stack) {
        TreeNode top = stack.pop();
        TreeNode cur = top.left; 
        while (cur != null) {
            stack.push(cur);
            cur = cur.right;
        }
        return top.val; 
    }
    private static Integer removeRight(Stack<TreeNode> stack) {
        TreeNode top = stack.pop();
        TreeNode cur = top.right; 
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        return top.val; 
    }
}

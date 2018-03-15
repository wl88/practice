/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        if (inorder.length == 0) return null;
        
        
        return helper(preorder, inorder, 0, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int preorder_start, int inorder_start, int inorder_end) {
        //if (inorder_start > inorder_end) return null;
        
        TreeNode head = new TreeNode(preorder[preorder_start]);
        
        int index = arrayIndexOf(inorder, preorder[preorder_start]);
        int lenL = index - inorder_start;
        int lenR = inorder_end - index;
        
        if (lenL > 0) {
            head.left = helper(preorder, inorder, preorder_start+1, inorder_start, index-1);
        }
        if (lenR > 0) {
            head.right = helper(preorder, inorder, preorder_start+lenL+1, index+1, inorder_end);
        }
        
        return head;
    }
    
    public int arrayIndexOf(int[] inorder, int num) {
        for (int i = 0; i< inorder.length; i++) {
            if (inorder[i] == num) return i;
        }
        return 0;
    }
}
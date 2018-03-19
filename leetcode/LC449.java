package leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LC449 {

   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

      // Encodes a tree to a single string.
      public String serialize(TreeNode root) {
         StringBuilder sb = new StringBuilder();
         preorderTraversal(root, sb);
         //System.out.println("serialize: " + preorder);
         return sb.toString();
      }

      public void preorderTraversal(TreeNode root, StringBuilder sb) {
         if (root == null) return;
         sb.append(root.val);
         sb.append(" ");

         preorderTraversal(root.left, sb);
         preorderTraversal(root.right, sb);
      }

      // Decodes your encoded data to tree.
      public TreeNode deserialize(String data) {
         String[] preorder = data.split(" ");
         if (preorder[0].length() == 0) return null;

         TreeNode root = new TreeNode(0);

         constructTree(preorder, root, false, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
         //System.out.println("serialize: " + serialize(root.right));
         return root.right;
      }

      public int constructTree(String[] preorder, TreeNode root, boolean isLeft, int position, int min, int max) {
         //System.out.println("\n" + (isLeft ? "left | position: " : "right | position: ") + position);
         if (position >= preorder.length) return position;
         //System.out.println("current: " + Integer.parseInt(preorder[position]) + " parent: " + root.val + " min: " + min + " max: " + max);

         TreeNode current = new TreeNode(Integer.parseInt(preorder[position]));
         if (current.val > min && current.val <= max) {
            //System.out.println("found left node");
            if (isLeft) {
               root.left = current;
            } else {
               root.right = current;
            }
            //System.out.println("serialize: " + serialize(root));
            position = constructTree(preorder, current, true, ++position, min, current.val);
            //System.out.println("serialize: " + serialize(root));
            position = constructTree(preorder, current, false, ++position, current.val, max);
            //System.out.println("serialize: " + serialize(root));
            return position;
         } else {
            return position -1;
         }
      }
   }
}

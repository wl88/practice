package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class LC19 {
   public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }

   public int level = -1;

   public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode head_new = removeHelper(head, n);
      return head_new;
   }

   public ListNode removeHelper(ListNode node, int target) {
      if (node.next == null) {
         level = 1;
         if (target == 1) {
            return null;
         } else {
            return node;
         }
      }

      ListNode head = removeHelper(node.next, target);
      level++;
      if (level == target) {
         return head;
      } else {
         node.next = head;
         return node;
      }
   }
}
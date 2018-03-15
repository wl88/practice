/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        if (lists.length == 0) return null;
        
        Queue<ListNode> pq = new PriorityQueue<ListNode>(10, new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        ListNode result = null;
        ListNode current = null;
        
        for (int i = 0; i< lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);   
            }
        }
        
        while (pq.peek() != null) {
            ListNode smallest = pq.poll();
            if (result == null) {
                result = smallest;
                current = result;
            } else {
                current.next = smallest;
                current = current.next;
            }
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }
        return result;
    }
}
package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC23 {
	public class ListNode {
	     int val;
	     ListNode next;
	    ListNode(int x) { val = x; }
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<ListNode>(10, new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        ListNode result = null;
        ListNode current = null;
        
        for (int i = 0; i< lists.length; i++) {
            pq.add(lists[i]);
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
        print(result);
        return result;
    }
	
	public void print(ListNode l) {
		ListNode current = l;
		String result = "";
		while (current != null) {
			result += current.val + " ";
			current = current.next;
		}
		
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		LC23 l = new LC23();
		ListNode n1 = l.new ListNode(1);
		ListNode n2 = l.new ListNode(2);
		ListNode n3 = l.new ListNode(10);
		ListNode n4 = l.new ListNode(3);
		n2.next = n4;
		
		ListNode[] input = new ListNode[3];
		input[0] = n1;
		input[1] = n2;
		input[2] = n3;
		l.mergeKLists(input);

	}

}

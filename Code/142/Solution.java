/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
	//
	// Note: Do not modify the linked list.
	//
	// Follow up:
	// Can you solve it without using extra space?
	public ListNode detectCycle(ListNode head) {
		if(head==null)
			return null;
		ListNode slow = head;
		ListNode fast =  head;

		while(slow!=null && fast!=null) {
			slow=slow.next;
			fast=fast.next;
			if(fast!=null)
				fast=fast.next;
			if(slow==fast)
				break;

		}
		if(slow==null || fast==null)
			return null;
		fast = head;
		while(fast!=slow) {
			fast=fast.next;
			slow=slow.next;
		}
		return slow;
	}
}

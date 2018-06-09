/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	// Write a program to find the node at which the intersection of two singly linked lists begins.
	//
	//
	// For example, the following two linked lists:
	//
	// A:          a1 → a2
	//                    ↘
	//                      c1 → c2 → c3
	//                    ↗
	// B:     b1 → b2 → b3
	// begin to intersect at node c1.
	//
	//
	// Notes:
	//
	// If the two linked lists have no intersection at all, return null.
	// The linked lists must retain their original structure after the function returns.
	// You may assume there are no cycles anywhere in the entire linked structure.
	// Your code should preferably run in O(n) time and use only O(1) memory.
	// Credits:
	// Special thanks to @stellari for adding this problem and creating all test cases.

	// how could this be easy?
	// Because what I learn blocks my eyes, first idea should be count the difference of length
    // between two list and then find the common node.
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		//boundary check
		if(headA == null || headB == null) return null;

		ListNode a = headA;
		ListNode b = headB;

		//if a & b have different len, then we will stop the loop after second iteration
		while( a != b) {
			//for the end of first iteration, we just reset the pointer to the head of another linkedlist
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}

        // Raz: What's tricky here, if there are no intersection, a and b will both be null!

		return a;
	}
}

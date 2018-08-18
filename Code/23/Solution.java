/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
	//
	// Example:
	//
	// Input:
	// [
	//   1->4->5,
	//   1->3->4,
	//   2->6
	// ]
	// Output: 1->1->2->3->4->4->5->6

	// straightforward find min each, very slow, complexity n*n*l
	public ListNode mergeKLists_my(ListNode[] lists) {
		if(lists == null || lists.length == 0) return null;
		if(lists.length == 1) return lists[0];

		ListNode dummyHead = new ListNode(0);
		ListNode dummy = dummyHead;

		while(true) {
			int minVal = Integer.MAX_VALUE;
			int minIndex = -1;

			for(int i=0; i<lists.length; i++) {
				ListNode list = lists[i];
				if(list == null) continue;
				if(list.val <= minVal) {
					minIndex = i;
					minVal = list.val;
				}
			}

			if(minIndex == -1) return dummyHead.next;
			else {
				dummy.next = lists[minIndex];
				lists[minIndex] = lists[minIndex].next;
				dummy = dummy.next;
			}
		}
	}

	// merge with littlest particle, very fast , but complexity: l * n * log n
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) return null;
		return mergeRur(lists, 0, lists.length-1);
	}

	public ListNode mergeRur(ListNode [] lists, int left, int right) {
		if(left == right) return lists[left];
		int mid = left + (right - left)/2;
		ListNode l1 = mergeRur(lists, left, mid);
		ListNode l2 = mergeRur(lists, mid+1, right);
		return mergeTwo(l1, l2);
	}

	public ListNode mergeTwo(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=mergeTwo(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwo(l1,l2.next);
            return l2;
        }
	}
}

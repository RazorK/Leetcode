/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // Sort a linked list in O(n log n) time using constant space complexity.
    //
    // Example 1:
    //
    // Input: 4->2->1->3
    // Output: 1->2->3->4
    // Example 2:
    //
    // Input: -1->5->3->4->0
    // Output: -1->0->3->4->5

    // second try: merge sort, recursive
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        //get mid
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode slow = prehead, fast = prehead;
        while(fast!=null) {
            fast = fast.next;
            if(fast==null) break;
            fast = fast.next;
            slow = slow.next;
        }

        //slow points to mid
        ListNode second = slow.next;
        slow.next = null;
        head = sortList(head);
        second = sortList(second);

        //merge
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        while(head!=null || second!=null) {
            if(head == null) {
                dummy.next = second;
                dummy = dummy.next;
                second = second.next;
            } else if(second == null) {
                dummy.next = head;
                head = head.next;
                dummy = dummy.next;
            } else if(head.val > second.val) {
                dummy.next = second;
                dummy = dummy.next;
                second = second.next;
            } else {
                dummy.next = head;
                head = head.next;
                dummy = dummy.next;
            }
        }

        return res.next;
    }
    // First try: quick sort idea
    // give up...
    public ListNode quick(ListNode head) {

    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode split = head;
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);

        ListNode it = head.next;
        ListNode leftIt = left;
        ListNode rightIt = right;
        while(it!=null) {
            if(it.val > split.val) {
                rightIt.next = it;
                rightIt = rightIt.next;
            } else {
                leftIt.next = it;
                leftIt = leftIt.next;
            }

            it = it.next;
        }

        leftIt.next = null;
        rightIt.next = null;

        return combine(left, right, split);
    }

    public ListNode combine(ListNode left, ListNode right, ListNode split) {
        ListNode res = new ListNode(0);
        ListNode resIt = res;

        left = left.next;
        while(left!=null) {
            resIt.next = left;
            left = left.next;
            resIt = resIt.next;
        }

        resIt.next = split;
        resIt = resIt.next;
        resIt.next = null;

        right = right.next;
        while(right!=null) {
            resIt.next = right;
            right = right.next;
            resIt = resIt.next;
        }

        return res.next;
    }
}

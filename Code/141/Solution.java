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
    // Given a linked list, determine if it has a cycle in it.
    //
    // Follow up:
    // Can you solve it without using extra space?

    // Learned from Algorithm Class, Fast Slow Ptrs.
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null) {
            fast = fast.next;
            if(fast == slow){
                return true;
            }
            // BUG: forget to check null value when fast move forward.
            if(fast == null) return false;
            fast = fast.next;
            if(fast == slow) {
                return true;
            }
            slow = slow.next;
        }
        return false;
    }
}

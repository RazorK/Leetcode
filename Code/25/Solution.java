/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode dummyHead = new ListNode(0);
        ListNode oriHead = head;

        for(int i=0; i<k; i++) {
            if(head == null) {
                return reverse(dummyHead.next);
            }

            ListNode temp = dummyHead.next;
            dummyHead.next = head;
            head = head.next;
            dummyHead.next.next = temp;
        }

        ListNode reverse = reverseKGroup(head, k);
        oriHead.next = reverse;
        return dummyHead.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        while(head!=null) {
            ListNode temp = dummyHead.next;
            dummyHead.next = head;
            head = head.next;
            dummyHead.next.next = temp;
        }
        return dummyHead.next;
    }
}
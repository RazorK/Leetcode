/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // TLE MLE
    public void firstTry(ListNode head) {
        List<ListNode> rev = reverseList(head);
        ListNode res = new ListNode(0);
        int ptr = 0;
        while(head != rev.get(ptr) && head.next != rev.get(ptr)) {
            ListNode newHead = head.next;
            res.next = head;
            head.next = rev.get(ptr++);
            head = newHead;
            res = res.next.next;
        }
        res.next = head;
        if(head!=rev.get(ptr)) head.next = rev.get(ptr);
    }

    public List<ListNode> reverseList(ListNode head) {
        List<ListNode> res = new LinkedList<>();
        while(head!=null) {
            res.add(0, head);
            head = head.next;
        }
        return res;
    }

    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode mid = findMid(head);
        ListNode insert = mid.next;
        mid.next = null;
        insert = reverse(insert);
        while(insert!=null) {
            System.out.println(insert.val);
        }

        while(insert!=null) {
            ListNode temp = head.next;
            ListNode insertTmp = insert.next;
            head.next = insert;
            insert.next = temp;
            head = temp;
            insert = insertTmp;
        }
    }

    // find mid node, first mid if even
    public ListNode findMid(ListNode head) {
        if(head == null) return null;
        ListNode fast = head.next, slow = head;
        while(true) {
            if(fast == null) return slow;
            fast = fast.next;
            if(fast == null) return slow;
            fast = fast.next;
            slow = slow.next;
        }
    }

    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = head;
        head = head.next;

        //BUG forget to cut the end, which results in a loop.
        res.next = null;

        while(head!=null) {
            ListNode temp = head.next;
            head.next = res;
            res = head;
            head = temp;
        }
        return res;
    }
}

class Solution {
    // Merge two sorted linked lists and return it as a new list. The new list
    // should be made by splicing together the nodes of the first two lists.
    //
    // Example:
    //
    // Input: 1->2->4, 1->3->4
    // Output: 1->1->2->3->4->4
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        while(l1!=null || l2!=null) {
            if(l1 == null){
                res.next = l2;
                break;
            }
            if(l2 == null) {
                res.next = l1;
                break;
            }
            if(l1.val<l2.val) {
                res.next = l1;
                l1 = l1.next;
                res = res.next;
            } else {
                res.next = l2;
                l2 = l2.next;
                res = res.next;
            }
        }
        return head.next;
    }
}

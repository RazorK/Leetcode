class Solution {
    // Sort a linked list in O(n log n) time using constant space complexity.

    // first try quick sort idea.

    // TLE
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        return recur(head)[0];
    }

    public ListNode [] recur(ListNode head) {
        if(head == null) return null;
        ListNode [] res = new ListNode[2];
        if(head.next == null) {
            res[0] = head;
            res[1] = head;
            return res;
        }
        ListNode split = head;
        ListNode left = null;
        ListNode right = null;

        ListNode cur = head.next;
        while(cur!=null) {
            ListNode next = cur.next;
            if(cur.val>split.val) {
                cur.next = right;
                right = cur;
            } else {
                cur.next = left;
                left = cur;
            }
            cur = next;
        }

        ListNode[] leftR = recur(left);
        ListNode[] rightR = recur(right);
        // link
        split.next = null;
        if(leftR!=null) leftR[1].next = split;
        if(rightR!=null) split.next = rightR[0];
        res[0] = leftR == null? split: leftR[0];
        res[1] = rightR == null? split:rightR[1];
        return res;
    }

    // try merge sort
}

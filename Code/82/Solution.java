class Solution {
    // Given a sorted linked list, delete all nodes that have duplicate numbers,
    // leaving only distinct numbers from the original list.
    //
    // For example,
    // Given 1->2->3->3->4->4->5, return 1->2->5.
    // Given 1->1->1->2->3, return 2->3.

    // BUG misunderstand the problem, not leave the distinct value, but if the value
    //  duplicate, delete all the node of this value.
    // BUG can not get the first one

    // try create new Node here
    // passed
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        boolean flag = false;
        if(head.next!=null && head.val == head.next.val) flag = true;
        int ahead = head.val;
        ListNode ptr = head.next;
        ListNode new_head = new ListNode(head.val);
        ListNode cur = new_head;
        while(ptr != null) {
            if(ptr.val != ahead) {
                if(ptr.next == null || ptr.next.val != ptr.val) {
                    cur.next = new ListNode(ptr.val);
                    cur = cur.next;
                }
                ahead = ptr.val;
            }
            ptr = ptr.next;
        }
        if(flag) return new_head.next;
        return new_head;
    }

    // fast and slow ptrs idea from leetcode
    // in place
    // NOTE use dummy ListNode
    public ListNode LCdeleteDuplicates(ListNode head) {
        // use two pointers, slow - track the node before the dup nodes,
    	// fast - to find the last node of dups.

        // Raz:
        // the idea is really hard to think of
        // just add the fast.next to slow first.
        // if the fast is duplicate, then remove it, change the slow.next to now fast.next
        // not easy enough as the solution above I think.

        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
        slow.next = fast;
        while(fast != null) {
        	while (fast.next != null && fast.val == fast.next.val) {
         		fast = fast.next;    //while loop to find the last node of the dups.
        	}
        	if (slow.next != fast) { //duplicates detected.
        		slow.next = fast.next; //remove the dups.
        		fast = fast.next;     //reposition the fast pointer.
        	} else { //no dup, move down both pointer.
        		slow = slow.next;
        		fast = fast.next;
        	}
        }
        return dummy.next;
    }

    // recreate a inplace solution
    public static ListNode inPlace(ListNode head) {
        if(head == null || head.next == null) return head;
        boolean flag = false;
        if(head.next!=null && head.val == head.next.val) flag = true;
        int ahead = head.val;
        ListNode ptr = head.next;
        ListNode new_head = head;
        ListNode cur = new_head;
        while(ptr != null) {
            if(ptr.val != ahead) {
                if(ptr.next == null || ptr.next.val != ptr.val) {
                    cur.next = ptr;
                    cur = cur.next;
                }
                ahead = ptr.val;
            }
            ptr = ptr.next;
        }
        cur.next = null;
        if(flag) return new_head.next;
        return new_head;
    }
}

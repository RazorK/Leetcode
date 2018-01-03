class Solution {
    // Given a list, rotate the list to the right by k places, where k is non-negative.
    //
    //
    // Example:
    //
    // Given 1->2->3->4->5->NULL and k = 2,
    //
    // return 4->5->1->2->3->NULL.

    // first idea just traverse twice
    // memory limit exceed
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0) return head;
        if(head == null) return null;

        int counter = 0;
        ListNode it = head;
        while(it.next!=null) {
            counter++;
            it = it.next;
        }
        counter++;
        ListNode front = it;
        it.next = head;

        k = k%counter;
        if(k==0) return head;
        it = head;

        for(int i=0; i < counter-k; i++){
            front = front.next;
            it = it.next;
        }
        front.next = null;
        return it;
    }

    // try simplify it
    // still not work
    public ListNode try_rotateRight(ListNode head, int k) {
        if(k==0) return head;
        if(head == null||head.next==null) return null;

        int counter = 0;
        ListNode it = head;
        while(it.next!=null) {
            counter++;
            it = it.next;
        }
        counter++;
        it.next = head;

        k = k%counter;
        if(k==0) return head;

        for(int i=0; i < counter-k; i++){
            it = it.next;
            head = head.next;
        }
        it.next = null;
        return head;
    }

    public ListNode suggested(ListNode head, int n) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;

        int i;
        for (i=0;fast.next!=null;i++)//Get the total length
        	fast=fast.next;

        for (int j=i-n%i;j>0;j--) //Get the i-n%i th node
        	slow=slow.next;

        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }
}

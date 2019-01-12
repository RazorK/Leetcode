/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            Node res = new Node();
            res.val = insertVal;
            res.next = res;
            return res;
        }

        Node it = head, next = head.next;
        while(!(it.val <= insertVal && next.val>= insertVal)) {
            if(it.val > next.val && (insertVal >= it.val || insertVal <= next.val)) {
                insert(it, next, insertVal);
                return head;
            }

            if(head == next) {
                insert(it, next, insertVal);
                return head;
            }
            
            it = it.next;
            next = next.next;
        }

        insert(it, next, insertVal);
        return head;
    }
    public void insert(Node it, Node next, int val) {
        Node in = new Node();
        in.val = val;
        it.next = in;
        in.next = next;
    }
}
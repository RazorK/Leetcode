/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    // A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
    // Return a deep copy of the list.

    // NOTE:
        // 1. create Map
        // 2. link
        // 3. random procedure.
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;

        // create all the node and the map.
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode ptr = head;
        RandomListNode pre = null;
        while(ptr!=null) {
            RandomListNode newN = new RandomListNode(ptr.label);
            if(pre != null) pre.next = newN;
            map.put(ptr, newN);
            ptr = ptr.next;
            pre = newN;
        }

        ptr = head;
        while(ptr!=null) {
            map.get(ptr).random = map.get(ptr.random);
            ptr = ptr.next;
        }

        return map.get(head);
    }
}

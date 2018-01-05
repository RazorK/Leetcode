import java.util.ArrayList;

/**
 * 给出定义ListNode 删除List尾部第n个ListNode
 * 如：
 * Given linked list: 1->2->3->4->5, and n = 2.
 * return 1->2->3->5.
 * 主要注意边界情况下，操作和中间不同需要单独讨论
 * Created by aimin on 2017/7/22.
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> ram = new ArrayList<>();
        ListNode now = head;
        while (now.next!=null) {
            ram.add(now);
            now = now.next;
        }
        ram.add(now);
        int change = ram.size()-n;
        if(change==0) {
            return head.next;
        } else if(change == ram.size()-1) {
            ram.get(change-1).next = null;
            return head;
        } else {
            ram.get(ram.size()-n-1).next = ram.get(ram.size()-n+1);
            return head;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
}

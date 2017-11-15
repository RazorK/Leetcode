import java.util.List;

/**
 * Created by aimin on 2017/7/25.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    public static ListNode create(List<Integer> l) {
        ListNode head = new ListNode(l.get(0));
        ListNode ptr = head;
        for(int i=1;i<l.size();i++) {
            ListNode temp = new ListNode(l.get(i));
            ptr.next = temp;
            ptr = temp;
        }
        return head;
    }

    public String toString() {
        String res = "[";
        ListNode ptr = this;
        while (ptr.next!=null) {
            res+=ptr.val+", ";
            ptr = ptr.next;
        }
        res += ptr.val+",";
        return res.substring(0,res.length()-1)+"]";
    }
}

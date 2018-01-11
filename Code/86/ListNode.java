import java.util.*;
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public String toString() {
        ListNode ptr = this;
        StringBuilder sb = new StringBuilder();
        while(ptr!=null){
            sb.append(ptr.val);
            if(ptr.next!= null)
                sb.append(" -> ");
            ptr = ptr.next;
        }
        return sb.toString();
    }
}

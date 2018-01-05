/**
 * Created by aimin on 2017/5/4.
 */
public class Main {
    public static void main (String[] args){
        ListNode a = new ListNode(0);
        System.out.println(a.next==null);
        ListNode b = a.next;
        System.out.println(b == null);
    }
}

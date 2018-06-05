public class Main {
    public static void main(String [] args) {
        ListNode r1 = new ListNode(2);
        r1.next = new ListNode(1);
        new Solution().sortList(r1);
    }
}

import static java.lang.System.*;
import java.util.*;
public class Main {
	public static void main(String [] args) {
		ListNode head = new ListNode(1);
        head.next = new ListNode(1);
		System.out.println(Solution.deleteDuplicates(head));
	}
}

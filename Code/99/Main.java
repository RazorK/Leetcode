import static java.lang.System.*;
import java.util.*;
public class Main {
	public static void main(String [] args) {
		TreeNode zero = new TreeNode(0);
		zero.left = new TreeNode(1);
		new Solution().recoverTree(zero);
	}
}

import static java.lang.System.*;
import java.util.*;
public class Main {
	public static void main(String [] args) {
		TreeNode root = TreeNode.stringToTreeNode("[1,null,2]");
		System.out.println(new Solution().isSymmetric(root));
	}
}

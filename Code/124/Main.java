import static java.lang.System.*;
import java.util.*;
public class Main {
	public static void main(String [] args) {
		TreeNode tes = TreeNode.stringToTreeNode("[-3]");
		System.out.println(new Solution().maxPathSum(tes));
	}
}

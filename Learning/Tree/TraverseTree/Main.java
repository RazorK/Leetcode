import static java.lang.System.*;
import java.util.*;
public class Main {
	public static void main(String [] args) {
        TreeNode tree = TreeNode.stringToTreeNode("[1,2,3,4,5]");
		System.out.println(InOrder.dfs(tree));
		System.out.println(BFS.bfs(tree));
	}
}

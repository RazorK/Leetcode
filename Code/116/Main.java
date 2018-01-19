import static java.lang.System.*;
import java.util.*;
public class Main {
	public static void main(String [] args) {
        TreeLinkNode test = TreeLinkNode.stringToTreeLinkNode("{1,2,3,4,5,6,7}");
		new Solution().connect(test);
	}
}

import static java.lang.System.*;
import java.util.*;
public class Main {
	public static void main(String [] args) {
		int [] in = {1,2};
		int [] post = {2,1};
		System.out.println(new Solution().buildTree(in, post));
	}
}

import static java.lang.System.*;
import java.util.*;
public class Main {
	public static void main(String [] args) {
		char a = 'a';
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString((char)256));
		a^=256;
		System.out.println(Integer.toBinaryString((char)a));
		System.out.println((char)257);
        // char [][] board = {
		// 	{'A', 'B', 'C', 'E'},
		// 	{'S', 'F', 'E', 'S'},
		// 	{'A', 'D', 'E', 'E'}
		// };
        //
		// String target = "ABCESEEEFS";
		// System.out.println(Solution.exist(board, target));
	}
}

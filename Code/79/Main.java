import static java.lang.System.*;
import java.util.*;
public class Main {
	public static void main(String [] args) {
        char [][] board = {
			{'A', 'B', 'C', 'E'},
			{'S', 'F', 'E', 'S'},
			{'A', 'D', 'E', 'E'}
		};

		String target = "ABCESEEEFS";
		System.out.println(Solution.exist(board, target));
	}
}

import static java.lang.System.*;
import java.util.*;
public class Main {
	public static void main(String [] args) {
        int [][] test = new int[][]{
            {0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}
        };
        Solution.setZeroes(test);
        System.out.println(Arrays.deepToString(test));
	}
}

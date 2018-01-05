import static java.lang.System.*;
import java.util.Arrays;
import java.util.*;
public class Main {
	public static void main(String [] args) {
		int [] cans = new int []{2,3,6,7};
		int target = 7;
		System.out.println(Solution.combinationSum(cans, target));
	}
}

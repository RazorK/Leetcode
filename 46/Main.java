import static java.lang.System.*;
import java.util.Arrays;
import java.util.*;
public class Main {
	public static void main(String [] args) {
		int [] test = new int[]{1,2,3};
		System.out.println(Arrays.toString(test));
		change(test);
		System.out.println(Arrays.toString(test));
	}
	public static void change(int [] hi) {
		hi[0] = 3;
	}
}

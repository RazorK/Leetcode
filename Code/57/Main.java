import static java.lang.System.*;
import java.util.Arrays;
import java.util.*;
public class Main {
	public static void main(String [] args) {
		List<Interval> result = new ArrayList<>();
        result.add(new Interval(1,2));
        result.add(new Interval(3,5));
        result.add(new Interval(6,7));
        result.add(new Interval(8,10));
        result.add(new Interval(12,16));
        System.out.println(Solution.insert(result, new Interval(4,9)));
	}
}

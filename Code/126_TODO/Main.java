import static java.lang.System.*;
import java.util.*;
public class Main {
	public static void main(String [] args) {
		String begin = "hit";
		String end = "cog";
		List<String> list = new ArrayList<String>();
		list.add("hot");
		list.add("dot");
		list.add("dog");
		list.add("lot");
		list.add("log");
		list.add("cog");
		System.out.println(new Solution().findLadders(begin, end, list));
	}
}

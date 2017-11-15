import static java.lang.System.*;
import java.util.Arrays;
import java.util.*;
public class Main {
  public static void main(String [] args) {
    int [] nums = new int []{1,2,3,4,5,6,7,8,9};
    Solution.byReverse(nums,3);
    System.out.println(Arrays.toString(nums));
  }
}

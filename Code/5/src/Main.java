import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aimin on 2017/5/5.
 */
public class Main {
    public static void main (String args[]) throws IOException {
        while(true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            System.out.println(new SuggestedSolution().longestPalindrome(s));
        }
    }
}

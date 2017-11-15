import java.util.ArrayList;
import java.util.List;

/**
 * Created by aimin on 2017/7/25.
 */
public class FastestSolution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        char[] array = new char[2 * n];
        generate(list, array, n, 0, 0);
        return list;
    }
    private void generate(List<String> list, char[] array, int n, int left, int right) {
        if (left == n && right == n) {
            list.add(new String(array));
        }
        if (left < n) {
            array[left + right] = '(';
            generate(list, array, n, left + 1, right);

        }
        if (right < left) {
            array[left + right] = ')';
            generate(list, array, n, left, right + 1);

        }
    }
}

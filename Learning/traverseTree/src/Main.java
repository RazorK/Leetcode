import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by aimin on 2017/7/25.
 */
public class Main {
    public static void main (String [] args) {
        BinaryTree bt = BinaryTree.createBinaryTree(Arrays.asList(1,2,3,4,5,6));
        Traverse.print(bt);
    }
}

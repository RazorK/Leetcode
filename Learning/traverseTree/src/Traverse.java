import java.net.BindException;
import java.util.List;

/**
 * Created by aimin on 2017/7/25.
 */
public class Traverse {

    public static void print(BinaryTree bt) {
        System.out.println(bt.getVal());
        if(bt.left!=null) Traverse.print(bt.left);
        if(bt.right!=null) Traverse.print(bt.right);
    }

}

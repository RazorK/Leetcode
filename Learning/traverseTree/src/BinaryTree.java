import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aimin on 2017/7/25.
 */
public class BinaryTree {
    private int val;
    BinaryTree parent;
    BinaryTree left;
    BinaryTree right;
    boolean init = false;

    BinaryTree() {}
    BinaryTree(int in) {
        val = in;
        init = true;
    }

    public void setVal(int v) {
        val = v;
        init = true;
    }
    public int getVal() {
        return val;
    }
    
    public static BinaryTree createBinaryTree(List<Integer> a) {
        BinaryTree [] flag = new BinaryTree[a.size()+1];
        for(int i=1;i<=a.size();i++) {
            flag[i] = new BinaryTree(a.get(i-1));
        }
        for(int i=1;i<=a.size();i++) {
            if(i!=1) flag[i].parent = flag[i/2];
            if(2*i<a.size()) flag[i].left = flag[2*i];
            if(2*i+1<a.size()) flag[i].right = flag[2*i+1];
        }
        return flag[1];
    }

}

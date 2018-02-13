import java.util.*;
public class Main {
    public static void main(String[] args) {
        String [] tes = {"1","+","12","*","3","-","7","*","5"};
        TreeNode node = ET.stringToTree(tes);
        System.out.println(ET.treeToAnswer(node));
    }
}

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // constant space idea, make use of the next property
    // BFS
    public void connect(TreeLinkNode root) {
        TreeLinkNode father = root;
        TreeLinkNode firstChild = null;
        TreeLinkNode lastChild = null;
        while(father != null || firstChild != null) {
            if(father != null) {
                
            }
        }
    }
}
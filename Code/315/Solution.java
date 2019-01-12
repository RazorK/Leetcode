class Solution {
    public List<Integer> countSmaller(int[] nums) {
        // IDEA from LC, binary search tree, construct a binary search tree backward, and count how many 
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        int l = nums.length;
        BinarySearchTree bst = new BinarySearchTree(nums[l-1]);
        res.add(0);
        for(int i=l-2; i>=0; i--) {
            res.add(0, bst.addVal(nums[i]));
        }
        return res;
    }

    public class TreeNode{
        TreeNode left, right;
        int val;
        int count;
        int subCount;
        public TreeNode(int v) {
            val = v;
            count = 1;
            subCount = 1;
        }
    }

    public class BinarySearchTree {
        TreeNode root;
        int size;
        public BinarySearchTree(int v) {
            root = new TreeNode(v);
            size = 0;
        }

        /**
         * return number of nodes smaller than val
         */
        public int addVal(int val) {
            return addVal(val, root);
        }

        public int addVal(int val, TreeNode root) {
            root.subCount++;

            if(root.val == val) {
                root.count++;
                return (root.left == null ? 0 : root.left.subCount);
            } else if(val > root.val) {
                if(root.right == null) {
                    root.right = new TreeNode(val);
                    return root.count + (root.left == null? 0 : root.left.subCount);
                }
                return addVal(val, root.right) + root.count + (root.left == null ? 0 : root.left.subCount);
            } else {
                if(root.left == null) {
                    root.left = new TreeNode(val);
                    return 0;
                }
                return addVal(val, root.left);
            }

        }

    }
}
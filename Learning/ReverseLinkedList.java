public class Solution {
    public static void ReverseLinkedList(LinkedNode root) {
        int len = 0;
        LinkedNode it = root;
        while(it!= null) {
            len++;
            it = it.next;
        }

        int split = (int)Math.sqrt(len);

        List<LinkedNode> store = new ArrayList<>();
        it = root;
        int ctr = 0;
        while(it != null) {
            if(ctr == 0) {
                store.add(it);
                ctr = split;
            }
            it = it.next;
            ctr--;
        }

        LinkedNode end = null;
        for(int i = store.size()-1; i>=0; i--) {
            List<Integer> out = new ArrayList<>();
            LinkedNode next = store.get(i);
            while(next != end) {
                out.add(next.val);
                next = next.next;
            }
            output(out);
            end = store.get(i);
        }
    }

    public class LinkedNode {
        int val;
        LinkedNode next;
        public LinkedNode (int v, LinkedNode n) {
            val = v;
            next = n;
        }
    }
}
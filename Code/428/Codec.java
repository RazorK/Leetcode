import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        if(root == null) return sb.toString();
        // try dfs
        dfs(root, sb);
        return sb.toString().trim();
    }

    public void dfs(Node root, StringBuilder sb) {
        sb.append(root.val).append(" ");
        for(Node next : root.children) {
            dfs(next, sb);
        }
        sb.append("# ");
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.isEmpty()) return null;
        String [] datas = data.split(" ");
        return decode(datas, new int[] {0});
    }
    
    // this i trick can be replaced by using a queue
    public Node decode(String [] data, int [] i) {
        if(data[i[0]].equals("#")) return null;
        Node cur = new Node();
        cur.val = Integer.parseInt(data[i[0]++]);
        cur.childern = new ArrayList<Node>();

        while(!data[i[0]].equals("#")) {
            cur.children.add(decode(data, i));
        }

        i[0]++;
        return cur;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
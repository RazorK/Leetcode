import java.util.*;
public class Solution {
    // Clone an undirected graph. Each node in the graph contains a label and a
    // list of its neighbors.
    //
    // OJ's undirected graph serialization:
    // Nodes are labeled uniquely.
    //
    // We use # as a separator for each node, and , as a separator for node label
    //  and each neighbor of the node.
    // As an example, consider the serialized graph {0,1,2#1,2#2,2}.
    //
    // The graph has a total of three nodes, and therefore contains three parts as separated by #.
    //
    // First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
    // Second node is labeled as 1. Connect node 1 to node 2.
    // Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
    // Visually, the graph looks like the following:
    //
    //        1
    //       / \
    //      /   \
    //     0 --- 2
    //          / \
    //          \_/

    // bfs idea
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashSet<UndirectedGraphNode> visited = new HashSet<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        LinkedList<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            UndirectedGraphNode cur = q.pollFirst();
            if(visited.contains(cur)) continue;
            if(!map.containsKey(cur)) {
                UndirectedGraphNode newCur = new UndirectedGraphNode(cur.label);
                map.put(cur, newCur);
            }
            for(UndirectedGraphNode next: cur.neighbors) {
                if(next == null) continue;
                if(!map.containsKey(next)) {
                    UndirectedGraphNode newNext = new UndirectedGraphNode(next.label);
                    map.put(next, newNext);
                }
                map.get(cur).neighbors.add(map.get(next));
                if(!visited.contains(next)) q.add(next);
            }
            visited.add(cur);
        }
        return map.get(node);
    }


    // recursion idea from LC
    // the idea of map is every node added into the map, already put all the child with the node.
    // the recursion function is used to add the node to map and return the new node.
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return helper(node, map);
    }

    public UndirectedGraphNode helper(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if(node == null) return null;
        UndirectedGraphNode newNode;
        if(!map.containsKey(node)) {
            newNode = new UndirectedGraphNode(node.label);
            map.put(node, newNode);
        } else return map.get(node);
        for(UndirectedGraphNode child : node.neighbors) {
            if(child == null) continue;
            if(map.containsKey(child)) {
                newNode.neighbors.add(map.get(child));
            } else {
                newNode.neighbors.add(helper(child, map));
            }
        }
        return newNode;
    }
}

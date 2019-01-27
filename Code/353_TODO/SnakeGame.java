import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

class SnakeGame {

    // it seems that we can use a linkedlist
    Deque<int []> dq;
    Set<Integer> body;
    int w, h, ptr;
    int [][] food;
    int sc;
    Map<String, int []> map;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        dq = new LinkedList<>();
        body = new HashSet<>();

        dq.addLast(new int [] {0, 0});
        body.add(getKey(0, 0));

        this.food = food;
        w = width;
        h = height;
        ptr = 0;
        sc = 0;

        // init pos map;
        map = new HashMap<>();
        map.put("U", new int[] {-1, 0});
        map.put("D", new int[] {1, 0});
        map.put("L", new int[] {0, -1});
        map.put("R", new int[] {0, 1});
    }

    private int getKey(int x, int y) {
        return x*w + y;
    }

    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if(!map.containsKey(direction)) return -1;
        int [] head = dq.getFirst();
        int [] food = ptr >= this.food.length? null : this.food[ptr];

        int [] next = new int [] {head[0] + map.get(direction)[0], head[1] + map.get(direction)[1]};
        
        if(body.contains(getKey(next[0], next[1])) && !Arrays.equals(next, dq.getLast())) return -1;
        if(next[0] < 0 || next[0] >= h || next[1] < 0 || next[1] >= w) return -1;

        body.add(getKey(next[0], next[1]));
        dq.addFirst(next);
        if(food != null && Arrays.equals(next, food)) {
            sc++;
            ptr++;
        } else {
            int [] last = dq.pollLast();
            body.remove(getKey(last[0], last[1]));
        }
        // for(int c : body) {System.out.print(c + ",");}
        // System.out.println("");
        return sc;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
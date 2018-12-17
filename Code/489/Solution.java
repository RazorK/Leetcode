/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    public static final int UP = 0;
    public static final int RIGHT = 1; 
    public static final int DOWN = 2;
    public static final int LEFT = 3;

    public void cleanRoom(Robot robot) {
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        dfs(robot, visited, 0, 0, 0);
        dfs(robot, visited, 0, 0, 2);

        // current direction up
        robot.turnLeft();
        dfs(robot, visited, 0, 0, 3);
        //direction right
        dfs(robot, visited, 0, 0, 1);
    }

    // finish at reverse direction
    public void dfs(Robot r, Map<Integer, Set<Integer>> visited, int x, int y, int direction) {
        System.out.println(x + "," + y + "," + direction);
        if((visited.containsKey(x) && visited.get(x).contains(y)) || !r.move()) {
            r.turnLeft();
            r.turnLeft();
            r.move();
            return;
        }

        r.clean();
        if(!visited.containsKey(x)) visited.put(x, new HashSet<>());
        visited.get(x).add(y);
        
        //four direction clean

        // left
        r.turnLeft();
        int [] cor1 = getCor(x, y, formatDirection(direction-1));
        dfs(r, visited, cor1[0], cor1[1], formatDirection(direction-1));

        // right, direction right currently
        int [] cor2 = getCor(x, y, formatDirection(direction + 1));
        dfs(r, visited, cor2[0], cor2[1], formatDirection(direction + 1));
        
        // up, direction left currently
        r.turnRight();
        int [] cor3 = getCor(x, y, direction);
        dfs(r, visited, cor3[0], cor3[1], direction);
        
        // return to original place, currect direction down;
        r.move();
    }

    public int[] getCor(int x, int y, int direction) {
        switch (direction) {
            case 3:
                return new int[] {x-1, y};
            case 1:
                return new int[] {x+1, y};
            case 0:
                return new int[] {x, y+1};
            case 2:
                return new int[] {x, y-1};
            default:
                break;
        }
        return null;
    }

    public int formatDirection(int x) {
        if(x < 0) x += 4;
        return x % 4;
    }
}
class Solution {
    // The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
    //
    // The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
    //
    // Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
    //
    // In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
    //
    //
    //
    // Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
    //
    // For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
    //
    // -2 (K)	-3	3
    // -5	-10	1
    // 10	30	-5 (P)
    //
    //
    // Note:
    //
    // The knight's health has no upper bound.
    // Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

    // First idea DP, keep in track the highest health need, and corresponding current health.
    // failed , beacause the minimum health can not transmit. Bigger mini Need and larger cur heal may produce little global mini need.
    public int firstTry(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int [][] minHealNeed = new int[dungeon.length][dungeon[0].length];
        int [][] curHealth = new int[dungeon.length][dungeon[0].length];

        // init first col
        for(int i=0; i<dungeon.length; i++) {
            int preHPNeed = i == 0? 1: minHealNeed[i-1][0];
            int preCurHeal = i == 0 ? 1: curHealth[i-1][0];
            if(dungeon[i][0] + preCurHeal >= 1) {
                minHealNeed[i][0] = preHPNeed;
                curHealth[i][0] = dungeon[i][0] + preCurHeal;
            } else {
                curHealth[i][0] = 1;
                minHealNeed[i][0] = preHPNeed - (dungeon[i][0] + preCurHeal - 1);
            }
        }

        // expand to right
        for(int j = 1; j<dungeon[0].length; j++) {
            for(int i=0; i<dungeon.length; i++) {
                // from left
                int leftHPNeed = minHealNeed[i][j-1];
                int leftCurHeal = curHealth[i][j-1];
                int fromLeftHPNeed, fromLeftCurHeal;
                if(dungeon[i][j] + leftCurHeal >= 1) {
                    fromLeftHPNeed = leftHPNeed;
                    fromLeftCurHeal = dungeon[i][j] + leftCurHeal;
                } else {
                    fromLeftHPNeed = leftHPNeed - (dungeon[i][j] + leftCurHeal - 1);
                    fromLeftCurHeal = 1;
                }

                if(i == 0) {
                    minHealNeed[i][j] = fromLeftHPNeed;
                    curHealth[i][j] = fromLeftCurHeal;
                    continue;
                }

                // from top
                int topHPNeed = minHealNeed[i-1][j];
                int topCurHeal = curHealth[i-1][j];
                int fromTopHPNeed, fromTopCurHeal;
                if(dungeon[i][j] + topCurHeal >= 1) {
                    fromTopHPNeed = topHPNeed;
                    fromTopCurHeal = dungeon[i][j] + topCurHeal;
                } else {
                    fromTopHPNeed = topHPNeed - (dungeon[i][j] + topCurHeal -1);
                    fromTopCurHeal = 1;
                }

                if(fromTopHPNeed > fromLeftHPNeed || (fromTopHPNeed == fromLeftHPNeed && fromLeftCurHeal > fromTopCurHeal)) {
                    minHealNeed[i][j] = fromLeftHPNeed;
                    curHealth[i][j] = fromLeftCurHeal;
                } else {
                    minHealNeed[i][j] = fromTopHPNeed;
                    curHealth[i][j] = fromTopCurHeal;
                }
            }
        }

        System.out.println(Arrays.deepToString(curHealth));
        System.out.println(Arrays.deepToString(minHealNeed));
        return minHealNeed[dungeon.length-1][dungeon[0].length-1];
    }

    // second try, end with 1, cannot less than 1, find the minimum end. Reverse
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int [][] board = new int[dungeon.length][dungeon[0].length];

        int last = 1;
        for(int i=dungeon.length-1; i>=0; i--) {
            for(int j=dungeon[0].length-1; j>=0; j--) {
                int cur = dungeon[i][j];
                if(i==dungeon.length-1 && j==dungeon[0].length-1) {
                    if(cur>=0) {
                        board[i][j] = last;
                    } else {
                        board[i][j] = last - cur;
                    }
                    continue;
                } else if(i == dungeon.length-1) {
                    if(cur<=0) {
                        board[i][j] = board[i][j+1] - cur;
                    } else {
                        if(board[i][j+1] - cur >= last) {
                            board[i][j] = board[i][j+1] - cur;
                        } else {
                            board[i][j] = last;
                        }
                    }
                    continue;
                } else if(j == dungeon[0].length-1) {
                    int fromBot;
                    if(board[i+1][j] - cur >= last) {
                        fromBot = board[i+1][j] - cur;
                    } else {
                        fromBot = last;
                    }
                    board[i][j] = fromBot;
                    continue;
                } else {
                    int fromRight;
                    if(board[i][j+1] - cur >= last) {
                        fromRight = board[i][j+1] - cur;
                    } else {
                        fromRight = last;
                    }

                    int fromBot;
                    if(board[i+1][j] - cur >= last) {
                        fromBot = board[i+1][j] - cur;
                    } else {
                        fromBot = last;
                    }

                    board[i][j] = Math.min(fromRight, fromBot);
                }
            }
        }
        return board[0][0];
    }
}

class Solution {
    public boolean judgeCircle(String moves) {
        int u = 0, l = 0;
        for(char cur : moves.toCharArray()) {
            switch(cur) {
                case 'U':
                    u++; break;
                case 'D':
                    u--; break;
                case 'L':
                    l++; break;
                case 'R':
                    l--; break;
                default:
            }
        }

        return u == 0 && l == 0;
    }
}
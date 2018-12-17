class Solution {

    static char [] limited = new char[] {'1', '8', '0'};
    static char [] unlimited = new char[] {'0', '1', '6', '8', '9'};
    public List<String> findStrobogrammatic(int n) {
        boolean even = n % 2 == 0;
        char [] base = new char[ even ? n/2 : n/2 + 1];

        List<String> res = new ArrayList<>();
        dfs(base, 0, even, res);
        return res;
    }

    public void dfs(char [] base, int index, boolean even, List<String> res) {
        if(index == base.length) {
            res.add(getString(base, even));
            return ;
        }

        char [] set = (index == base.length-1 && !even) ? limited : unlimited;
        for(char i : set) {
            // bug: should produce 0
            if(i == '0' && index == 0 && !(!even && base.length == 1)) continue;
            base[index] = i;
            dfs(base, index + 1, even, res);
        }
    }

    public String getString(char[] base, boolean even) {
        int l = 2 * base.length - (even ? 0 : 1);
        char [] res = new char [l];
        for(int i=0; i<base.length; i++)  {
            int j = l - i - 1;
            res[i] = base[i];
            res[j] = getChar(base[i]);
        }
        return new String(res);
    }

    public char getChar(char i) {
        if(i == '6') return '9';
        if(i == '9') return '6';
        return i;
    }
}
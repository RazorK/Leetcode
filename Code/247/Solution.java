class Solution {
    static char [] choices = new char [] {'1', '8', '6', '9', '0'};
    static char [] limited = new char [] {'1', '8', '6', '9'};

    public List<String> findStrobogrammatic(int n) {
        if(n == 1) return Arrays.asList(new String [] {"0", "1", "8"});
        boolean odd = n % 2 != 0;
        int len = odd ? n /2 + 1 : n / 2;
        char [] keys = new char [len];

        // recurrsive
        List<String> res = new ArrayList<>();
        recur(keys, 0, odd, res);
        return res;
    }

    public void recur(char [] keys, int id, boolean odd, List<String> res) {
        if(id == keys.length) {
            res.add(construct(keys, odd));
            return;
        }

        char [] cs = id == 0 ? limited : choices;
        for(int i=0; i<cs.length; i++) {
            if(odd && id == keys.length - 1 && (cs[i] == '6' || cs[i] == '9')) continue;
            keys[id] = cs[i];
            recur(keys, id + 1, odd, res);
        }
    }

    public String construct(char [] keys, boolean odd) {
        StringBuilder sb = new StringBuilder();
        if(odd) {
            sb.append(keys[keys.length-1]);
            for(int i=keys.length-2; i>=0; i--) {
                sb.append(keys[i]);
                sb.insert(0, findPair(keys[i]));
            }
        } else {
            for(int i=keys.length-1; i>=0; i--) {
                sb.append(keys[i]);
                sb.insert(0, findPair(keys[i]));
            }
        }
        return sb.toString();
    }

    public char findPair(char cur) {
        if(cur == '6') return '9';
        if(cur == '9') return '6';
        return cur;
    }
}
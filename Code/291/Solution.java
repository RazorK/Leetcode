class Solution {

    // first idea dfs.
    public boolean wordPatternMatch(String pattern, String str) {
        String [] map = new String [26];
        Arrays.fill(map, null);
        // BUG 1: same as word pattern 1: one to one relation, so need a set
        Set<String> set = new HashSet<>();
        return helper(pattern.toCharArray(), str.toCharArray(), 0, 0, map, set);
    }

    public boolean helper(char[] p, char [] strs, int pid, int sid, String [] map, Set<String> set) {
        if(pid == p.length && sid == strs.length) return true;
        if(pid == p.length || sid == strs.length) return false;

        if(map[p[pid]-'a'] != null) {
            int res = check(strs, sid, map[p[pid]-'a']);
            if(res == -1) return false;
            return helper(p, strs, pid+1, res, map, set);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; sid + i < strs.length; i++) {
            sb.append(strs[sid+i]);
            if(set.contains(sb.toString())) continue;
            map[p[pid] - 'a'] = sb.toString();
            set.add(sb.toString());
            if(helper(p, strs, pid+1, sid+i+1, map, set)) return true;
            map[p[pid] - 'a'] = null;
            set.remove(sb.toString());
        }
        return false;
    }

    public int check(char[] strs, int start, String target) {
        int i;
        for(i=0; i<target.length(); i++) {
            if(start + i >= strs.length) return -1;
            if(strs[start + i] != target.charAt(i)) return -1;
        }
        return start+i;
    }
}
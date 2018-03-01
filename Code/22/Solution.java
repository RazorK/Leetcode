class Solution {
    // Given n pairs of parentheses, write a function to generate all combinations
    // of well-formed parentheses.
    //
    // For example, given n = 3, a solution set is:
    //
    // [
    //   "((()))",
    //   "(()())",
    //   "(())()",
    //   "()(())",
    //   "()()()"
    // ]
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n<=0) return res;
        recur(new StringBuilder(), 0, 0, n, res);
        return res;
    }

    public void recur(StringBuilder sb, int left, int right, int limit, List<String> res) {
        if(left + right >= limit*2) res.add(sb.toString());
        if(left<limit) {
            sb.append('(');
            recur(sb, left+1, right, limit, res);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right < left) {
            sb.append(')');
            recur(sb, left, right+1, limit, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

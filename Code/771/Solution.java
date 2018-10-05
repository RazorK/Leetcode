class Solution {
    public int numJewelsInStones(String J, String S) {
        if(J == null || J.length() == 0 || S == null || S.length() == 0)  return 0;
        boolean [] map = new boolean [256];
        for(int i=0; i<J.length(); i++) {
            map[(int)J.charAt(i)] = true;
        }
        int res = 0;
        for(int i=0; i<S.length(); i++) {
            if(map[(int)S.charAt(i)]) res++;
        }
        return res;
    }
}
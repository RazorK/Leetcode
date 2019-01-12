class Solution {
    // nothing new, just use int[] to replace map
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int bits=0;
        int[] map= new int[1<<maxChoosableInteger];
        if(maxChoosableInteger>=desiredTotal) return true;
        int sum=(1+maxChoosableInteger)*maxChoosableInteger/2;
        if(sum<desiredTotal) return false;
        return canIWin(maxChoosableInteger, desiredTotal, bits, map);
    }
    
    private boolean canIWin(int max, int target, int bits, int[] map){
        if(map[bits]!=0) return map[bits]==1;
        for(int i=1; i<=max; ++i){
            int mask=1<<(i-1);
            if((mask&bits)!=0) continue;
            if(i>=target||!canIWin(max, target-i, bits|mask, map)){
                map[bits]=1;
                return true;
            }
        }
        map[bits]=-1;
      return false;
    }  
}
class Solution {
    // we know that 4 can not win, because whatever 1 , 2, 3 remove, the next person will always win.
    // Then we know that 8 is the same, because what ever we choose, 1, 2, 3, the opposite can always leave a 4 for you.
    public boolean canWinNim(int n) {
        return n%4!=0;
    }
}
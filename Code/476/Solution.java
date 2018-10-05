class Solution {
    public int findComplement(int num) {
        int res = 0;
        boolean start = false;
        for(int i=1; i<32; i++) {
            if(!start && (num >> (32 - i) & 1) == 1) start = true;
            if(start && (num >> (32-i) & 1 )== 0) {
                res += 1 << (32 - i);
            }
        }
        print(num);
        print(res);
        return res;
    }

    public void print(int num) {
        for(int i=0; i<32; i++) {
            System.out.print(num >> (32 - i) & 1);
        }
        System.out.print("\n");
    }
}
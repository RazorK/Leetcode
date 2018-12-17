/* The read4 API is defined in the parent class Reader4.
    int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char [] left = new char[4];
    int leftPtr = 0;
    int leftEnd = 0;
    public int read(char[] buf, int n) {
        int curPtr = 0;
        while(true) {
            while(leftPtr < leftEnd) {
                buf[curPtr ++] = left[leftPtr++];
                n--;
                if(n == 0) return curPtr;
            }
            leftEnd = read4(left);
            leftPtr = 0;
            if(leftEnd == 0) return curPtr;
        }
    }
}
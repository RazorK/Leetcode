class Solution {
    // misunderstand the question... L and R have move direction restriction
    public boolean canTransform(String start, String end) {
        int left = 0, right = 0;
        while(true) {
            left = getNext(start, left);
            right = getNext(start, right);
            if(left == -1 || right == -1) return left == right;
            if(start.charAt(left) != end.charAt(right)) return false;
            if(start.charAt(left) == 'L' && left <= right) return false;
            if(start.charAt(left) == 'R' && left >= right) return false;
            left ++;
            right ++;
        }
    }

    public int getNext(String str, int i) {
        while(i < str.length() && str.charAt(i) == 'X') i++;
        return i >= str.length() ? -1 : i;
    }
}
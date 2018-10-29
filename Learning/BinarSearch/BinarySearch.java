public class BinarySearch {

    public static int binarySearch(int [] data, int target) {
        int left = 0, right = data.length-1;
        while(left < right) {
            int mid = left + (right - left)/2;
            int cur = data[mid];
            if(cur == target) return mid;
            else if(cur < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(data[left] == target) return left;
        return data[left] > target ? left : left + 1;
    }

    public static int converse(int num) {
        return -num-1;
    }

    public static void main(String [] args) {
        int [] in = {1,3,5,7,9};
        System.out.println(binarySearch(in, 12));
    }
}
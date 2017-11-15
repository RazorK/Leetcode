class Solution {
    // it's kind of hard to figure out relation between n, k, n-k
    // used more space
    // corner case:k>=n, nums.length<=1

    //fastest
    //corner case k<0
    // System.arraycopy(src,srcStart, dest, destStart, length)
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k>=n) k = k%n;
        if(n<=1) return;
        int [] temp = new int[k];
        for(int i=0;i<k;i++) {
          temp[i] = nums[n-k+i];
        }
        for(int i=n-1;i>=k;i--) {
          nums[i] = nums[i-k];
        }
        for(int i=0;i<k;i++) {
          nums[i] = temp[i];
        }
    }

    //constant space but exceed time limit
    // right shift k times
    public static void repeat_rotate(int[] nums, int k) {
      if(nums.length<=1) return;
      k = k%nums.length;
      for(int i=0; i<k; i++) {
        int temp = nums[0];
        int get;
        for(int j=0; j<nums.length; j++) {
          int target =  (j+1)% nums.length;
          get = nums[target];
          nums[target] = temp;
          temp = get;
        }
      }
    }

    //another amazing way to finish in constant space
    // just tricky and amazing
    // i++, and count the number of changes, if all changes then stop.
    public static void constant_space(int [] nums, int k) {
      if (nums.length == 0 || k == 0 || k % nums.length == 0) {
          return;
      }
      k = k % nums.length;
      int count = 0;
      for (int i = 0; count < nums.length; i++) {
          int curr = i;
          int prev = nums[curr];
          do {
              int next = (curr + k) % nums.length;
              int tmp = nums[next];
              nums[next] = prev;
              prev = tmp;
              curr = next;
              count++;
          } while (curr != i);
      }
    }

    //by reverse, just hard to think up
    // reverse all, reverse first part (k), reverse latter
    public static void byReverse(int [] nums, int k) {
      if (nums.length == 0 || k == 0 || k % nums.length == 0) {
          return;
      }
      int n = nums.length;
      k = k % n;

      Reverse(nums, 0, n-1);
      Reverse(nums, 0, k-1);
      Reverse(nums, k, n-1);
    }

    public static void Reverse(int [] nums, int start, int end) {
      while (start <= end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start ++;
        end --;
      }
    }

    //fasteset
    public void rotate_suggested(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0) return;

        int N = nums.length;
        k = (k >= 0) ? k % N : N + k % N;
        int[] newnums = new int[nums.length];
        System.arraycopy(nums, N - k, newnums, 0, k);
        System.arraycopy(nums,0, newnums, k, N - k);
        System.arraycopy(newnums,0, nums, 0, N);
    }
}

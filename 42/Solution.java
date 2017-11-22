class Solution {

    // my solution here.
    // main idea:
    // for the iteration, there will be three different situation:
    //  4 3 2 1 end
    //  4 2 1 2 end
    //  4 3 5 1 end

    // bugs: 4
    public static int trap(int[] height) {
        if(height.length<=2) return 0;
        int result = 0, count = 0;
        int start = count;
        int max = start+1;
        int level = 0;

        // to find the one larger than start or the end(then keep the max)
        // if find the end, keep the max, and add the space between, then
        // start from the max
        // if find the larger height, just start from the next and calculate
        // the space between
        while(true) {
            count++;
            // System.out.println("count"+Integer.toString(count));
            // System.out.println("start"+Integer.toString(start));
            // System.out.println("max"+Integer.toString(max));

            // a greater max
            // bug 1 : forget the first condition
            // count can be length+1
            // bug 2 : sequence of three if statement
            // this is more general one , so first
            if(count<height.length && height[count]> height[max]) {
                // System.out.println("greater");
                max = count;
            }

            // find the end
            if(count >= height.length) {
                // System.out.println("inFind The End");
                // System.out.println("count"+Integer.toString(count));
                // System.out.println("start"+Integer.toString(start));
                // System.out.println("max"+Integer.toString(max));
                // System.out.println(max==start);

                if(max>height.length-1) break;
                level = height[max];
                for(int i=start+1;i< max; i++) {
                    result += level - height[i];
                }
                //System.out.println(result);
                start = max;
                count = max;

                // bug 3 : max has to be start + 1,
                // because we need to use start and max to calculate the level
                // bug 4 : max can be the last one
                if(max+1> height.length-1) break;
                max = max+1;
                continue;
            }

            //find the bigger one
            if(height[count]>=height[start]) {
                // System.out.println("in bigger");
                level = height[start];
                for(int i=start+1;i< count; i++) {
                    result += level - height[i];
                }
                //System.out.println(result);
                start = count;

                // bug : same as bug 4
                if(start+1> height.length-1) break;
                max = start+1;
                continue;
            }
        }
        return result;
    }

    // two pointer from bidirection
    // it is linear!!
    // main idea:
    // two pointers, if left is higer than the right, then height between which are
    // lower than right will be filled with water, and the height will be exactly the
    // rightM.

    // how to think this up?
    public int trap(int[] height) {
        int left = 0;
        int right = height.length -1;
        int leftM = 0;
        int rightM = 0;
        int total = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                if(height[left] >= leftM) {
                    leftM = height[left];
                } else {
                    total+= leftM - height[left];
                }
                left++;
            } else {
                if(height[right] >= rightM) {
                    rightM = height[right];
                } else {
                    total += rightM - height[right];
                }
                right--;
            }
        }
        return total;
    }


}

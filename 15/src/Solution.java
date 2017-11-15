import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;

/**
 * Created by aimin on 2017/7/17.
 */
public class Solution {

    //超时。。
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<Integer> ori = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            ori.add(nums[i]);
        }

        ArrayList<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<ori.size();i++) {
            int temp = ori.get(i);
            ori.remove(i);
            for(int j=0;j<ori.size();j++) {
                int tempj = ori.get(j);
                ori.remove(j);
                if(ori.contains(-temp-tempj)) {
                    ArrayList<Integer> input = new ArrayList<>();
                    input.add(temp);
                    input.add(tempj);
                    input.add(0-temp-tempj);

                    input.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            if(o1>o2) return 1;
                            else if(o1<o2) return -1;
                            else return 0;
                        }
                    });

                    if(!res.contains(input)) {
                        res.add(input);
                    }
                }
                ori.add(j,tempj);
            }
            ori.add(i,temp);
        }

        return res;
    }

    //还是超时。。。 心态爆炸
    public List<List<Integer>> better(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int zero = 0;
        for (int num:nums) {
            if(num>0) pos.add(num);
            else if(num<0) neg.add(num);
            else zero++;
        }

        System.out.println(pos.toString()+neg.toString()+zero);
        if(zero>=3) res.add(Arrays.asList(0,0,0));
        if(zero>=1) {
            for(int i=0;i<pos.size();i++) {
                if(neg.contains(-pos.get(i))) {
                    List<Integer> input = Arrays.asList(-pos.get(i),0,pos.get(i));
                    if(!res.contains(input)) res.add(input);
                }
            }
        }

        for(int i=0;i<pos.size()-1;i++) {
            for(int j=i+1;j<pos.size();j++) {
                if(neg.contains(0-pos.get(i)-pos.get(j))){
                    List<Integer> input = pos.get(i)>pos.get(j)?Arrays.asList(-pos.get(i)-pos.get(j),pos.get(j),pos.get(i)):
                            Arrays.asList(-pos.get(i)-pos.get(j),pos.get(i),pos.get(j));
                    if(!res.contains(input)) res.add(input);
                }
            }
        }

        for(int i=0;i<neg.size()-1;i++) {
            for(int j=i+1;j<neg.size();j++) {
                if(pos.contains(0-neg.get(i)-neg.get(j))) {
                    List<Integer> input = neg.get(i)>neg.get(j)?Arrays.asList(neg.get(j),neg.get(i),0-neg.get(i)-neg.get(j)):
                            Arrays.asList(neg.get(i),neg.get(j),0-neg.get(i)-neg.get(j));
                    if(!res.contains(input)) res.add(input);
                }
            }
        }

        return res;
    }


    /**
     * 重点 先排序 之后可以省去一次循环
     * 1.可以根据当前结果判断指针向哪个方向移动
     * 2.可以很快过滤重复值
     *
     * @param num
     * @return
     */

    public List<List<Integer>> aftersort(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public static void main(String [] args) {
        int [] input = {-1,0,1,2,-1,-4};
        new Solution().better(input);
    }
}

import java.util.*;

class Solution {
    // has to figure out  where the list<Integer> come from
    // find out the relation
    // read from the double list may cause more time ?
    public static List<List<Integer>> generate(int numRows) {
        List<List <Integer>> result = new ArrayList<>();
        List<Integer> init = Arrays.asList(1);
        if(numRows==0) return result;
        result.add(init);
        if(numRows == 1) return result;
        numRows = numRows + 1;
        for(int i=0; i< numRows-2; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=1;j<i+1;j++) {
                temp.add(result.get(i).get(j-1)+result.get(i).get(j));
            }
            temp.add(1);
            result.add(temp);
            System.out.println(result);
        }
        return result;
    }

    public List<List<Integer>> faster(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i=0; i < numRows; i++) {
            // here add  promise the set operation will not overflow
            temp.add(1);
            // use backward to implement in place
            for(int j = i-2;j>0;j--) {
                temp.set(j, temp.get(j-1)+temp.get(j));
            }

            // create new arraylist here.
            res.add(new ArrayList<Integer>(temp));
        }
        return res;
    }
}

import java.util.*;
class Solution {
	// what's different? we can not use the same value, my first idea is just
	// pass the next value;

	//attention : the candidates in this problem ! ! can ! ! be duplicate, not
	public static List<List<Integer> > combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
		List<List<Integer> > result =  new ArrayList<List<Integer> >();
		List<Integer> temp = new ArrayList<Integer>();
		redfs(candidates, target, result, temp, 0, -1);
		return result;
	}

	// here I spend so many time to try to cover all the corner case
	// try to record my think method
	// just change i-> i+1, not work, because the next loop will leads to duplicate result
	// another problem -> [2,2,2], 4 return [2,2],[2,2],[2,2]

	// to solve this problem, have to figure out that all the duplicate problem can be solve
	// by the first recursion in the loop, the following apperance will all be redundant.

	// also have to distinguish loop and recursion
	// recursion -> depth of the tree
	// loop -> span of the tree node.
	public static void redfs(int[] cans, int target, List<List<Integer> > result,
    List<Integer> temp, int number, int cur) {
        int curr = -1;
		for(int i=number; i< cans.length; i++ ) {
			if(curr == cans[i]) continue;
			List <Integer> local = new ArrayList<Integer> (temp);
			if(target > cans[i]) {
				local.add(cans[i]);
                if(i+1<cans.length){
                    redfs(cans, target - cans[i], result, local, i+1, cans[i]);
                }
			} else if(target == cans[i]&&curr!=cans[i]) {
				local.add(cans[i]);
				result.add(local);
			}
            curr = cans[i];
		}
		return;
	}
}

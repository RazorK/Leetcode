import java.util.*;

class Solution {
	public static List<List<Integer> > combinationSum(int[] candidates, int target) {
		//first idea: use hash map to record the target, and to divede the target
		// into several, but will repeat a lot, which may leads to lots of cost
		// seems difficult

		//after loot at the solution, use recursion and DFS, result consider
		//less about the problem of reuse
		//then first try the recursion Solution
		// main idea leads to no repeatation: every deeper select no smaller candidates
		Arrays.sort(candidates);
		List<List<Integer> > result =  new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		dfs(candidates, target, result, temp, 0);
		//System.out.println(result.toString());
		return result;
	}

	// !! pay attention, where each temp come from, we have to reassign a local
	// arraylist to avoid the append to the temp influence the following loop.
	// !! and also pay attention to the idea of pass the reference rather than value
	public static void dfs(int[] cans, int target,
	                       List<List<Integer> > result, List<Integer> temp, int number) {
		for(int i=number; i< cans.length; i++ ) {
			List <Integer> local = new ArrayList<Integer> (temp);
			if(target > cans[i]) {
				local.add(cans[i]);
				dfs(cans, target - cans[i], result, local, i);
			} else if(target == cans[i]) {
				local.add(cans[i]);
				result.add(local);
			}
		}
		return;
	}

	// no need to use storage to store the result, because the dps try every possible combinationSum
	// only once without repeatation, so the extra storage will be of no use.
}

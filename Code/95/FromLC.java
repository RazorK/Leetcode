class FromLC {
	// the fastest solution from LC.
	public List<TreeNode> generateTrees(int n) {
		if(n < 1)
			return new ArrayList<>();
		List<TreeNode>[][] dp = new List[n+2][n+2];
		return helper(1, n, dp);
	}

	public List<TreeNode> helper(int start, int end, List[][] dp){
		if(dp[start][end] != null)
			return dp[start][end];
		List<TreeNode> list = new ArrayList<>();
		if(start > end) {
			list.add(null);
		}
		else if(start==end) {
			list.add(new TreeNode(start));
		}
		else{
            // NOTE here it seems that it avoids the left and right null problem
            // by adding null to the dp board, when iteration, if encounter null, still enter.
			for(int i = start; i <= end; i++) {
				List<TreeNode> left = helper(start, i-1, dp);
				List<TreeNode> right = helper(i+1, end, dp);
				for(TreeNode l : left) {
					for(TreeNode r : right) {
						TreeNode node = new TreeNode(i);
						node.left = l;
						node.right = r;
						list.add(node);
					}
				}
			}
		}
		dp[start][end] = list;
		return list;
	}

}

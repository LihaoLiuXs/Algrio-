
public class BurstBalloons {//Lihao Liu
	
	public static void main(String[] args) {
		//Given n balloons, indexed from 0 to n-1. 
		//Each balloon is painted with a number on it represented by array nums. 
		//You are asked to burst all the balloons. 
		//If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
		//Here left and right are adjacent indices of i. 
		//After the burst, the left and right then becomes adjacent.
		//
		//First, think about dfs, then try to do pruning
		//Each time, assuming the balloons is the last one to burst
		int[] input = {3,1,5,8};
		System.out.println(maxCoins(input));
		int[] input2 = {3};
		System.out.println(maxCoins(input2));
		int[] input3 = {2,2,2,2,2,2};
		System.out.println(maxCoins(input3));
	}

    public static int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        return lastBurst(nums, dp, 0, nums.length - 1);      
    }
 
    private static int lastBurst(int[] nums, int[][] dp, int left, int right){
        if (left > right){
            return 0; 
        }
        if (dp[left][right] != 0){
            return dp[left][right]; 
        }
        int max = 0; 
        for (int i = left; i <= right; i++){
            int score = lastBurst(nums, dp, left, i - 1)
                + getVal(left - 1, nums) * getVal(i, nums) * getVal(right + 1, nums)
                + lastBurst(nums, dp, i + 1, right); 
            max = Math.max(max, score); 
        }
        dp[left][right] = max; 
        return max; 
    }
 
    private static int getVal(int i, int[] nums) {
    	if (i < 0) return 1; 
    	if (i >= nums.length) return 1; 
    	return nums[i]; 
    }	
}

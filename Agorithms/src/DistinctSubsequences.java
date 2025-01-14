 
public class DistinctSubsequences {

	public static void main(String[] args) {//Lihao Liu
		//Given a string S and a string T, count the number of distinct subsequences of S which equals T.
		//A subsequence of a string is a new string which is formed from 
		//the original string by deleting some (can be none) of the characters without disturbing 
		//the relative positions of the remaining characters. 
		//(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
		System.out.println(numDistinct("rabbbit", "rabbit"));
	}

    public static int numDistinct(String s, String t) {
        int S = s.length();
        int T = t.length();
        int[][] dp = new int[S+1][T+1];
        for (int i = 0; i <= S; i++){dp[i][0] = 1;}
        for (int i = 1; i <= S; i++){
            for (int j = 1; j <= T; j++){
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j]; 
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[S][T];
    }
}

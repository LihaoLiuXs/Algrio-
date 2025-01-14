
public class REM_pruning_v3 {//RegularExpressionMatching

	public static void main(String[] args) {
		//Given an input string (s) and a pattern (p), 
		//implement regular expression matching with support for '.' and '*'.
		//'.' Matches any single character.
		//'*' Matches zero or more of the preceding element.
		//The matching should cover the entire input string (not partial).
		//s could be empty and contains only lowercase letters a-z.
		//p could be empty and contains only lowercase letters a-z, and characters like . or *.
		//DFS pruning solution
        System.out.println(isMatch("aa","a")); //false 
        System.out.println(isMatch("aa","a*")); //true
        System.out.println(isMatch("ab",".*")); //true
        System.out.println(isMatch("aab","c*a*b")); //true
        System.out.println(isMatch("mississippi","mis*is*p*.")); //false
	}
    public static boolean isMatch(String s, String p) {
        if (s == null && p == null) return true; 
        int[][] dp = new int[s.length()+1][p.length()+1];
        checkMatch(s, p, 0, 0, dp) ;
        return dp[0][0] == 1 ? true : false; 
    }
    private static int checkMatch(String s, String p, int i, int j, int[][] dp){
         if (dp[i][j] != 0) return dp[i][j]; 
         boolean canMatch; 
         if (i == s.length() && j == p.length()){
             dp[i][j] = 1; 
             return 1; 
         }
         boolean firstMatch = false; 
         if (i < s.length() && j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
             firstMatch = true; 
         }
         if (j + 1 < p.length() && p.charAt(j + 1) == '*'){
             boolean zero = checkMatch(s, p, i, j + 2, dp) == 1; 
             boolean more = firstMatch && checkMatch(s, p, i + 1, j, dp) == 1; 
             canMatch = zero || more; 
         }
         else {
             canMatch = firstMatch && checkMatch(s, p, i + 1, j + 1, dp) == 1;
         }
         dp[i][j] = canMatch ? 1 : -1; 
         return dp[i][j];  
    }
}

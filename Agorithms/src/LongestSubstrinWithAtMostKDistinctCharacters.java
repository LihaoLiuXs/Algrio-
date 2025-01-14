import java.util.HashMap;

public class LongestSubstrinWithAtMostKDistinctCharacters {

	public static void main(String[] args) {
		//Given a string, find the length of the longest substring T that contains at most k distinct characters.
		System.out.println(lengthOfLongestSubstringKDistinct("eceba",2));
		System.out.println(lengthOfLongestSubstringKDistinct("aa",1));
	}

	public static int lengthOfLongestSubstringKDistinct(String s, int k) { //Lihao Liu
        if (s == null || s.length() == 0 || k <= 0) return 0;
        int max = 1; 
        int slow = 0, fast = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (fast < s.length()) {
            if (map.size() <= k) {
                 char cur = s.charAt(fast);
                 Integer count = map.get(cur);
                 if (count != null) {
                     map.put(cur, count + 1);
                 }
                 else {
                     map.put(cur, 1);
                 }
                //System.out.println(s.charAt(fast));
                max = Math.max(max, fast - slow);
                fast++;                 
            }
            else {
                 char cur = s.charAt(slow); 
                 Integer count = map.get(cur);
                 if (count == 1) {
                     map.remove(cur);
                 }
                 else {
                     map.put(cur, count - 1);
                 }
                 //System.out.println("slow :" + s.charAt(slow) + map.size());
                 slow++;
            }
        }   
        return map.size() <= k ? Math.max(max, fast - slow) : max;   
    }
}

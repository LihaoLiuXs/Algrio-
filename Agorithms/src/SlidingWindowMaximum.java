import java.util.*;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		//Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
		//You can only see the k numbers in the window. Each time the sliding window moves right by one position. 
		//Return the max sliding window.
		int[] input = {1,3,-1,-3,5,3,6,7}; 
		int[] res = maxSlidingWindow(input, 3);
		for (int i : res) System.out.println(i);
	}
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0]; 
        int[] res = new int[nums.length - k + 1]; 
        Deque<Integer> deque = new ArrayDeque<>();
        int resIndex = 0; 
        for (int i = 0; i < nums.length; i++){
            int cur = nums[i];
            while (!deque.isEmpty()) {
                if (deque.peekLast() < cur) {
                    deque.pollLast();
                }
                else { 
                    break;
                }
            }
            deque.offerLast(cur);
            if (i >= k - 1) {
                res[resIndex] = deque.peekFirst();
                resIndex++; 
                if (nums[i - k + 1] == deque.peekFirst()) {
                    deque.pollFirst(); 
                }
            }
        }    
        return res;
    }
}

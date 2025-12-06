class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int MOD = 1_000_000_007;
        
        int[] dp = new int[n + 1];
        dp[0] = 1; 
        
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        
        long windowSum = 0;
        int left = 0;
        
        for (int i = 0; i < n; i++) {
            windowSum = (windowSum + dp[i]) % MOD;
            
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[i]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(i);
            
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[i]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(i);
            
            while (!maxDeque.isEmpty() && !minDeque.isEmpty() && 
                   nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {
                
                windowSum = (windowSum - dp[left] + MOD) % MOD;
                left++;
                
                if (maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
            }
            
            dp[i + 1] = (int) windowSum;
        }
        
        return dp[n];
    }
}
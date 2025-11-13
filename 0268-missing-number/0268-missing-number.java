class Solution {
    public int missingNumber(int[] nums) {
        int N =nums.length;
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int total=(N*(N+1))/2;
        return total-sum;
    }
}
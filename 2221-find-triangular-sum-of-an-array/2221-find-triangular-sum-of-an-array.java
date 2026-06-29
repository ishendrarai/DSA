class Solution {
    public int triangularSum(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int ans = Sum(nums);
        return ans;
    }
    public int Sum(int[] nums){
        if(nums.length==1){
            return nums[0];
        }
        int[] newNums = new int[nums.length-1];
        for(int i=1;i<nums.length;i++){
            newNums[i-1]=(nums[i]+nums[i-1])%10;
        }
        return Sum(newNums);
    }
}
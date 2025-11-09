class Solution {
    public int maxFrequencyElements(int[] nums) {
        int max=0;
       int n = nums.length;
       for(int i=0;i<nums.length;i++){
         max=Math.max(nums[i],max);
       }
       int[] hash = new int[max+1];
       for(int i=0;i<n;i++){
        hash[nums[i]]++;
       }
       int maxFreq=0; 
       for(int i=0;i<=max;i++){
        if(hash[i]!=0){
            maxFreq=Math.max(maxFreq,hash[i]);
        }
       }
       int ans =0;
       for(int i=0;i<=max;i++){
            if(hash[i]==maxFreq){
                ans+=maxFreq;
            }
       }
       return ans;
    }
}
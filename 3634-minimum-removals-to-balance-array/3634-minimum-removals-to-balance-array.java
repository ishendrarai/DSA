class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i=0;
        int j=0;
        int L=1;
        while(j<n){
            while(i<j && nums[j]>(long)k*nums[i]){
                i++;
            }
            L=Math.max(L,j-i+1);
            j++;
        }
        return n-L;

    }
}
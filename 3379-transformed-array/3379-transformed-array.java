class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            result[i]=transArray(i,nums);
        }
        return result;
    }
    private int transArray(int index,int[]nums){
        int n= nums.length;
        int ans = nums[index]%n;
        int newIndex = (index+ans)%n;
        if(newIndex<0){
            newIndex+=n;
        }
        return nums[newIndex];
    }
}

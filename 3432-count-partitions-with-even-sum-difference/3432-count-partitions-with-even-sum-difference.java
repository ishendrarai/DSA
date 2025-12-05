class Solution {
    public int countPartitions(int[] nums) {
        int count =0;
        for(int i=0;i<nums.length-1;i++){
            int left = sum(nums,0,i);
            int right = sum(nums,i+1,nums.length-1);
            int diff  = Math.abs(right-left);
            if(diff%2==0){
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
    private int sum(int[] array,int lIndex,int rIndex){
        int sum =0;
        for(int i=lIndex;i<=rIndex;i++){
            sum+=array[i];
        }
        return sum;
    }
}
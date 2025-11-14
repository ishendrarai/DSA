class Solution {
    public int majorityElement(int[] nums) {
        int temp = 0;
        int ele = 0;
        for(int i=0;i<nums.length;i++){
            if(temp==0){
                ele=nums[i];
                temp=1;
            }
            else if(nums[i]==ele){
                temp++;
            }
            else{
                temp--;
            }
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele){
                count++;
            }
        }
        if(count>(nums.length/2)){
            return ele;
        }
        return -1;
    }
}
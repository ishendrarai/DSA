class Solution {
    public String largestOddNumber(String num) {
        String ans ="";
        for(int i=num.length()-1;i>=0;i--){
            int c = (int) num.charAt(i);
            if(c%2==1){
                ans = num.substring(0,i+1);
                break;
            }
        }
       return ans.isEmpty() ? "" : ans;
        
    }
}
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int X = x;
        int ans =0;
        while(X>0){
            int r = X%10;
            ans = ans*10+r;
            X=X/10;
        }
        if(ans==x){
            return true;
        }
        return false;  
    }
}
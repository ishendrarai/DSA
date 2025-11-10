class Solution {
    public int countOperations(int num1, int num2) {
        return helper(num1,num2,0);
    }
    public int helper(int n1,int n2,int opr){
        if(n1==0||n2==0){
            return opr;
        }
        if(n1>=n2){
            n1=n1-n2;
        }else{
            n2=n2-n1;
        }
        opr++;
        return helper(n1,n2,opr);
    }
}
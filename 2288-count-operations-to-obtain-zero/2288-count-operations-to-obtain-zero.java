class Solution {
        int opr=0;
    public int countOperations(int num1, int num2) {
        helper(num1,num2);
        return opr;
    }
    public void helper(int n1,int n2){
        if(n1==0||n2==0){
            return;
        }
        if(n1>=n2){
            n1=n1-n2;
        }else{
            n2=n2-n1;
        }
        opr++;
        helper(n1,n2);
    }
}
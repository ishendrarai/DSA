class Solution {
    public long sumAndMultiply(int n) {
        if(n==0){
            return 0;
        }
        long x =0;
        long sum =0;
        int count=1;
        while(n>0){
            int R=n%10;
            if(R!=0){
                x=x+R*count;
                sum+=R;
                count*=10;
            }
            n=n/10;
        }
        return x*sum;
    }
}
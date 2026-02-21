class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans=0;
        for(int i=left;i<=right;i++){
            int one = countOne(Integer.toBinaryString(i));
            if(isPrime(one)){
                ans++;
            }
        }
        return ans;
    }
    private int countOne(String binary){
        int ans =0;
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='1'){
                ans++;
            }
        }
        return ans;
    }
    public static boolean isPrime(int num) {
        if (num <= 1) {
        return false;
        
    }
    for (int i = 2; i <= Math.sqrt(num); i++) {
        if (num % i == 0) {
            return false;
        }
    }
        return true;
}
}
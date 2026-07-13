class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        
        String s = "123456789";
        
        for (int len = 2; len <= 9; len++) {
            for (int i = 0; i + len <= 9; i++) {
                int num = Integer.parseInt(s.substring(i, i + len));
                
                if (num >= low && num <= high && SD(num)) {
                    ans.add(num);
                }
            }
        }
        
        return ans;
    }
    public static boolean SD(int num){
        int lastdigit=num%10;
        num=num/10;
        while(num>0){
            int rem = num%10;
            num=num/10;
            if(lastdigit==(rem+1)){
                lastdigit=rem;
            }else{
                return false;
            }
            
        }
        return true;
    }
}
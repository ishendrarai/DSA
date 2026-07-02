class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        for(int i=0;i<jewels.length();i++){
            int count=0;
            for(int j=0;j<stones.length();j++){
                if(jewels.charAt(i)==stones.charAt(j)){
                    count++;
                }
            }
            ans+=count;
        }
        return ans;
    }
}
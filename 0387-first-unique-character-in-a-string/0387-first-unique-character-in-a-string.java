class Solution {
    public int firstUniqChar(String s) {
        int ans =-1;
        int[] hash = new int[26];
        for(int i=0;i<s.length();i++){
            hash[(int)s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            char C = s.charAt(i);
            if(hash[C-'a']==1){
                return i;
            }
        }

        return ans;
    }
}
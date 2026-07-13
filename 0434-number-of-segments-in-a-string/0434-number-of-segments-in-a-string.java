class Solution {
    public int countSegments(String s) {
        s = s.trim();
        if(s.isEmpty()){
            return 0;
        }
        String[] ans=s.split("\\s+");
        return ans.length;
    }
}
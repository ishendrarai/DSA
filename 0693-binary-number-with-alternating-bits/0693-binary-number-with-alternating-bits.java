class Solution {
    public boolean hasAlternatingBits(int n) {
        long result = (n^(n>>1));
        return ((result &(result+1))==0);
    }
}
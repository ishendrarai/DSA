class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> Snums = new HashSet<>();
        for(int a:nums){
            Snums.add(a);
        }
        int ans = original;
        while (Snums.contains(ans)) {
            ans *= 2;
        }
        return ans;
    }
}
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int sum = 0;

        // Take all k cards from the end
        for (int i = n - k; i < n; i++) {
            sum += cardPoints[i];
        }

        int ans = sum;

        int right = n - k;

        // Replace cards from the end with cards from the front
        for (int left = 0; left < k; left++) {
            sum += cardPoints[left];
            sum -= cardPoints[right];
            right++;

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
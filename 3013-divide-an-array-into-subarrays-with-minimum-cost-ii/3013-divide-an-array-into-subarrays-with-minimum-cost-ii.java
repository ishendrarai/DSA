class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        // max heap: maintain k-1 smallest elements
        PriorityQueue<Integer> pq_left =
                new PriorityQueue<>((a, b) -> b - a);

        // min heap: remaining elements
        PriorityQueue<Integer> pq_right =
                new PriorityQueue<>();

        // lazy deletion map
        Map<Integer, Integer> map = new HashMap<>();

        long sum_left = 0;
        int valid_left = 0;

        long result = Long.MAX_VALUE;

        for (int i = 1; i < n; i++) {

            // remove element leaving the window
            if (i >= dist + 2) {
                int removed = nums[i - dist - 1];

                if (!pq_left.isEmpty() && removed < pq_left.peek()) {
                    map.merge(removed, 1, Integer::sum);
                    sum_left -= removed;
                    valid_left--;
                } else if (!pq_left.isEmpty() && removed == pq_left.peek()) {
                    pq_left.poll();
                    sum_left -= removed;
                    valid_left--;
                } else if (!pq_right.isEmpty() && removed == pq_right.peek()) {
                    pq_right.poll();
                } else {
                    map.merge(removed, 1, Integer::sum);
                }
            }

            // add new element
            if (pq_left.isEmpty() || i <= k - 1 || nums[i] <= pq_left.peek()) {
                pq_left.offer(nums[i]);
                sum_left += nums[i];
                valid_left++;
            } else {
                pq_right.offer(nums[i]);
            }

            // rebalance heaps
            if (i > k - 1) {
                if (valid_left < k - 1) {
                    int v = pq_right.poll();
                    pq_left.offer(v);
                    sum_left += v;
                    valid_left++;
                } else if (valid_left > k - 1) {
                    int v = pq_left.poll();
                    sum_left -= v;
                    valid_left--;
                    pq_right.offer(v);
                }
            }

            // lazy cleanup
            while (!pq_left.isEmpty()
                    && map.getOrDefault(pq_left.peek(), 0) > 0) {
                int v = pq_left.poll();
                map.merge(v, -1, Integer::sum);
            }

            while (!pq_right.isEmpty()
                    && map.getOrDefault(pq_right.peek(), 0) > 0) {
                int v = pq_right.poll();
                map.merge(v, -1, Integer::sum);
            }

            // update answer
            if (i >= dist + 1) {
                result = Math.min(result, sum_left);
            }
        }

        return nums[0] + result;
    }
}

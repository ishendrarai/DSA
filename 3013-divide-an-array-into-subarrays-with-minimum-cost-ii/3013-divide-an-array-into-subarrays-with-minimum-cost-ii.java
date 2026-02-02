import java.util.*;

class Solution {

    static class Pair {
        long val;
        int idx;

        Pair(long v, int i) {
            val = v;
            idx = i;
        }
    }

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;

        // smallest (k-1) elements
        TreeSet<Pair> kMinimum = new TreeSet<>(
            (a, b) -> a.val == b.val ? a.idx - b.idx : Long.compare(a.val, b.val)
        );

        // remaining elements
        TreeSet<Pair> remaining = new TreeSet<>(
            (a, b) -> a.val == b.val ? a.idx - b.idx : Long.compare(a.val, b.val)
        );

        long sum = 0;

        // initial window
        int i = 1;
        while (i - dist < 1) {
            Pair p = new Pair(nums[i], i);
            kMinimum.add(p);
            sum += nums[i];

            if (kMinimum.size() > k - 1) {
                Pair temp = kMinimum.last();
                kMinimum.remove(temp);
                sum -= temp.val;
                remaining.add(temp);
            }
            i++;
        }

        long result = Long.MAX_VALUE;

        // sliding window
        while (i < n) {
            Pair add = new Pair(nums[i], i);
            kMinimum.add(add);
            sum += add.val;

            if (kMinimum.size() > k - 1) {
                Pair temp = kMinimum.last();
                kMinimum.remove(temp);
                sum -= temp.val;
                remaining.add(temp);
            }

            result = Math.min(result, sum);

            // remove element leaving window
            Pair remove = new Pair(nums[i - dist], i - dist);

            if (kMinimum.contains(remove)) {
                kMinimum.remove(remove);
                sum -= remove.val;

                if (!remaining.isEmpty()) {
                    Pair temp = remaining.first();
                    remaining.remove(temp);
                    kMinimum.add(temp);
                    sum += temp.val;
                }
            } else {
                remaining.remove(remove);
            }

            i++;
        }

        return nums[0] + result;
    }
}

// LeetCode 1011 - Capacity To Ship Packages Within D Days
// Approach: Binary Search on Answer
// Time Complexity: O(n * log(sum(weights)))
// Space Complexity: O(1)

class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int n = weights.length;

        // Minimum possible capacity = max weight
        // Maximum possible capacity = sum of all weights
        int highest = Integer.MIN_VALUE;
        int total = 0;

        for (int k = 0; k < n; k++) {
            highest = Math.max(highest, weights[k]);
            total += weights[k];
        }

        int low = highest;
        int high = total;

        int ans = Integer.MAX_VALUE;

        // Binary Search on ship capacity
        while (low <= high) {

            int mid = low + (high - low) / 2;

            int daysRequired = 1;
            int currentWeight = 0;

            // Check how many days are needed
            // with current ship capacity = mid
            for (int k = 0; k < n; k++) {

                if (currentWeight + weights[k] <= mid) {
                    currentWeight += weights[k];
                } else {
                    daysRequired++;
                    currentWeight = weights[k];
                }
            }

            // If possible within given days,
            // try smaller capacity
            if (daysRequired <= days) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}

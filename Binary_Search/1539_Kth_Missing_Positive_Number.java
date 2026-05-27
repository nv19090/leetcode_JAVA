/*
 * LeetCode 1539 - Kth Missing Positive Number
 *
 * Approach:
 * We use Binary Search to find how many positive numbers are missing
 * before a particular index.
 *
 * Missing numbers before index `mid`:
 *      arr[mid] - (mid + 1)
 *
 * If missing count is smaller than k,
 * move right side.
 * Otherwise move left side.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {

    public int findKthPositive(int[] arr, int k) {

        int n = arr.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Count missing numbers till index mid
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Final answer after binary search
        return k + right + 1;
    }
}

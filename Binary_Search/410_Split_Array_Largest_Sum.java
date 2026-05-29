/*
Problem: Split Array Largest Sum
410_Split_Array_Largest_Sum.java
Approach:
- The answer lies between:
    1. The maximum element of the array (minimum possible answer).
    2. The sum of all elements (maximum possible answer).
- Apply Binary Search on this range.
- For each candidate value (mid), determine the number of subarrays needed
  such that the sum of each subarray does not exceed mid.
- If more than k subarrays are required, mid is too small.
- Otherwise, try to minimize the answer by searching the left half.
- The first feasible value obtained is the minimum possible largest subarray sum.

Time Complexity: O(n * log(sum - maxElement))
    - Binary Search on the answer space.
    - Each iteration scans the array once.

Space Complexity: O(1)
    - Only constant extra space is used.
*/

class Solution {
    public int splitArray(int[] nums, int k) {
        int maxElement = Integer.MIN_VALUE;
        int totalSum = 0;

        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
            totalSum += num;
        }

        int low = maxElement;
        int high = totalSum;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int subarrays = 1;
            int currentSum = 0;

            for (int num : nums) {
                if (currentSum + num <= mid) {
                    currentSum += num;
                } else {
                    subarrays++;
                    currentSum = num;
                }
            }

            if (subarrays > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}

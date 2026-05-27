// LeetCode 15 - 3Sum
// Approach: Sorting + Two Pointers
// Time Complexity: O(n^2)
// Space Complexity: O(1) (excluding output space)

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int s = 0; s < n; s++) {
            if (s > 0 && nums[s] == nums[s - 1]) {
                continue;
            }
            int i = s + 1;
            int j = n - 1;
            while (i < j) {
                int sum = nums[s] + nums[i] + nums[j];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[s], nums[i], nums[j]));
                    i++;
                    j--;
                    while (i < j && nums[i] == nums[i - 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j + 1]) {
                        j--;
                    }
                }
                else if (sum > 0) {
                    j--;
                }
                else {
                    i++;
                }
            }
        }
        return ans;
    }
}

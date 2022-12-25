package io.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[] {-1, -1};

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return new int[] {map.get(nums[i]), i};

            map.put(target - nums[i], i);
        }

        return new int[] {-1, -1};
    }
}

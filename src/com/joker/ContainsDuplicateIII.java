

package com.joker;

import java.util.HashMap;
import java.util.Map;

/**
 * 220. Contains Duplicate III
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicateIII {

    public static void main(String[] args) {

        System.out.println((long) Integer.MAX_VALUE + 1);
        int[] nums = new int[]{-1, 2147483647};
        System.out.println(containsNearbyAlmostDuplicate(nums, 1, 2147483647));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < (Math.min(i + 1 + k, nums.length)); j++) {
                if (Math.abs((long) nums[i] - nums[j]) <= t)
                    return true;
            }
        }
        return false;
    }


    /**
     * 脑容量不够啊！！！
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicateBetter(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}

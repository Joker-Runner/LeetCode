package com.joker;

import java.util.*;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> integers = new ArrayList<>();
        boolean[] nums3 = new boolean[nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && !nums3[j]) {
                    integers.add(nums2[j]);
                    nums3[j] = true;
                    break;
                }
            }
        }

        int[] numre = new int[integers.size()];
        for (int i = 0; i < numre.length; i++) {
            numre[i] = integers.get(i);
        }

        return numre;
    }
}

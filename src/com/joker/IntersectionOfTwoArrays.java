package com.joker;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> integers = new ArrayList<>();
        if (nums1.length <= nums2.length) {
            integers = intersectionFunc(nums1, nums2);
        } else {
            integers = intersectionFunc(nums2, nums1);
        }

        int[] numre = new int[integers.size()];
        for (int i = 0; i < numre.length; i++) {
            numre[i] = integers.get(i);
        }

        return numre;
    }

    private List<Integer> intersectionFunc(int[] nums1, int[] nums2) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!integers.contains(nums1[i])) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        integers.add(nums1[i]);
                        break;
                    }
                }
            }
        }
        return integers;
    }
}

package com.joker;

import java.util.*;

/**
 * 373. Find K Pairs with Smallest Sums
 */
public class FindKPairsWithSmallestSums {

    public static void main(String[] args) {

        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<int[]> result = new LinkedList<int[]>();
//        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        PriorityQueue<Triple> queue = new PriorityQueue<Triple>(nums1.length, new Comparator<Triple>() {
            public int compare(Triple a, Triple b) {
                return Integer.compare(a.val, b.val);
            }
        });

// add the first column
        for (int i = 0; i < nums1.length; i++) {
            queue.add(new Triple(nums1[i] + nums2[0], i, 0));
        }

        while (k-- > 0 && !queue.isEmpty()) {
            Triple current = queue.poll();
            result.add(new int[]{nums1[current.one], nums2[current.two]});
// if the current one has a right candidate, add it to the queue.
            if (current.two + 1 < nums2.length)
                queue.add(new Triple(nums1[current.one] + nums2[current.two + 1], current.one, current.two + 1));
        }

//        return result;
    }


    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(nums1[i]);
                tempList.add(nums2[j]);
                list.add(tempList);
            }
        }

        Collections.sort(list, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int s1 = o1.get(0) + o1.get(1);
                int s2 = o2.get(0) + o2.get(1);
                if (s1 > s2)
                    return 1;
                else if (s1 == s2)
                    return 0;
                else
                    return -1;
            }
        });

        return list.size() < k ? list : list.subList(0, k);
    }


    public List<List<Integer>> kSmallestPairsT(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Tuple<Integer, Integer>> tuples = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                tuples.add(new Tuple<>(nums1[i], nums2[j]));
            }
        }
        Collections.sort(tuples, Comparator.comparingInt(o -> (o.k + o.v)));
        if (k >= tuples.size()) {
            tuples.forEach(tuple -> {
                result.add(new ArrayList<>(Arrays.asList(tuple.k, tuple.v)));
            });
        } else {
            for (int i = 0; i < k; i++) {
                result.add(new ArrayList<>(Arrays.asList(tuples.get(i).k, tuples.get(i).v)));
            }
        }
        return result;
    }

    class Tuple<K, V> {
        final K k;
        final V v;

        public Tuple(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    static class Triple {
        int val;
        int one;
        int two;

        Triple(int val, int one, int two) {
            this.val = val;
            this.one = one;
            this.two = two;
        }
    }

}

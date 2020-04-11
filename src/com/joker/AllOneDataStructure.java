package com.joker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 432
 */
public class AllOneDataStructure {
}

class AllOne {
    HashMap<String, Integer> map = new HashMap<>();
//    HashMap<Integer, HashSet<String>> sortMap = new HashMap<Integer, HashSet<String>>();

    HashMap<Integer, ListNode> nodeMap = new HashMap<>(); //存放大小关系，和keySet

    /**
     * Initialize your data structure here.
     */
    public AllOne() {

    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            nodeMap.get(value).removeKey(key);

//            addKeyValue(value + 1, key);
            map.put(key, map.get(key) + 1); //value+1
        } else {
            if(nodeMap.containsKey(1)){
                nodeMap.get(1).addKey(key);
            }else {

            }

//            addKeyValue(1, key);

            map.put(key, 1);

        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (!map.containsKey(key))
            return;
        int value = map.get(key);
        if (value > 1)
            map.put(key, value - 1);
        else if (value == 1)
            map.remove(key);
    }

    /**
     * Returns one of the keys with maximal value.
     */
//    public String getMaxKey() {
//        sortMap.size()
//    }

    /**
     * Returns one of the keys with Minimal value.
     */
//    public String getMinKey() {
//
//    }


//    private void addKeyValue(int value, String key) {
//        if (sortMap.containsKey(value)) {
//            sortMap.get(value).add(key);
//        } else {
//            HashSet<String> set = new HashSet<String>();
//            set.add(key);
//            sortMap.put(value, set);
//        }
//    }


    class ListNode{
        int value;
        HashSet<String> keySet;
        ListNode next;
        ListNode previous;

        public ListNode(int value) {
            this.value = value;
            keySet = new HashSet<>();
        }

        public void addKey(String key){
            keySet.add(key);
        }

        public boolean removeKey(String key){
            return keySet.remove(key);
        }

        public String removeKey(){
            String key = keySet.iterator().next();
            keySet.remove(key);
            return key;
        }

    }

}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */

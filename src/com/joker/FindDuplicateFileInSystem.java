package com.joker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {

    public static void main(String[] args) {
//        String str = "he(abc)";
//        int index = str.indexOf('(');
//        int lastIndex = str.indexOf(')');
//        System.out.println(str.substring(0, index));
//        System.out.println(str.substring(index + 1, lastIndex));
    }

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] pathArr = path.split(" ");
            if (pathArr.length > 1) {
                for (int i = 1; i < pathArr.length; i++) {
                    int index = pathArr[i].indexOf('(');
                    int lastIndex = pathArr[i].indexOf(')');
                    addPath(map, pathArr[i].substring(index + 1, lastIndex),
                            pathArr[0] + "/" + pathArr[i].substring(0, index));
                }
            }
        }
        List<List<String>> list = new ArrayList<>();

        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                list.add(map.get(key));
            }
        }

        return list;
    }

    private static void addPath(Map<String, List<String>> map, String key, String path) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<String>());
        }
        map.get(key).add(path);
    }
}

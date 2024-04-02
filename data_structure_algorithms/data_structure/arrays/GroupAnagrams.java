package com.vikas.core.leetcode.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    Map<String, List<String>> map = new HashMap<>();

    public static void main(String[] args){
        GroupAnagrams g = new GroupAnagrams();
        System.out.println(g.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        map= Arrays.stream(strs).collect(Collectors.groupingBy(str ->{
            char[] arr= str.toCharArray();
            Arrays.sort(arr);
            String sortedVal = String.valueOf(arr);
            System.out.println(sortedVal);
            return sortedVal;
        }));
        List<List<String>> lists = new ArrayList<>(map.values());
        return lists;
    }
}

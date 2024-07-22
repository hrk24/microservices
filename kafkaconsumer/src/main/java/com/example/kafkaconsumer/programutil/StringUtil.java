package com.example.kafkaconsumer.programutil;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringUtil {
    public static void main(String[] args){
        //int[] arr = {4,2,12,122,2,1,2,3,4,5};
        int[] arr = {1,2,3};
        //bubblesort(arr);
        //countCharOccurance("Javasetslkngsdkntorngsldkndddse");
        String checkReverse = revereStringUsingRecursion("hello");
        groupAnagram();
        //System.out.println(checkAnagram("eat","tea"));
    }

    static void bubblesort(int[] arr){
        int n = arr.length;
        int temp=0;
        for(int i=0;i<n;i++){
            for(int j=1;j<n-i;j++){
                if(arr[j-1]<arr[j]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }

    static void countCharOccurance(String str){
        List<String> inpList = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            inpList.add(String.valueOf(str.charAt(i)));
        }
        Map<String,Long> freqMap = inpList.stream().collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
        freqMap.entrySet().stream().forEach(e->{System.out.println("Key: " +e.getKey()+"  "+"Count: " +e.getValue());
        });
    }

    static String revereStringUsingRecursion(String str) {
        if(str ==null || str.length()<=0)
            return str;
        return revereStringUsingRecursion(str.substring(1)) + str.charAt(0);
    }

    static boolean checkAnagram(String s1, String s2){
        char[] s1Arr = s1.toLowerCase().toCharArray();
        char[] s2Arr = s2.toLowerCase().toCharArray();
        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        if(Arrays.equals(s1Arr,s2Arr)){
            return true;
        }
        return false;
    }

    static void groupAnagram(){
        String[] strList = {"eat","tea","def","fed","bbb"};
        Map<String,List<String>> outMap = new HashMap<>();

        List<String>  eatList = new ArrayList<>();
        for(String strs: strList) {
            for (String str : strList) {
                if(!strs.equals(str)) {
                    if (checkAnagram(strs, str)) {
                        eatList.add(str);
                    }
                    outMap.put(strs,eatList);
                }
            }
            //eatList.clear();
        }
        for(Map.Entry<String,List<String>> ob : outMap.entrySet()){
            System.out.println("Key : " +ob.getKey());
            ob.getValue().stream().forEach(System.out::println);
        }
    }
}

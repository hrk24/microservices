package com.example.kafkaconsumer;

import java.util.Arrays;

public class worldline {
    public static void main(String[] args){
        String str = "SRI";
        //String str1 = printStringRecurse(str);
        //printStr(str);
        testPrint(str);
    }

    static String printStringRecurse(String str){
        //System.out.println(str);
        if(str == null || str.length() <=0) {
            return str;
        }
        return printStringRecurse(str.substring(1)) + str.charAt(0);
    }

    static void printStr(String str) {
        for(int i=0;i<str.length();i++)
            System.out.println(str.charAt(i));
    }

    static void testPrint(String str){
        if(str == null || str.length() <=0)
            return;
        System.out.println(str.charAt(0));
        testPrint(str.substring(1));
    }

    private static int[] arrayShiftZeroToEnd() {
        int[] arr = {1,8,9,0,0,2,0};
        int j=0,i;
        for(i=0;i<arr.length;i++){
            if(arr[i]!= 0 && arr[j]==0){
                arr = swap(arr,i,j);
            }
            if(arr[j]!=0) {
                j += 1;
            }
            Arrays.stream(arr).forEach(System.out::print);
            System.out.println("---------------");
        }
        return arr;
    }

    static int[] swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j] = temp;
        return arr;
    }
}

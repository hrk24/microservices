package com.example.kafkaconsumer;

import com.example.kafkaconsumer.programutil.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SampleTest {
    public static void main(String[] args){
        List<Employee> empList = new ArrayList<>();
        getEmpList(empList);
        groupByExamples(empList);
        bubbleSort();
        System.out.println(reverseStringWithRecursion("Hemanth"));
        swapZeroToEndOfArray();
    }

    static void groupByExamples(List<Employee> empList){
        //Find City with most employee
        empList.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);
        //Find Employee with second highest salary
        empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .distinct().skip(0).findFirst().ifPresent(System.out::println);
    }

    static void bubbleSort(){
        int[] arr = {3,4,5,1,2,33,44,5,23,44,33,77,56};
        int n = arr.length;
        int temp;
        for(int i=0;i<n;i++){
            for(int j=1;j<n-i;j++){
                if(arr[j-1] < arr[j]){
                    temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        //printing the sorted array
        Arrays.stream(arr).forEach(value -> {System.out.print(value + ",");
        });
        System.out.println("-----------------------------");
    }

    static String reverseStringWithRecursion(String str){
        if(str ==null || str.length() <=0){
            return str;
        }
        return reverseStringWithRecursion(str.substring(1)) + str.charAt(0);
    }

    static void swapZeroToEndOfArray(){
        int[] arr = {1,8,5,0,9,0,2,0};
        int j=0,i;
        for(i=0;i<arr.length;i++){
            if(arr[i]!=0 && arr[j]==0){
              arr= swap(arr,i,j);
            }
            if(arr[j]!=0)
                j+=1;
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    static int[] swap(int[] arr, int i ,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }

    private static void getEmpList(List<Employee> empList) {
        empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013));
        empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandrum", 2015));
        empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010));
    }
}

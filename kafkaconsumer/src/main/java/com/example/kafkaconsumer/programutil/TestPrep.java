package com.example.kafkaconsumer.programutil;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestPrep {
    public static void main(String[] args){
        List<Employee> empList = new ArrayList<>();
        getEmpList(empList);
        //groupByExamples(empList);
        //sortingExamples(empList);
        String revString = reverseStringUsingRecursion("tteessaa");
        //System.out.println(revString);
        //System.out.println(checkIfStringAnagram("abc","bbb"));
        //bubblesort();
        countStringMaxChar("xyzaaabbbccccccffffffffgggggggggggswwweeeee");
    }

    static void groupByExamples(List<Employee> employeeList){
        //groupByAFiled - Here using City
        Map<String,List<Employee>> outMap = new HashMap();
        Map<String,Long> groupByOutMap = new HashMap();
        groupByOutMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getCity,
                Collectors.counting()));
        //find city with the highest employees
        groupByOutMap.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(
                System.out::println);
        //find employee with highest salary
        employeeList.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(
                e->{System.out.println("Highest Salaried Employee :: " +e.getName());});
        //get male female average age
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,
                Collectors.averagingDouble(Employee::getAge))).entrySet().stream()
                .forEach(e->{System.out.println("Gender :  " +e.getKey() +"  "+"Average Age: " +e.getValue());});
    }

    static void sortingExamples(List<Employee> employeeList){
        //Basic Sort Using a Field
        employeeList.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        //Basic Sort Using Two Levels of Fields
        employeeList.stream().sorted(Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getSalary)).forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        //Sort in Reverse Order
        employeeList.stream().sorted(Comparator.comparing(Employee::getName,Comparator.reverseOrder())
                .thenComparing(Employee::getSalary,Comparator.reverseOrder())).forEach(System.out::println);
    }

    static String reverseStringUsingRecursion(String str){
        if(str ==null || str.length() <=1)
            return str;
        return reverseStringUsingRecursion(str.substring(1)) + str.charAt(0);
    }

    static boolean checkIfStringAnagram(String str1, String str2){
        boolean status = false;
        char[] s1 = str1.trim().toLowerCase().toCharArray();
        char[] s2 = str1.trim().toLowerCase().toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        if(Arrays.equals(s1,s2))
            return true;

        return status;
    }

    static void bubblesort(){
        int[] arr = {3,2,3,4,5,6,12,33,4,5,67,8,55,77};
        int temp = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=1;j<n-i;j++){
                if(arr[j-1] > arr[j]){
                    temp = arr[j];
                    arr[j-1] = arr[j];
                    arr[j]=temp;
                }
            }
        }

        for(int i=0;i<n;i++)
         System.out.print(arr[i] + ",");
    }

    static void countStringMaxChar(String str){
        char[] chars = str.toCharArray();

        List<Character> inpList = new ArrayList<>();
        for(int i=0;i< chars.length;i++)
            inpList.add(chars[i]);

        Map<Character,Long> outMap = inpList.stream().collect(Collectors.groupingBy(
                Function.identity(),Collectors.counting()));
        outMap.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);

        outMap.entrySet().stream().filter(e->e.getValue() >=2).forEach(System.out::println);
        outMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
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

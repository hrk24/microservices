package com.example.kafkaconsumer.programutil;

import java.util.*;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args){
        List<Employee> empList = new ArrayList<>();
        getEmpList(empList);
        //groupEmpByCity(empList);
        //getMaleFemaleCount(empList);
        //getAvgAgeMaleFemale(empList);
        //findDepartmentWithHighestEmployees(empList);
        //sortEmployeeUsingComparator(empList);
        getNthLowestElement();
    }

    static void groupEmpByCity(List<Employee> empList){
        Map<String,List<Employee>> outMap = new HashMap();
        //outMap = empList.stream().collect(Collectors.groupingBy(e->e.getCity()));
        outMap = empList.stream().collect(Collectors.groupingBy(Employee::getCity));

        for(Map.Entry e: outMap.entrySet()){
            System.out.println("City: " +e.getKey() +"  EmpList:: " +e.getValue());
        }
    }

    static void getMaleFemaleCount(List<Employee> empList){
        Map<String,List<Employee>> outMap = new HashMap();
        outMap = empList.stream().collect(Collectors.groupingBy(Employee::getGender));
        for(Map.Entry<String,List<Employee>> e: outMap.entrySet()){
            System.out.println("Gender: " +e.getKey() +"  EmpList:: " +e.getValue());
            System.out.println("Gender: " +e.getKey() +"  Count :: " +e.getValue().size());
        }
    }

    static void getAvgAgeMaleFemale(List<Employee> empList) {
        Map<String,Double> outMap = new HashMap();
        outMap = empList.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                Collectors.averagingDouble(Employee::getAge)));

        outMap.entrySet().stream().forEach(e -> {
                System.out.println("Gender: " +e.getKey() +"  AvgAge:: " +e.getValue());
        });
    }

    static void findDepartmentWithHighestEmployees(List<Employee> empList){
        empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
                Collectors.counting()
        )).entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent( e-> {
            System.out.println("Max Dept :: " + e.getKey());});
    }

    static void sortEmployeeUsingComparator(List<Employee> empList){
        Comparator<Employee> nameComparator = (e1,e2) -> e1.getName().compareTo(e2.getName());
        //Collections.sort(empList,nameComparator);
        //empList.stream().sorted(nameComparator);
        empList.stream().sorted(Comparator.comparing(Employee::getAge,Comparator.reverseOrder()).thenComparing(Employee::getName))
                .forEach(System.out::println);

    }

    static void getNthLowestElement(){
        List<Integer> intList = Arrays.asList(12,12,33,33,11,11,123,33,44,2,3,4,5,5,12,23,45);
        //Collections.sort(intList);
        //System.out.println(intList.get(1));
        System.out.println("Second Lowest: " +intList.stream().distinct().sorted(Collections.reverseOrder()).
                collect(Collectors.toList()).get(1));

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

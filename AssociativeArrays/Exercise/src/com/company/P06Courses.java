package com.company;

import java.util.*;

public class P06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> courses = new HashMap<>();

        while (!input.equals("end")){
            String courseName = input.split(" ")[0];
            String personName = input.split(" ")[1];

            if (!courses.containsKey(courseName)){
                courses.put(courseName, new ArrayList<>());
            }

            courses.get(courseName).add(personName);
        }

        courses.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + " " + entry.getValue().size());
                    List<String> studentNames = entry.getValue();
                    studentNames.stream().sorted()
                            .forEach(studentName -> System.out.println("-- " + studentName));
                });

    }
}

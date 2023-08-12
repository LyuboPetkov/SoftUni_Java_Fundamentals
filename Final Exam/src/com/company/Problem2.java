package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "(?<name>[A-Z][a-z]+ [A-Z][a-z]+)#+(?<position>[A-Z][a-z]+)(?<position2>&?([A-Z][a-z]+)?)(?<position3>&?([A-Z]?[a-z]+)?)[0-9]{2}(?<company>\\w+ (Ltd.|JSC))";
        Pattern pattern = Pattern.compile(regex);
        int numberOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfLines; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()){
                String employeeName = matcher.group("name");
                String position1 = matcher.group("position");
                String position2 = matcher.group("position2");
                String position3 = matcher.group("position3");
                String position[] = {position1, position2, position3};
                String toPrint = String.join(" ", position);
                //String pos = String.join(" ", position);
                String company = matcher.group("company");

                System.out.printf("%s is %s at %s%n", employeeName, toPrint, company);
            }
        }
    }
}

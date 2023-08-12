package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double flourPackagePrice = Double.parseDouble(scanner.nextLine());
        double singleEggPrice = Double.parseDouble(scanner.nextLine());
        double singleApronPrice = Double.parseDouble(scanner.nextLine());
        double apronPrice = singleApronPrice*Math.ceil(students*1.2);
        double eggPrice = singleEggPrice*10*students;
        int freePackage = students/5;
        double flourPrice = flourPackagePrice*(students - freePackage);
        double totalPrice = apronPrice + eggPrice + flourPrice;
        if((budget - totalPrice) >= 0){
            System.out.printf("Items purchased for %.2f$.", totalPrice);
        }
        else{
            System.out.printf("%.2f$ more needed.", totalPrice-budget);
        }
    }
}

package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> items = Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while(!command.equals("Finish")){
            String[] commandType = command.split(" ");
            if (commandType[0].equals("Add")){
                items.add(Integer.parseInt(commandType[1]));
            }
            else if(commandType[0].equals("Remove")){
                items.remove(Integer.valueOf(Integer.parseInt(commandType[1])));
            }
            else if (commandType[0].equals("Replace")){
                for (int i = 0; i < items.size(); i++) {
                    int value = Integer.parseInt(commandType[1]);
                    int replacement = Integer.parseInt(commandType[2]);
                    if(items.get(i) == value) {
                        items.set(i, replacement);
                        break;
                    }
                }
            }
            else if (commandType[0].equals("Collapse")){
                int value = Integer.parseInt(commandType[1]);
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i) < value) {
                        items.remove(i);
                        i--;
                    }
                    }
                }
            command = scanner.nextLine();
        }

        for (int number:items){
            System.out.printf("%d ", number);
        }
    }
}

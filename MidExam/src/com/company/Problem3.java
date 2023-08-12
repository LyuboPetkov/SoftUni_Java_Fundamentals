package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> messages = new ArrayList<>();
        String command = scanner.nextLine();
        while(!command.equals("end")){
            String[] action = command.split(" ");
            if (action[0].equals("Chat")) messages.add(action[1]);
            else if (action[0].equals("Delete")) messages.remove(action[1]);
            else if (action[0].equals("Edit")) {
                for (int i = 0; i < messages.size(); i++) {
                    String message = action[1];
                    String replacement = action[2];
                    if (messages.get(i).equals(message)) {
                        messages.set(i, replacement);
                        break;
                    }
                }
            }
            else if (action[0].equals("Pin")){
                for (int i = 0; i < messages.size(); i++) {
                    String message = action[1];
                    if (messages.get(i).equals(message)){
                        messages.remove(i);
                        messages.add(message);
                    }
                }
            }
            else if (action[0].equals("Spam")){
                for (int i = 1; i < action.length; i++) {
                    messages.add(action[i]);
                }
            }
            command = scanner.nextLine();
        }

        for (String message:messages){
            System.out.println(message);
        }
    }
}

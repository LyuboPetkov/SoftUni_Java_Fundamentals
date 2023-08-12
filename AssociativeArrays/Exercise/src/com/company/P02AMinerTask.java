package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resource = scanner.nextLine();
        Map<String, Integer> resourcesQuantity = new LinkedHashMap<>();


        while(!resource.equals("stop")){
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!resourcesQuantity.containsKey(resource)){
                resourcesQuantity.put(resource, quantity);
            }
            else {
                int value = resourcesQuantity.get(resource);
                value += quantity;
                resourcesQuantity.put(resource, value);
            }

            resource = scanner.nextLine();
        }

        for (var entry: resourcesQuantity.entrySet()){
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}

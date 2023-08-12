package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	String text = scanner.nextLine();
	Map<Character, Integer> lettersCount = new LinkedHashMap<>();
        for (int index = 0; index < text.length(); index++) {
            char currentSymbol = text.charAt(index);
            if (currentSymbol == ' '){
                continue;
            }

            if (!lettersCount.containsKey(currentSymbol)){
                lettersCount.put(currentSymbol, 1);
            } else {
                int occurrence = lettersCount.get(currentSymbol);
                lettersCount.put(currentSymbol, occurrence + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : lettersCount.entrySet()){
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}

package com.company;

import java.util.*;

public class P02WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfWords = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> synonymDictionary = new LinkedHashMap<>();

        for (int i = 0; i < countOfWords; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
            if(!synonymDictionary.containsKey(word)){
                List<String> currentWordSynonyms = new ArrayList<>();
                currentWordSynonyms.add(synonym);
                synonymDictionary.put(word,currentWordSynonyms);
            } else {
                List<String> currentWordSynonyms = synonymDictionary.get(word);
                currentWordSynonyms.add(synonym);
                synonymDictionary.put(word, currentWordSynonyms);
            }



        }

        for (Map.Entry<String, List<String>> wordEntry : synonymDictionary.entrySet()){
            String currentWord = wordEntry.getKey();
            List<String> synonymsForCurrentWord = wordEntry.getValue();


            System.out.printf("%s - %s%n", currentWord, String.join(", ", synonymsForCurrentWord));
        }
    }
}

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String password = scanner.nextLine();

	String command = scanner.nextLine();
	while (!command.equals("Complete")){




	    command = scanner.nextLine();
    }

    }

    private static String makeUpper(String password, String index){
        int indextoInt = Integer.parseInt(index);
        char[] passwordChar = password.toCharArray();
        for (int i = 0; i < passwordChar.length; i++) {
            if (i == indextoInt) passwordChar[i] = (char)((int)(passwordChar[i]) - 32);
            break;
        }
        password = String.valueOf(passwordChar);

        return password;
        }


    private static String makeLower(String password, String index){
        int indextoInt = Integer.parseInt(index);
        char[] passwordChar = password.toCharArray();
        for (int i = 0; i < passwordChar.length; i++) {
            if (i == indextoInt) passwordChar[i] = (char)((int)(passwordChar[i]) + 32);
            break;
        }
        password = String.valueOf(passwordChar);

        return password;
    }

    }






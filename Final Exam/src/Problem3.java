import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Integer> goods = new TreeMap<>();
        int sold = 0;
        boolean isValidQuantity = true;
        boolean isValidToSell = true;
        while(!command.equals("Complete")){
            String[] commandType = command.split("\\s+");
            if (commandType[0].equals("Receive")){
                String food = commandType[2];
                int quantity = Integer.parseInt(commandType[1]);
                if (quantity <= 0){
                    isValidQuantity = false;
                    command = scanner.nextLine();
                    continue;

                }
                if (!goods.containsKey(food) && isValidQuantity){
                    goods.put(food, quantity);
                }
                else if (goods.containsKey(food) && isValidQuantity){
                    int currentQuantity = goods.get(food);
                    goods.put(food, quantity + currentQuantity);
                }
            }

            if (commandType[0].equals("Sell")){
                String food = commandType[2];
                int quantity = Integer.parseInt(commandType[1]);
                if(!goods.containsKey(food)){
                    System.out.printf("You do not have any %s.%n", food);
                    isValidToSell = false;
                    command = scanner.nextLine();
                    continue;
                }

                if (quantity > goods.get(food) && isValidToSell){
                    int currentQuantity = goods.get(food);
                    goods.remove(food);
                    sold += currentQuantity;
                    System.out.printf("There aren't enough %s. You sold the last %d %s.%n", food, currentQuantity, food);

                }

                else if (goods.get(food) >= quantity && isValidToSell){
                    int currentQuantity = goods.get(food);
                    goods.put(food, currentQuantity - quantity);
                    sold += quantity;
                    System.out.printf("You sold %d %s.%n", quantity, food);

                    if (goods.get(food) == 0) goods.remove(food);
                }
            }


            command = scanner.nextLine();
        }

        for (var entry : goods.entrySet()){
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

        System.out.printf("All sold: %d goods", sold);
    }
}

package command;

import database.Insert;
import database.Select;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Create_bouquet implements CommandInterface{
    @Override
    public CommandResult<String> execute() throws Exception {
        Scanner scanner = new Scanner(System.in);
        Select select = new Select();
        select.SelectFlowers();
        System.out.println("Choose your flowers for buying:");
        int flower = scanner.nextInt();
        System.out.println("Choose count:");
        int count = scanner.nextInt();
        String filePath = "C:/Users/oplys/id.txt";
        int id = readIDFromFile(filePath);
        int price = select.FlowerPrice(flower);
        select.SelectAccessoirs();
        System.out.println("Choose your accessory for buying:");
        int accessoir = scanner.nextInt();
        int price2 = select.AccesPrice(accessoir);
        Insert insert = new Insert();
        insert.insertMadedBouquets(id,flower,accessoir,price * count + price2 + 20);
        int sum = price * count + price2 + 20;
        System.out.println("Price:" + sum);
        System.out.println("Thank you for buying!");
        CommandResult<String> result = new CommandResult<String>("Making a bouquet was successful","Without errors",true);
        return result;
    }
    private static int readIDFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            return parseIDFromLine(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static int parseIDFromLine(String line) {
        if (line != null && line.startsWith("ID: ")) {
            try {
                return Integer.parseInt(line.substring("ID: ".length()));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
}

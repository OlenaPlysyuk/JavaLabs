package command;

import database.Insert;
import database.Select;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Choose_flowers implements CommandInterface{
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
        Insert insert = new Insert();
        int price = select.FlowerPrice(flower);
        insert.insertUserFlowers(id,flower,count,price*count);
        System.out.println("Thank you for buying!");
        CommandResult<String> result = new CommandResult<String>("Choosing flowers was successful","Without errors",true);
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

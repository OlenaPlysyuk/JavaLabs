package menu;

import command.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Action_menu {
    public void menu(int id) throws Exception
    {
        String filePath = "C:/Users/oplys/id.txt";
        writeIDToFile(filePath, id);
        CommandResult<String> result;
        ArrayList<CommandInterface> commandList = new ArrayList<>();
        commandList.add(new Create_bouquet());
        commandList.add(new Choose_bouquet());
        commandList.add(new Choose_flowers());
        System.out.println("Choose action:1 - make a bouquet;2 - choose a bouquet;3 - choose flowers;4 - back to choosing purchase way");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while(choice > 0 && choice < 5)
        {
            if(choice == 4)
            {
                System.out.println("We`re going");
                break;
            }
            else
            {
                result = commandList.get(choice-1).execute();
                System.out.println(result);
                createOutputFile(result);
            }
            System.out.println("Choose action:1 - make a bouquet;2 - choose a bouquet;3 - choose flowers;4 - back to choosing purchase way");
            choice = scanner.nextInt();
        }
    }
    private static void writeIDToFile(String filePath, int id) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID: " + id);
            System.out.println("ID записано у файл: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createOutputFile(CommandResult<String> result) {
        // Створюємо файл для запису даних
        String fileName = "C:/Users/oplys/output.txt";
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            // Записуємо значення полів у файл
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String formattedDate = dateFormat.format(new Date());
            fileWriter.write("Date: " + formattedDate + "\n");
            fileWriter.write(result.getResult() + "\n");
            fileWriter.write(result.getMessage() + "\n");
            fileWriter.write( result.isSucceed() + "\n");

            System.out.println("Data appended to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

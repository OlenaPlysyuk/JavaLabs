package menu;

import command.*;
import command.CommandInterface;
import command.CommandResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User_menu {
    public void menu() throws Exception
    {
        CommandResult<String> result;
        ArrayList<CommandInterface> commandList = new ArrayList<>();
        commandList.add(new Registration());
        commandList.add(new Logging_in());
        System.out.println("Choose:1 - registration;2 - log in;3 - exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while(choice > 0 && choice < 4)
        {
            if(choice == 3)
            {
                System.out.println("Have a nice day");
                break;
            }
            else
            {
                result = commandList.get(choice-1).execute();
                System.out.println(result);
                createOutputFile(result);
                if(result.isSucceed())
                {
                    Purchase_way purchase_way = new Purchase_way();
                    purchase_way.menu();
                }
            }
            System.out.println("Choose:1 - registration;2 - log in;3 - exit");
            choice = scanner.nextInt();
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

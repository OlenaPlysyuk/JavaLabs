package menu;

import command.CommandInterface;
import command.CommandResult;
import command.Delivery;
import command.Self_pickup;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Purchase_way {
    public void menu() throws Exception
    {
        CommandResult<String> result;
        ArrayList<CommandInterface> commandList = new ArrayList<>();
        commandList.add(new Delivery());
        commandList.add(new Self_pickup());
        System.out.println("Choose purchase way:1 - delivery;2 - self pickup;3 - back to registration and log in");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while(choice > 0 && choice < 4)
        {
            if(choice == 3)
            {
                System.out.println("We`re going");
                break;
            }
            else
            {
                result = commandList.get(choice-1).execute();
                System.out.println(result);
                int id = getIDFromDetails(result.getMessage());
                createOutputFile(result);
                if(result.isSucceed())
                {
                    Action_menu action_menu = new Action_menu();
                    action_menu.menu(id);
                }
            }
            System.out.println("Choose purchase way:1 - delivery;2 - self pickup;3 - back to registration and log in");
            choice = scanner.nextInt();
        }
    }
    public int getIDFromDetails(String details) {
        if (details != null && details.startsWith("Without errors;ID=")) {
            try {
                String idString = details.substring("Without errors;ID=".length());
                return Integer.parseInt(idString);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return -1;
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

package command;

import database.Insert;
import database.Select;

import java.util.Scanner;

public class Delivery implements CommandInterface{
    @Override
    public CommandResult<String> execute() throws Exception {
        Select select = new Select();
        CommandResult<String> result;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        if(select.existUserData(email))
        {
            int id = select.existUserData2(email);
            System.out.println("You have delivery info , so good waiting");
            result = new CommandResult<String>("Choosing delivery was successful","Without errors;ID=" + id,true);
        }
        else
        {
            System.out.println("Enter phoneNumber");
            String phone = scanner.nextLine();
            System.out.println("Enter address:");
            String address = scanner.nextLine();
            System.out.println("Enter type of payment:");
            String pay = scanner.nextLine();
            int id = select.FindUser(email);
            if(id > 0)
            {
                Insert insert = new Insert();
                insert.insertUserData(id,phone,address,pay);
                result = new CommandResult<String>("Choosing delivery was successful","Without errors;ID=" + id,true);
            }
            else
            {
                result = new CommandResult<String>("Choosing delivery was unsuccessful","With errors",false);
            }
        }
        return result;
    }
}

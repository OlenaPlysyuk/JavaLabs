package command;

import database.Select;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.*;
import java.security.spec.KeySpec;
import java.util.Scanner;



public class Registration implements CommandInterface {
    @Override
    public CommandResult<String> execute() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        Select select = new Select();
        CommandResult<String> result;
        if(select.existUsers(name,email,password))
        {
            result = new CommandResult<String>("Registration was successful","Without errors",true);
        }
        else
        {
            result = new CommandResult<String>("Registration was unsuccessful","With errors",false);
        }
        return result;
    }

}

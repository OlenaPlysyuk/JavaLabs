package command;

import database.Select;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.KeySpec;
import java.util.Scanner;


public class Logging_in implements CommandInterface{
    @Override
    public CommandResult<String> execute() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        Select select = new Select();
        CommandResult<String> result;
        if(select.isUser(name,password))
        {
            result = new CommandResult<String>("Log in was successful","Without errors",true);
        }
        else
        {
            result = new CommandResult<String>("Log in was unsuccessful","With errors",false);
        }
        return result;
    }
}

import command.SendEmail;
import data.AccessoriesData;
import data.BouquetData;
import data.FlowersData;
import database.Connect;
import menu.User_menu;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        Connect connect1 = new Connect();
        connect1.method();
        User_menu user_menu = new User_menu();
        user_menu.menu();
        SendEmail sendEmail = new SendEmail();
        sendEmail.execute();
    }
}
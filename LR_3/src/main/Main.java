package main;

import battle.Battle;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void guide()
    {
        System.out.println("Droid classes:" +
                "\n1.Marksman - trooper for long distance(health - 2/5,damage-4/5,critical chance - 3/5)" +
                "\n2.Trooper - an ordinary soldier on the battlefield(health - 3/5,damage - 3/5,critical chance - 2/5)" +
                "\n3.Engineer - indispensable fighter in team fights.Can heal his teammates(health - 4/5,damage - 2/5,critical chance - 3/5)");
    }
    public static void game() throws IOException {
        Battle battle = new Battle();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose what you want - 1vs1 or TeamVsTeam or Guide or Show battle(1 or 2 or 3 or 4):");
        int ch = scanner.nextInt();
        while (ch != 0)
        {
            if(ch == 1)
            {
                battle.duel();
            }
            if(ch == 2)
            {
                battle.team_game();
            }
            if(ch == 3)
            {
                guide();
            }
            if(ch == 4)
            {
                FileReader fileReader = new FileReader("C:\\Olena 3 Term\\PP\\fight.txt");
                Scanner scanner1 = new Scanner(fileReader);
                while (scanner1.hasNextLine())
                {
                    System.out.println(scanner1.nextLine());
                }
                fileReader.close();
            }
            System.out.println("Choose what you want - 1vs1 or TeamVsTeam or Guide or Show battle or Exit(1 or 2 or 3 or 4 or 0):");
            ch = scanner.nextInt();
        }
    }
    public static void main(String[] args) throws IOException {
        game();
    }
}
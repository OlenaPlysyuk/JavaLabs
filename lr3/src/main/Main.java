package main;

import battle.Battle;

import java.util.Scanner;

public class Main {

    public static void guide()
    {
        System.out.println("Droid classes:" +
                "\n1.Marksman - trooper for long distance(health - 2/5,damage-4/5,critical chance - 3/5)" +
                "\n2.Trooper - an ordinary soldier on the battlefield(health - 3/5,damage - 3/5,critical chance - 2/5)" +
                "\n3.Engineer - indispensable fighter in team fights.Can heal himself (health - 4/5,damage - 2/5,critical chance - 3/5)");
                  game();
    }
    public static void game()
    {
        Battle battle = new Battle();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose what you want - 1vs1 or TeamVsTeam(0 or 1 or choose 2 to see info about droids):");
        int ch = scanner.nextInt();
        if(ch == 0)
        {
            battle.duel();
        }
        if(ch == 1)
        {
            battle.team_game();
        }
        if(ch == 2)
        {
            guide();
        }
    }
    public static void main(String[] args) {
        game();
    }
}
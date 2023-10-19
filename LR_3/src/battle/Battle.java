package battle;

import droid.Droid;
import droid.Engineer;
import droid.Marksman;
import droid.Trooper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    public static Droid droid(int chose)
    {
        Droid droid = null;
        if(chose == 1)
        {
            droid = new Marksman(50,20,30,"Marksman");
        }
        if(chose == 2)
        {
            droid = new Engineer(60,10,15,"Engineer");
        }
        if(chose == 3)
        {
            droid = new Trooper(80,15,20,"Trooper");
        }
        return droid;
    }
    public static void duel() throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\Olena 3 Term\\PP\\fight.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose type of first droid(1 - Marksman,2 - Engineer,3 - Trooper)");
        int ch = scanner.nextInt();
        Droid droid1 = droid(ch);
        System.out.println("Choose type of second droid(1 - Marksman,2 - Engineer,3 - Trooper)");
        ch = scanner.nextInt();
        Droid droid2 = droid(ch);
        Random random = new Random();
        int chance;
        for(int i = 1;i < 100;i++)
        {
            System.out.println("\n------Round " + i+"------\n");
            if(i % 5 == 0)
            {
                if(droid1.getName() == "Engineer")
                {
                    droid1.setHealth(droid1.getHealth() + 30);
                }
                if(droid2.getName() == "Engineer")
                {
                    droid2.setHealth(droid2.getHealth() + 30);
                }
            }
            chance = 1 + random.nextInt(100);
            if(chance < droid1.getCr_chance())
            {
                droid2.setHealth(droid2.getHealth() - droid1.getDamage() * 2);
                System.out.println(droid1.getName() + " super attacks " + droid2.getName() + " and opponent get " + droid1.getDamage()*2 + " dmg." + droid2.getName() + " health is " + droid2.getHealth());
                fileWriter.write(droid1.getName() + " super attacks " + droid2.getName() + " and opponent get " + droid1.getDamage()*2 + " dmg." + droid2.getName() + " health is " + droid2.getHealth() + "\n");
            }
            else
            {
                droid2.setHealth(droid2.getHealth() - droid1.getDamage());
                System.out.println(droid1.getName() + " attacks " + droid2.getName() + " and opponent get " + droid1.getDamage() + " dmg." + droid2.getName() + " health is " + droid2.getHealth());
                fileWriter.write(droid1.getName() + " attacks " + droid2.getName() + " and opponent get " + droid1.getDamage() + " dmg." + droid2.getName() + " health is " + droid2.getHealth() + "\n");
            }
            chance = 1 + random.nextInt(100);
            if(chance < droid2.getCr_chance())
            {
                droid1.setHealth(droid1.getHealth() - droid2.getDamage() * 2);
                System.out.println(droid2.getName() + " super attacks " + droid1.getName() + " and opponent get " + droid2.getDamage()*2 + " dmg." + droid1.getName() + " health is " + droid1.getHealth());
                fileWriter.write(droid2.getName() + " super attacks " + droid1.getName() + " and opponent get " + droid2.getDamage()*2 + " dmg." + droid1.getName() + " health is " + droid1.getHealth() + "\n");
            }
            else
            {
                droid1.setHealth(droid1.getHealth() - droid2.getDamage());
                System.out.println(droid2.getName() + " attacks " + droid1.getName() + " and opponent get " + droid2.getDamage() + " dmg." + droid1.getName() + " health is " + droid1.getHealth());
                fileWriter.write(droid2.getName() + " attacks " + droid1.getName() + " and opponent get " + droid2.getDamage() + " dmg." + droid1.getName() + " health is " + droid1.getHealth()+ "\n");
            }
            if(droid1.getHealth() <= 0)
            {
                if(droid2.getHealth() <= 0)
                {
                    System.out.println("Draw!");
                    fileWriter.write("Draw!\n");
                    break;
                }
                else
                {
                    System.out.println("Droid 2 wins - congratulations!");
                    fileWriter.write("Droid 2 wins - congratulations!\n");
                    break;
                }
            }
            if(droid2.getHealth() <= 0)
            {
                if(droid1.getHealth() <= 0)
                {
                    System.out.println("Draw!");
                    fileWriter.write("Draw!\n");
                    break;
                }
                else
                {
                    System.out.println("Droid 1 wins - congratulations!");
                    fileWriter.write("Droid 1 wins - congratulations!\n");
                    break;
                }
            }
        }
        fileWriter.close();
    }
    public static void team_game()
    {
        Scanner scanner = new Scanner(System.in);
        Droid[] droidteam1 = new Droid[3];
        Droid[] droidteam2 = new Droid[3];
        for(int i = 0;i < 3;i++)
        {
            System.out.println("Choose type of " + (i+1) + " droid for first team(1 - Marksman,2 - Engineer,3 - Trooper)");
            int ch = scanner.nextInt();
            droidteam1[i] = droid(ch);
            System.out.println("Choose type of " + (i+1) + " droid for second team(1 - Marksman,2 - Engineer,3 - Trooper)");
            ch = scanner.nextInt();
            droidteam2[i] = droid(ch);
        }
        Random random = new Random();
        int chance;
        int alive1 = 3;
        int alive2 = 3;
        int[] team1 = new int[3];
        int[] team2 = new int[3];
        for(int i = 0;i < 3;i++)
        {
            team1[i] = 1;
            team2[i] = 1;
        }
        int choise;
        for(int i = 1;i < 100;i++)
        {
            System.out.println("\n------Round " + i+"------\n");
            for(int j = 0;j < 3;j++)
            {
                if(alive1 <= 0 || alive2 <= 0)
                {
                    break;
                }
                if(i % 5 == 0)
                {
                    if(droidteam1[j].getName() == "Engineer" && droidteam1[j].getHealth() > 0)
                    {
                        droidteam1[j].setHealth(droidteam1[j].getHealth() + 30);
                    }
                    if(droidteam2[j].getName() == "Engineer" && droidteam2[j].getHealth() > 0)
                    {
                        droidteam2[j].setHealth(droidteam2[j].getHealth() + 30);
                    }
                }
                chance = 1 + random.nextInt(100);
                if(chance < droidteam1[j].getCr_chance() && droidteam1[j].getHealth() > 0)
                {
                    choise = random.nextInt(3);
                    while(droidteam2[choise].getHealth() <= 0)
                    {
                        choise = random.nextInt(3);
                    }
                    droidteam2[choise].setHealth(droidteam2[choise].getHealth() - droidteam1[j].getDamage() * 2);
                    System.out.println(droidteam1[j].getName() + " super attacks " + droidteam2[choise].getName() + " and opponent get " + droidteam1[j].getDamage()*2 + " dmg." + droidteam2[choise].getName() + " health is " + droidteam2[choise].getHealth());
                    if(droidteam2[choise].getHealth() <= 0 && team2[choise] == 1)
                    {
                        team2[choise] = 0;
                        alive2-=1;
                    }
                }
                if(chance >= droidteam1[j].getCr_chance() && droidteam1[j].getHealth() > 0)
                {
                    choise = random.nextInt(3);
                    while(droidteam2[choise].getHealth() <= 0)
                    {
                        choise = random.nextInt(3);
                    }
                    droidteam2[choise].setHealth(droidteam2[choise].getHealth() - droidteam1[j].getDamage());
                    System.out.println(droidteam1[j].getName() + " attacks " + droidteam2[choise].getName() + " and opponent get " + droidteam1[j].getDamage() + " dmg." + droidteam2[choise].getName() + " health is " + droidteam2[choise].getHealth());
                    if(droidteam2[choise].getHealth() <= 0 && team2[choise] == 1)
                    {
                        team2[choise] = 0;
                        alive2-=1;
                    }
                }
                chance = 1 + random.nextInt(100);
                if(chance < droidteam2[j].getCr_chance() && droidteam2[j].getHealth() > 0)
                {
                    choise = random.nextInt(3);
                    while(droidteam1[choise].getHealth() <= 0)
                    {
                        choise = random.nextInt(3);
                    }
                    droidteam1[choise].setHealth(droidteam1[choise].getHealth() - droidteam2[j].getDamage() * 2);
                    System.out.println(droidteam2[j].getName() + " super attacks " + droidteam1[choise].getName() + " and opponent get " + droidteam2[j].getDamage()*2 + " dmg." + droidteam1[choise].getName() + " health is " + droidteam1[choise].getHealth());
                    if(droidteam1[choise].getHealth() <= 0 && team1[choise] == 1)
                    {
                        team1[choise] = 0;
                        alive1-=1;
                    }
                }
                if(chance >= droidteam2[j].getCr_chance() && droidteam2[j].getHealth() > 0)
                {
                    choise = random.nextInt(3);
                    while(droidteam1[choise].getHealth() <= 0)
                    {
                        choise = random.nextInt(3);
                    }
                    droidteam1[choise].setHealth(droidteam1[choise].getHealth() - droidteam2[j].getDamage());
                    System.out.println(droidteam2[j].getName() + " attacks " + droidteam1[choise].getName() + " and opponent get " + droidteam2[j].getDamage() + " dmg." + droidteam1[choise].getName() + " health is " + droidteam1[choise].getHealth());
                    if(droidteam1[choise].getHealth() <= 0 && team1[choise] == 1)
                    {
                        team1[choise] = 0;
                        alive1-=1;
                    }
                }
                if(droidteam1[j].getHealth() <= 0 && team1[j] == 1)
                {
                    team1[j] = 0;
                    alive1 -= 1;
                }
                if(droidteam2[j].getHealth() <= 0 && team2[j] == 1)
                {
                    team2[j] = 0;
                    alive2 -= 1;
                }
            }
            if(alive1 == 0)
            {
                if(alive2 == 0)
                {
                    System.out.println("Draw!");
                    break;
                }
                else
                {
                    System.out.println("Team2 wins!");
                    break;
                }
            }
            if(alive2 == 0)
            {
                if(alive1 == 0)
                {
                    System.out.println("Draw!");
                    break;
                }
                else
                {
                    System.out.println("Team1 wins!");
                    break;
                }
            }
            System.out.println("\n\nTeam 1:");
            for(int j = 0;j < 3;j++)
            {
                System.out.println(droidteam1[j].getHealth());
            }
            System.out.println("\n\nTeam 2:");
            for(int j = 0;j < 3;j++)
            {
                System.out.println(droidteam2[j].getHealth());
            }
            System.out.println("\n\n");
        }
    }
}

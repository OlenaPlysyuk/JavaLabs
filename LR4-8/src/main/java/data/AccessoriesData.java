package data;

import database.Insert;
import florist.Accessories;
import florist.Bouquet;

import java.util.ArrayList;
import java.util.Random;

public class AccessoriesData {
    public void generator()
    {
        ArrayList<Accessories> accesData = new ArrayList<>();
        String[] colours = new String[]{"Red","White","Yellow","Pink","Green","Blue","Orange","Gray","Black"};
        String[] names = new String[]{"Tape","Wrapper","Tape and wrapper"};
        Random random = new Random();
        Insert insert = new Insert();
        for(int i = 0;i < 30;i++)
        {
            String name = names[random.nextInt(3)];
            String colour = colours[random.nextInt(9)];
            int price = 1 + random.nextInt(20);
            accesData.add(new Accessories(name,price,colour));
            System.out.println((i + 1) + accesData.get(i).toString());
            insert.insertAcces(name,price,colour);
        }
    }
}

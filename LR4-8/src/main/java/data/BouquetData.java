package data;

import database.Insert;
import florist.Bouquet;
import florist.Flower;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class BouquetData {
    public void generator()
    {
        ArrayList<Bouquet> bouquetData = new ArrayList<>();
        String[] descriptions = new String[]
                {
                        "This flower has incredibly fragrant petals and is used to express tenderness and love in bouquets",
                        "This flower has large flowers and a bright color that attracts attention and symbolizes joy",
                        "This flower impresses with its grandeur and grace. It has a scent that makes the room pleasant and fresh"
                };
        String[] names = new String[]{"Perfect Bouquet","Bouquet for lonely women","Bouquet"};
        Random random = new Random();
        Insert insert = new Insert();
        for(int i = 0;i < 20;i++)
        {
            String name = names[random.nextInt(3)];
            String description = descriptions[random.nextInt(3)];
            int price = 1 + random.nextInt(300);
            int fl_id = 1 + random.nextInt(1000);
            int ac_id = 1 + random.nextInt(10);
            bouquetData.add(new Bouquet(name,price,description));
            System.out.println((i + 1) + bouquetData.get(i).toString());
            insert.insertBouquet(fl_id,ac_id,name,description,price);
        }
    }
}

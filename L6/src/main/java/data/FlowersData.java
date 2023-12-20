package data;

import database.Insert;
import florist.Flower;

import java.util.*;
import java.awt.*;
import java.util.List;

public class FlowersData {
    public void generator()
    {
        ArrayList<Flower> flowersData = new ArrayList<>();
        String[] countryNames = new String[]{"Ukraine","Netherlands","Britain","France"};
        String[] descriptions = new String[]
                {
                        "This flower has incredibly fragrant petals and is used to express tenderness and love in bouquets",
                        "This flower has large flowers and a bright color that attracts attention and symbolizes joy",
                        "This flower impresses with its grandeur and grace. It has a scent that makes the room pleasant and fresh"
                };
        String[] names = new String[]{"Rose","Tulip","Lily"};
        String[] sizes = new String[]{"Big","Average","Small"};
        String[] scents = new String[]{"Fresh","Sweet","Tender"};
        String[] colours = new String[]{"Red","White","Yellow","Pink"};
        String[] producers = new String[]{"Green Valley Flowers","Blossom Gardens","Petals & Blooms Nursery"};
        Random random = new Random();
        for(int i = 0;i < 20000;i++)
        {
            String name = names[random.nextInt(3)];
            String colour = colours[random.nextInt(4)];
            String scent = scents[random.nextInt(3)];
            String size = sizes[random.nextInt(3)];
            String description = descriptions[random.nextInt(3)];
            String producer = producers[random.nextInt(3)];
            String country = countryNames[random.nextInt(4)];
            int price = 1 + random.nextInt(4);
            flowersData.add(new Flower(name,colour,scent,size,description,producer,country,price));
            System.out.println((i + 1) + flowersData.get(i).toString());
        }
        Insert insert = new Insert();
        Map<String, Integer> groupedFlowers = groupFlowers(flowersData);
        for (Map.Entry<String, Integer> entry : groupedFlowers.entrySet()) {
            if (entry.getValue() > 1) {
                Flower flower = createFlowerFromKey(entry.getKey());
                insert.insertFlower(flower.getName(),flower.getColor(),flower.getScent(), flower.getSize(), flower.getDescription(), flower.getProducer(), flower.getCountryOfOrigin(), flower.getPrice(), entry.getValue());
                System.out.println(flower.toString() + ": " + entry.getValue() + " шт.");
            }
        }
    }
    public static Flower createFlowerFromKey(String key) {
        String[] parts = key.split(", ");
        // Перевіряємо, чи кількість частин відповідає очікуваній кількості полів
        if (parts.length != 8) {
            throw new IllegalArgumentException("Invalid key format");
        }
        // Повертаємо новий об'єкт класу Flower
        return new Flower(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], Integer.parseInt(parts[7]));
    }
    public static Map<String, Integer> groupFlowers(ArrayList<Flower> flowersData) {
        Map<String, Integer> groupedFlowers = new HashMap<>();
        for (Flower flower : flowersData) {
            // Формуємо унікальний ключ для кожного типу квіта
            String key = flower.getName() + ", " + flower.getColor() + ", " +
                    flower.getScent() + ", " + flower.getSize() + ", " +
                    flower.getDescription() + ", " + flower.getProducer() + ", " +
                    flower.getCountryOfOrigin() + ", " + flower.getPrice();
            // Додаємо квітку в відповідну групу або інкрементуємо лічильник
            groupedFlowers.put(key, groupedFlowers.getOrDefault(key, 0) + 1);
        }
        return groupedFlowers;
    }
}

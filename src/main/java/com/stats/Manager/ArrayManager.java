package com.stats.Manager;

import com.stats.Humans.Human;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrayManager {

    public static ArrayList<String> humanss = new ArrayList<String>();
    public static HashMap<String, Human> playerData= new HashMap<String, com.stats.Humans.Human>();

    public static void putJson() throws NullPointerException {
        for (int i = 0; i<FileManager.getList().toArray().length; i++) {
            String needPut = (String) FileManager.getList().toArray()[i];
            humanss.add(needPut);

            try {

                HashMap<String, Integer> hashMap = new HashMap<>();
                String gFile = FileManager.getFile().get(needPut).toString();
                gFile = gFile.replace("}", "");
                gFile = gFile.replace("{", "");

                String[] arrayS = gFile.split(",");

                for (String a : arrayS) {
                    String[] arrayK = a.split(":", 15);

                    arrayK[0] = arrayK[0].replace("\"", "");
                    arrayK[1] = arrayK[1].replace("\"", "");

                    hashMap.put((String) arrayK[0], Integer.valueOf(arrayK[1]));
                }

                Human hum = new Human(needPut, hashMap);
                playerData.put(needPut, hum);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}
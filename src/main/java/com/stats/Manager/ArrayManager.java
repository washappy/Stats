package com.stats.Manager;

import com.stats.Humans.Human;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrayManager {

    public static ArrayList<String> humanss = new ArrayList<String>();
    public static HashMap<String, Human> playerData= new HashMap<String, com.stats.Humans.Human>();

    public static void putJson(){
        for (int i = 0; i<FileManager.getList().toArray().length; i++) {
            String needPut = (String) FileManager.getList().toArray()[i];
            humanss.add(needPut);
            Human hum = new Human(needPut,FileManager.getFile(needPut));
            playerData.put(needPut,hum);
        }
    }
}
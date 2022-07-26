package com.traveler.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

class NPC {
    String name;
    String talk;

    // Creates list which carries npc objects
    public static List<Item> npc;

    // method that reads from npc.json file and loads npc with npc objects (name and talk)
    public static List<Item> fromNPCtoArray() throws IOException {
        Gson gson = new Gson();
        Type itemListType = new TypeToken<List<Item>>() {}.getType();
        npc = new Gson().fromJson(new FileReader("src/main/resources/npc.json"), itemListType);
        return npc;
    }


}
package ru.netology.javaqa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    HashMap<String, Integer> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player.getStrength());
    }

    public Integer findByName(String name) {
        for (String key : players.keySet()) {
            if (key.equals(name)) {
                Integer value = players.get(key);
                return value;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Integer player1 = findByName(playerName1);
        Integer player2 = findByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }

        if (player1 > player2) {
            return 1;
        }
        if (player2 > player1) {
            return 2;
        } else return 0;
    }
}

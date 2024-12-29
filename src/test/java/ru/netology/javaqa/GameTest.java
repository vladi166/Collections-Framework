package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Player 1", 324);
    Player player2 = new Player(2, "Player 2", 245);
    Player player3 = new Player(3, "Player 3", 155);
    Player player4 = new Player(4, "Player 4", 245);
    Player player5 = new Player(5, "Player 5", 422);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
    }

    @Test
    public void WinFirstPlayer() {
        int expected = 1;
        int actual = game.round("Player 2", "Player 3");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WinSecondPlayer() {
        int expected = 2;
        int actual = game.round("Player 1", "Player 5");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void DrawnGame() {
        int expected = 0;
        int actual = game.round("Player 2", "Player 4");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NotRegisteredPlayerThree() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player 3", "Player 6");
        });
    }
    @Test
    public void NotRegisteredSecondPlayer() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player 2", "Player 6");
        });
    }
}

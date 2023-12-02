package org.advent.day2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

public class GameShould {

    @Test
    public void should_fail_with_invalid_game_string() {
        var gameString = "Gme 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        assertThrowsExactly(RuntimeException.class, () -> Game.gameFromString(gameString));
    }

    @Test
    public void should_correctly_parse_game_number() {
        var gameString = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        var game = Game.gameFromString(gameString);
        assertThat(game.gameNumber, equalTo(1));
    }

    @Test
    public void should_correctly_parse_draw_strings() {
        var gameString = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        var game = Game.gameFromString(gameString);
        assertThat(game.draws.size(), equalTo(3));
        assertThat(game.draws.get(0), equalTo(new Draw(4, 0, 3)));
        assertThat(game.draws.get(1), equalTo(new Draw(1, 2, 6)));
        assertThat(game.draws.get(2), equalTo(new Draw(0, 2, 0)));
    }

    @Test
    public void should_correctly_detect_impossible_game() {
        var gameString = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";
        var game = Game.gameFromString(gameString);
        assertThat(game.isImpossible(), equalTo(true));
    }

    @Test
    public void should_correctly_detect_possible_game() {
        var gameString = "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green";
        var game = Game.gameFromString(gameString);
        assertThat(game.isImpossible(), equalTo(false));
    }

    @Test
    public void should_correctly_determine_minimum_possible_draw_for_game1() {
        var game = Game.gameFromString("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        assertThat(game.getMinimumPossibleDraw(), equalTo(new Draw(4, 2, 6)));
    }

    @Test
    public void should_correctly_determine_minimum_possible_draw_for_game2() {
        var game = Game.gameFromString("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue");
        assertThat(game.getMinimumPossibleDraw(), equalTo(new Draw(1, 3, 4)));
    }

    @Test
    public void should_correctly_determine_minimum_possible_draw_for_game3() {
        var game = Game.gameFromString("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red");
        assertThat(game.getMinimumPossibleDraw(), equalTo(new Draw(20, 13, 6)));
    }

    @Test
    public void should_correctly_determine_minimum_possible_draw_for_game4() {
        var game = Game.gameFromString("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red");
        assertThat(game.getMinimumPossibleDraw(), equalTo(new Draw(14, 3, 15)));
    }

    @Test
    public void should_correctly_determine_minimum_possible_draw_for_game5() {
        var game = Game.gameFromString("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green");
        assertThat(game.getMinimumPossibleDraw(), equalTo(new Draw(6, 3, 2)));
    }

}

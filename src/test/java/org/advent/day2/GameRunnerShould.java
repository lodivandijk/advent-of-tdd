package org.advent.day2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class GameRunnerShould {
    private List<String> gameLines = List.of(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green");


    @Test
    public void should_determine_total_of_game_ids_possible() {
        var gameRunner = GameRunner.gameRunnerFromGameStrings(gameLines);
        assertThat(gameRunner.possibleCount(), equalTo(8));
    }

    @Test
    public void should_correctly_determine_summed_up_power() {
        var gameRunner = GameRunner.gameRunnerFromGameStrings(gameLines);
        assertThat(gameRunner.sumPossibleTotalPower(), equalTo(2286));
    }
}

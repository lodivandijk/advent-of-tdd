package org.advent.day2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class GameRunner {
    private List<Game> games;

    public static GameRunner gameRunnerFromGameStrings(List<String> gameStrings) {
        return new GameRunner(gameStrings.stream()
                .map(s -> Game.gameFromString(s))
                .collect(Collectors.toList()));
    }

    public GameRunner(List<Game> games) {
        this.games = games;
    }

    public int possibleCount() {
        return games.stream()
                .filter(g -> !g.isImpossible())
                .mapToInt(g -> g.gameNumber)
                .sum();
    }

    public static void main(String argv[]) {
        try {
            var path = Paths.get("src/main/resources/game-file.txt");
            var lines = Files.readAllLines(path);

            var gameRunner = gameRunnerFromGameStrings(lines);
            System.out.println("Total of possible games: " + gameRunner.possibleCount());
            System.out.println("Total sum of possible power: " + gameRunner.sumPossibleTotalPower());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public int sumPossibleTotalPower() {
        return games.stream()
                .map(g -> g.getMinimumPossibleDraw())
                .mapToInt(d -> d.power())
                .sum();
    }
}

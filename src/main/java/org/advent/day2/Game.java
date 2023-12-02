package org.advent.day2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Game {
    public final int gameNumber;
    public final List<Draw> draws;

    private static final Pattern gamePattern = Pattern.compile("Game (\\d+): (.*)");

    public static Game gameFromString(String gameString) {
        var gameMatcher = gamePattern.matcher(gameString);
        if(gameMatcher.find()) {
            return new Game(Integer.parseInt(gameMatcher.group(1)), drawsFromString(gameMatcher.group(2)));
        } else {
            throw new RuntimeException("Couldn't match game for gamestring " + gameString);
        }
    }

    private static List<Draw> drawsFromString(String drawsString) {
        return Arrays.stream(drawsString.split(";"))
                .map(s -> Draw.drawFromString(s))
                .collect(Collectors.toList());
    }

    public Game(int gameNumber, List<Draw> draws) {
        this.gameNumber = gameNumber;
        this.draws = draws;
    }

    public boolean isImpossible() {
        return draws.stream().anyMatch(d -> d.isImpossible());
    }

    public Draw getMinimumPossibleDraw() {
        var minimumRedValue = draws.stream().mapToInt(d -> d.red).max().getAsInt();
        var minimumGreenValue = draws.stream().mapToInt(d -> d.green).max().getAsInt();
        var minimumBlueValue = draws.stream().mapToInt(d -> d.blue).max().getAsInt();

        return new Draw(minimumRedValue, minimumGreenValue, minimumBlueValue);
    }
}

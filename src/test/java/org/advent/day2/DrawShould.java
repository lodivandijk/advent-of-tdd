package org.advent.day2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DrawShould {

    @Test
    public void should_correctly_determine_rgb_values_for_part1() {
        var line1Draw = Draw.drawFromString("3 blue, 4 red");
        assertThat(line1Draw.red, equalTo(4));
        assertThat(line1Draw.green, equalTo(0));
        assertThat(line1Draw.blue, equalTo(3));
    }

    @Test
    public void should_correctly_determine_rgb_values_for_part2() {
        var line1Draw = Draw.drawFromString("1 red, 2 green, 6 blue");
        assertThat(line1Draw.red, equalTo(1));
        assertThat(line1Draw.green, equalTo(2));
        assertThat(line1Draw.blue, equalTo(6));
    }

    @Test
    public void should_correctly_determine_rgb_values_for_part3() {
        var line1Draw = Draw.drawFromString("2 green");
        assertThat(line1Draw.red, equalTo(0));
        assertThat(line1Draw.green, equalTo(2));
        assertThat(line1Draw.blue, equalTo(0));
    }

    @Test
    public void should_correctly_determine_if_possible_with_values_under_limit() {
        var draw = new Draw(11, 12, 13);
        assertThat(draw.isImpossible(), equalTo(false));
    }
    @Test
    public void should_correctly_determine_if_possible_with_values_on_limit() {
        var draw = new Draw(12, 13, 14);
        assertThat(draw.isImpossible(), equalTo(false));
    }
    @Test
    public void should_correctly_determine_if_impossible_due_to_too_many_reds() {
        var draw = new Draw(13, 12, 13);
        assertThat(draw.isImpossible(), equalTo(true));
    }
    @Test
    public void should_correctly_determine_if_impossible_due_to_too_many_blues() {
        var draw = new Draw(11, 12, 15);
        assertThat(draw.isImpossible(), equalTo(true));
    }
    @Test
    public void should_correctly_determine_if_impossible_due_to_too_many_greens() {
        var draw = new Draw(11, 14, 13);
        assertThat(draw.isImpossible(), equalTo(true));
    }

    @Test
    public void should_correctly_determine_equal_values() {
        assertThat(new Draw(11, 12, 13), equalTo(new Draw(11, 12, 13)));
    }

    @Test
    public void should_correctly_determine_unequal_values() {
        assertThat(new Draw(11, 12, 13), not(equalTo((new Draw(13, 12, 13)))));
    }

    @Test
    public void should_correctly_calculate_different_hashcode() {
        assertThat(new Draw(11, 12, 13).hashCode(), not(equalTo((new Draw(13, 12, 13).hashCode()))));
    }

    @Test
    public void should_correctly_calculate_same_hashcode() {
        assertThat(new Draw(11, 12, 13).hashCode(), equalTo((new Draw(11, 12, 13).hashCode())));
    }

    @Test
    public void should_correctly_calculate_power() {
        assertThat(new Draw(4, 2, 6).power(), equalTo(48));
    }
}
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class CalibrationDocLineShould {
 @Test
 public void should_recognize_first_digit_line_1() {
    var calibrationDocLine = new CalibrationDocLine("1abc2");
    assertThat(calibrationDocLine.getFirstDigit(), equalTo(1));
 }

 @Test
 public void should_recognize_last_digit_line1() {
    var calibrationDocLine = new CalibrationDocLine("1abc2");
    assertThat(calibrationDocLine.getLastDigit(), equalTo(2));
 }
}
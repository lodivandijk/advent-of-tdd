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

 @Test
 public void should_recognize_first_digit_line_2() {
    var calibrationDocLine = new CalibrationDocLine("pqr3stu8vwx");
    assertThat(calibrationDocLine.getFirstDigit(), equalTo(3));
 }

 @Test
 public void should_recognize_last_digit_line2() {
    var calibrationDocLine = new CalibrationDocLine("pqr3stu8vwx");
    assertThat(calibrationDocLine.getLastDigit(), equalTo(8));
 }

  @Test
 public void should_recognize_first_digit_line_3() {
    var calibrationDocLine = new CalibrationDocLine("a1b2c3d4e5f");
    assertThat(calibrationDocLine.getFirstDigit(), equalTo(1));
 }

 @Test
 public void should_recognize_last_digit_line3() {
    var calibrationDocLine = new CalibrationDocLine("a1b2c3d4e5f");
    assertThat(calibrationDocLine.getLastDigit(), equalTo(5));
 }

   @Test
 public void should_recognize_first_digit_line_4() {
    var calibrationDocLine = new CalibrationDocLine("treb7uchet");
    assertThat(calibrationDocLine.getFirstDigit(), equalTo(7));
 }

 @Test
 public void should_recognize_last_digit_line4() {
    var calibrationDocLine = new CalibrationDocLine("treb7uchet");
    assertThat(calibrationDocLine.getLastDigit(), equalTo(7));
 }

}
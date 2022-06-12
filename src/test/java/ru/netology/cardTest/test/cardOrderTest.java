package ru.netology.cardTest.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.cardTest.data.DataGenerator;


import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;



public class cardOrderTest {


    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldCardOrderNewData() {
        var daysToAddForFirstMeeting = 4;
        var firstMeetingDate = DataGenerator.generateDate(daysToAddForFirstMeeting);
        var daysToAddForSecondMeeting = 7;
        var secondMeetingDate = DataGenerator.generateDate(daysToAddForSecondMeeting);

        $("[data-test-id='city'] input").setValue(DataGenerator.generateCity("ru"));
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(DataGenerator.generateDate(4));
        $x("//*[@name=\"name\"]").setValue(DataGenerator.generateName("ru"));
        $x("//*[@name=\"phone\"]").setValue(DataGenerator.generatePhone("ru"));

        $("[data-test-id=\"agreement\"]").click();
        $(withText("Запланировать")).click();
        $("[data-test-id=\"success-notification\"]")
                .shouldHave(Condition.text("Встреча успешно запланирована на " + firstMeetingDate), Duration.ofSeconds(15));

        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(DataGenerator.generateDate(7));
        $(withText("Запланировать")).click();

        $("[data-test-id=\"replan-notification\"]")
                .shouldHave(Condition.text("У вас уже запланирована встреча на другую дату."));
        $(withText("Перепланировать")).click();
        $("[data-test-id=\"success-notification\"]")
                .shouldHave(Condition.text("Встреча успешно запланирована на " + secondMeetingDate), Duration.ofSeconds(15));
    }
}





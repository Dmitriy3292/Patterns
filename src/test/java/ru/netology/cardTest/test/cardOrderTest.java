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
import static com.codeborne.selenide.Selenide.*;





    @Data
    public class cardOrderTest {
        private int DAY_3 = 3;
        UserInfo info = DataGenerator.getUser();
        DataGenerator data = new DataGenerator();

        @BeforeEach
        void setup() {
            open("http://localhost:9999");
        }
        @Test
        void shouldCardOrder() {
            Configuration.holdBrowserOpen = true;
            $("[data-test-id='city'] input").val(info.getCity());
            $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
            $("[data-test-id='date'] input").val(data.generateDate(this.DAY_3));
            $("[data-test-id='name'] input").val(info.getName());
            $("[data-test-id='phone'] input").val(info.getPhone());
            $("[data-test-id='agreement']").click();
            $("div .button").click();
            $("[data-test-id='success-notification'] .notification__title").should(visible, Duration.ofSeconds(15));
            $("[data-test-id='success-notification'] .notification__content")
                    .should(Condition.text("Встреча успешно запланирована на " + data.generateDate(this.DAY_3)), Duration.ofSeconds(15));

        }

        @Test
        void shouldCardOrderNewData() {
            $("[data-test-id='city'] input").val(info.getCity());
            $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
            $("[data-test-id='date'] input").val(data.generateDate(this.DAY_3));
            $("[data-test-id='name'] input").val(info.getName());
            $("[data-test-id='phone'] input").val(info.getPhone());
            $("[data-test-id='agreement']").click();
            $("div .button").click();
            $("[data-test-id='success-notification'] .notification__title").should(visible, Duration.ofSeconds(15));
            $("[data-test-id='success-notification'] .notification__content")
                    .should(Condition.text("Встреча успешно запланирована на " + data.generateDate(this.DAY_3)), Duration.ofSeconds(15));

            $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
            $("[data-test-id='date'] input").val(data.generateDate(this.DAY_5));
            $("div .button").click();
            $("[data-test-id='replan-notification'] .notification__content")
                    .should(Condition.text("У вас уже запланирована встреча на другую дату. Перепланировать?"));
            $("[data-test-id='replan-notification'] .button").click();
            $("[data-test-id='success-notification'] .notification__content")
                    .should(Condition.text("Встреча успешно запланирована на " + data.generateDate(this.DAY_5)), Duration.ofSeconds(15));

        }


    }







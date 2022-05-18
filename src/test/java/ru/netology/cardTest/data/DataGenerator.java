package ru.netology.cardTest.data;


import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.UtilityClass;
import lombok.val;
import ru.netology.cardTest.test.UserInfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Data
@Getter
public class DataGenerator {
    private static String name2;

    public static String getName2() {
        return name2;
    }

    private static final Faker faker = new Faker(new Locale("ru"));

    public static class Registration {
    }

    public DataGenerator() {
    }

    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String getRandomCity() {
        String city = faker.address().city();
        // TODO: добавить логику для объявления переменной login и задания её значения, для генерации
        //  случайного логина используйте faker
        return city;
    }

    public static String getRandomName() {
        String name = faker.name().name();
        // TODO: добавить логику для объявления переменной password и задания её значения, для генерации
        //  случайного пароля используйте faker
        return name;
    }

    public static String getRandomPhone() {
        String phone = faker.phoneNumber().phoneNumber();
        // TODO: добавить логику для объявления переменной password и задания её значения, для генерации
        //  случайного пароля используйте faker
        return phone;
    }

    public static UserInfo getUser() {
        UserInfo user = new UserInfo(getRandomCity(), getRandomName(), getRandomPhone());
        // TODO: создать пользователя user используя методы getRandomLogin(), getRandomPassword() и параметр status
        return user;
    }

}

package ru.netology.cardTest.data;


import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Value;
import lombok.experimental.UtilityClass;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

    public class DataGenerator {
        private DataGenerator() {
        }
        private static final Faker faker = new Faker(new Locale("ru"));

        public static String generateDate(int days) {
            String date = LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return date;
        }

        public static String generateCity(String locale) {
            String city = faker.address().city();
            return city;
        }

        public static String generateName(String locale) {
            String name = faker.name().fullName();
            return name;
        }

        public static String generatePhone(String locale) {
            String phone = faker.phoneNumber().phoneNumber();
            return phone;
        }
            public static UserInfo generateUser(String locale) {
               Faker faker = new Faker(new Locale(locale));
                return new UserInfo(faker.name().fullName(),
                        faker.phoneNumber().phoneNumber(),
                        faker.address().city());
            }
        }

        @Value
        public class UserInfo {
            String city;
            String name;
            String phone;
        }



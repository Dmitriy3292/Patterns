package ru.netology.cardTest.test;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfo {
    String city;
    String name;
    String phone;
}
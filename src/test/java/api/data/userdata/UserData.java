package api.data.userdata;


import com.github.javafaker.Faker;

public class UserData {
    static Faker faker = new Faker();

    public static String
            email = faker.internet().emailAddress(),
            password = faker.internet().password(),
            username = faker.name().username(),

            phone = "9169597677",

            emailVerify = email,

            country = "Россия",
            hourzone = "Europe/Moscow (10:41)",
            promo = "Test123";


}

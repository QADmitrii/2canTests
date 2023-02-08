package api.data.userdata;


import com.github.javafaker.Faker;

public class UserData {
    Faker faker = new Faker();

    public String
            email = faker.internet().emailAddress(),
            password = faker.internet().password(),
            username = faker.name().username();

}

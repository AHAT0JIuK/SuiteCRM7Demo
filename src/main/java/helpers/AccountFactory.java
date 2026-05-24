package helpers;

import com.github.javafaker.Faker;
import dto.Account;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AccountFactory {

    public static Account getAccount(String type, String industry, String numberEmail) {
        log.info("Генерация данных по новому аккаунту. Тип аккаунта, вид промышленности и порядковый номер " +
                        "email заданы ранее и равны соответственно: '{}', '{}', '{}'", type, industry,
                Integer.parseInt(numberEmail) + 1);
        Faker faker = new Faker();
        return new Account(faker.company().name(), faker.phoneNumber().phoneNumber(), faker.phoneNumber().phoneNumber(),
                faker.internet().url(), faker.address().streetAddress(), faker.address().streetAddress(), type,
                industry, numberEmail, faker.address().city(), faker.address().state(), faker.address().zipCode(),
                faker.address().country(), faker.lorem().sentence(5), faker.number().digits(7),
                faker.number().digits(3));
    }
}

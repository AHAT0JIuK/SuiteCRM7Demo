package helpers;

import com.github.javafaker.Faker;
import dto.Contact;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ContactFactory {

    public static Contact getContact(String title, String numberEmail, String leadSource) {
        log.info("Генерация данных по новому контакту. Обращение, порядковый номер email'а и Lead Source" +
                        "заданы ранее и равны соответственно: '{}', '{}', '{}'", title,
                Integer.parseInt(numberEmail) + 1, leadSource);
        Faker faker = new Faker();
        return new Contact(title, faker.name().firstName(), faker.name().lastName(), faker.phoneNumber().phoneNumber(),
                faker.phoneNumber().cellPhone(), faker.job().title(), faker.job().field(),
                faker.phoneNumber().phoneNumber(), numberEmail, faker.address().streetAddress(), faker.address().city(),
                faker.address().state(), faker.address().zipCode(), faker.address().country(),
                faker.lorem().sentence(5), leadSource);
    }
}
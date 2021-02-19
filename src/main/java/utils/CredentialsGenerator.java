package utils;

import org.apache.commons.lang3.RandomUtils;

import static org.apache.commons.lang3.RandomStringUtils.*;

public class CredentialsGenerator {


    public static String generateName() {

        return randomAlphabetic(RandomUtils.nextInt(2, 20));
    }

    public static String generateEmail() {

        return randomAlphanumeric(RandomUtils.nextInt(2, 12)) + "@"
                + randomAlphanumeric(RandomUtils.nextInt(2, 8)) + ".com";

    }

    public static String generateAddress() {

        return randomAlphabetic(RandomUtils.nextInt(2, 20)) + " " + randomAlphabetic(RandomUtils.nextInt(2, 20))
                + " " + randomAlphanumeric(2, 5);

    }

    public static String generatePassword() {
        return randomAlphanumeric(RandomUtils.nextInt(6, 12));
    }

    public static String generatePhone() {
        return "+" + randomNumeric(RandomUtils.nextInt(5, 12));
    }

}

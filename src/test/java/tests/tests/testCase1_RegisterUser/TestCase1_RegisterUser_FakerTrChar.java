package tests.tests.testCase1_RegisterUser;


import org.testng.annotations.Test;
import tests.base.TestBaseBeforeClassAfterClass;

public class TestCase1_RegisterUser_FakerTrChar extends TestBaseBeforeClassAfterClass {
    @Test
    public void validEmailWithoutTurkishChars() {

        String email = faker.internet().emailAddress();
        boolean trChars = email.substring(0, 1).equals("ı") || email.substring(0, 1).equals("ü") || email.substring(0, 1).equals("ç") || email.substring(0, 1).equals("ş") || email.substring(0, 1).equals("ö");

        while (trChars) {
            email = faker.internet().emailAddress();
            System.out.println("All tries: " + email);
        }

        System.out.println("Valid email: " + email);

    }
}

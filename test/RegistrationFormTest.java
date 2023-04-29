

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import registraion.form.RegistrationForm;

public class RegistrationFormTest {

    @Test
    public void testCheckUsernameWithCorrectFormat() {
        assertTrue(RegistrationForm.checkUsername("kyl_1"));
    }

    @Test
    public void testCheckUsernameWithIncorrectFormat() {
        assertFalse(RegistrationForm.checkUsername("kyle!!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexityWithCorrectFormat() {
        assertTrue(RegistrationForm.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexityWithIncorrectFormat() {
        assertFalse(RegistrationForm.checkPasswordComplexity("password"));
    }

    @Test
    public void testAuthenticateWithCorrectCredentials() {
        RegistrationForm.accounts.put("kyl_1", new String[]{"John", "Doe", "Ch&&sec@ke99!"});
        assertTrue(RegistrationForm.authenticate("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testAuthenticateWithIncorrectCredentials() {
        RegistrationForm.accounts.put("kyl_1", new String[]{"John", "Doe", "Ch&&sec@ke99!"});
        assertFalse(RegistrationForm.authenticate("kyl_1", "wrong_password"));
    }

    @Test
    public void testAuthenticateWithNonExistentUsername() {
        assertFalse(RegistrationForm.authenticate("non_existent_user", "password"));
    }

    @Test
    public void testMain() {
        // TODO: add a test case for the main method
    }

}

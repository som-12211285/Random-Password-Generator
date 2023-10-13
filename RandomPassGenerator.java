import java.security.SecureRandom;
import java.util.Random;

public class RandomPassGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    public static String generateRandomPassword(int length, boolean useLowercase, boolean useUppercase, boolean useDigits, boolean useSpecialChars) {
        // Step 3: Check Character Set Selection
        if (!(useLowercase || useUppercase || useDigits || useSpecialChars)) {
            throw new IllegalArgumentException("At least one character set must be selected.");
        }

        // Step 4: Generate the Password
        StringBuilder password = new StringBuilder();
        Random random = new SecureRandom();
        StringBuilder characters = new StringBuilder();
        if (useLowercase) characters.append(LOWERCASE);
        if (useUppercase) characters.append(UPPERCASE);
        if (useDigits) characters.append(DIGITS);
        if (useSpecialChars) characters.append(SPECIAL_CHARACTERS);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        // Step 5: Return the Password
        return password.toString();
    }

    public static void main(String[] args) {
        // Step 6: Example Usage
        int length = 12;
        boolean useLowercase = true;
        boolean useUppercase = true;
        boolean useDigits = true;
        boolean useSpecialChars = true;

        String randomPassword = generateRandomPassword(length, useLowercase, useUppercase, useDigits, useSpecialChars);
        System.out.println("Generated Password: " + randomPassword);
    }
}

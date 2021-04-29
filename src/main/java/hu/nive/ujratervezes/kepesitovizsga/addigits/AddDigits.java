package hu.nive.ujratervezes.kepesitovizsga.addigits;

public class AddDigits {

    public int addDigits(String input) {
        int sumDigits = 0;
        if (input == null || input.isBlank()) {
            return -1;
        }
        for (char ch: input.toCharArray()) {
            if (Character.isDigit(ch)) {
                sumDigits+= Character.getNumericValue(ch);
            }
        }
        return sumDigits;
    }
}

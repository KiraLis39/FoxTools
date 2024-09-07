package fox.utils;

import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://www.codeflow.site/ru/article/java-convert-roman-arabic
@UtilityClass
public class RomanArabicConverter {
    public int romanToArabic(String input) throws Exception {
        int result = 0;

        try {
            result = Integer.parseInt(input); // быть может, это уже и так арабский тип?
        } catch (NumberFormatException nfe) {
            try {
                // очевидно, не арабский. Тогда пытаемся перевести:
                String romanNumeral = input.toUpperCase();
                List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

                int i = 0;
                while ((!romanNumeral.isEmpty()) && (i < romanNumerals.size())) {
                    RomanNumeral symbol = romanNumerals.get(i);
                    if (romanNumeral.startsWith(symbol.name())) {
                        result += symbol.getValue();
                        romanNumeral = romanNumeral.substring(symbol.name().length());
                    } else {
                        i++;
                    }
                }

                if (!romanNumeral.isEmpty()) {
                    throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
                }
            } catch (Exception e2) {
                throw new Exception("Не удалось преобразовать тип числа: " + e2.getMessage());
            }
        }

        return result;
    }

    public String arabicToRoman(int number) {
        // содрано с https://www.codeflow.site/ru/article/java-convert-roman-arabic
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    @Getter
    public enum RomanNumeral {
        I(1),
        IV(4),
        //VI(6),
        V(5),
        IX(9),
        X(10),
        //XI(11),
        XL(40),
        L(50),
        XC(90),
        C(100),
        CD(400),
        D(500),
        CM(900),
        M(1000);

        private final int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public static List<RomanNumeral> getReverseSortedValues() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                    .toList();
        }
    }
}

import java.util.Scanner;

public class Calculator1 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String expression = scanner.nextLine();
        System.out.println(parse(expression));
    }

    public static String parse(String expression) throws Exception {
        int number1;
        int number2;
        String operand;
        String result;
        boolean isRoman;
        String[] operands = expression.split("[+\\-*/]");
        if (operands.length != 2) throw new Exception("Допустимо только 2 операнда");
        operand = detectOperation(expression);
        if (Roman1.isRoman(operands[0]) && Roman1.isRoman(operands[1])) { //Проверка римских чисел
            number1 = Roman1.convertToArabian(operands[0]);
            number2 = Roman1.convertToArabian(operands[1]);
            isRoman = true;
        }
        else if (!Roman1.isRoman(operands[0]) && !Roman1.isRoman(operands[1])) { //Проверка арабских чисел
            number1 = Integer.parseInt(operands[0]);
            number2 = Integer.parseInt(operands[1]);
            isRoman = false;
        }
        else {
            throw new Exception("Числа должны быть в одном формате");
        }
        if (number1 > 10 || number2 > 10) {
            throw new Exception("Только числа от 1 до 10");
        }
        int arabian = calc(number1, number2, operand);
        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }
            result = Roman1.convertToRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;
    }

    static String detectOperation(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }
    static int calc(int a, int b, String operand) {
        if (operand.equals("+")) return a + b;
        else if (operand.equals("-")) return a - b;
        else if (operand.equals("*")) return a * b;
        else return a/b;
    }
}
class Roman1 {
    static String[] romanArray = new String[] {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static boolean isRoman(String value) {
        for (int index = 0; index < romanArray.length; index++) {
            if (value.equals(romanArray[index])) {
                return true;
            }
        }
        return false;
    }

    public static int convertToArabian(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToRoman(int arabian) {
        return romanArray[arabian];
    }
}
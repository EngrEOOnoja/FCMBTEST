package StringCapitalizeWord;

public class StringCapitalize {
    public static void main(String[] args) {
        String input = "this is a tree.";
        String result = capitalizeWords(input);

        System.out.println("Input: " + input);
        System.out.println("Output: " + result);
    }

    public static String capitalizeWords(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (i == 0 || chars[i - 1] == ' ') {
                if (chars[i] >= 'a' && chars[i] <= 'z') {

                    chars[i] = (char) (chars[i] - 32);
                }
            }
        }

        return new String(chars);
    }
}

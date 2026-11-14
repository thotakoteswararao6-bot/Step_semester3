package string.assignment_problems12;

public class SecretNotice {

    static String shiftNotice(String text, int k) {
        StringBuilder sb = new StringBuilder();

        for (char c : text.toCharArray()) {

            if (c >= 'a' && c <= 'z')
                sb.append((char)((c - 'a' + k) % 26 + 'a'));

            else if (c >= 'A' && c <= 'Z')
                sb.append((char)((c - 'A' + k) % 26 + 'A'));

            else
                sb.append(c);
        }

        return sb.toString();
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = reader.readLine();
            char[] lineCh = line.toCharArray();

            System.out.println(line);
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                for (int j = 0; j < 3; j++) {
                    str.append(lineCh[i]);
                }
            }
            System.out.println(str);
            for (int i = 0; i < str.length(); i += 3) {
                Random random = new Random();
                int three = random.nextInt(3);
                char ch = (char) (random.nextInt(26) + 65);
                if (i + three >= str.length()){
                    break;
                }
                str.setCharAt(i + three, ch);
            }
            System.out.println(str);
            for (int i = 0; i < str.length() - 2; i += 3) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    System.out.print(str.charAt(i));
                } else {
                    System.out.print(str.charAt(i + 2));
                }
            }
        }
    }
}

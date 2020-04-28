import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().replaceAll("\\W","").split("");
        Set str = new HashSet();

        for (int i = 0; i < in.length; i++) {
            if(in[i].matches("\\w"))
                str.add(in[i]);
        }
        System.out.println(str.size());
    }
}

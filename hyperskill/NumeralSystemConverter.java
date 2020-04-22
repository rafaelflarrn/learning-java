package converter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        try {
            Scanner sc = new Scanner(System.in);
            String[] str = new String[3];
            int cont = 0;

            while (sc.hasNext()) {
                str[cont] = sc.next().trim();
                cont++;
            }

            if (cont != 3) {
                throw new Exception("Error");
            }

            String radixOfNumStr = str[0];
            String[] numInString = str[1].split("\\.");
            String radixTargetStr = str[2];
            int radixOfNum;
            int radixTarget;

            if (radixOfNumStr.matches("\\d+")) {
                radixOfNum = Integer.parseInt(radixOfNumStr);
                if (radixOfNum < 1 || radixOfNum > 36) {
                    throw new Exception("Error!");
                }
            } else {
                throw new Exception("Error!");
            }
            if (radixTargetStr.matches("\\d+")) {
                radixTarget = Integer.parseInt(radixTargetStr);
                if (radixTarget < 1 || radixTarget > 36) {
                    throw new Exception("Error!");
                }
            } else {
                throw new Exception("Error!");
            }

            int integer;
            long num;
            long fractionalDouble = 0L;

            if (radixOfNum == 1) {
                num = numInString[0].length();
            } else {
                num = Long.parseLong(numInString[0], radixOfNum);
            }

            if (radixTarget == 1) {
                for (int i = 0; i < num; i++) {
                    System.out.print(1);
                }
            } else {
                String numTarget = Long.toString(num, radixTarget);
                if (numInString.length == 2) {
                    System.out.print(numTarget + ".");
                    double numFractional = 0.0;
                    if (radixOfNum != 10) {
                        for (int i = 0; i < numInString[1].length(); i++) {
                            double toDouble = Character.getNumericValue(numInString[1].charAt(i));
                            numFractional += toDouble / (radixOfNum * Math.pow(radixOfNum, i));
                        }
                    } else {
                        long transform = Long.parseLong(numInString[1], radixOfNum);
                        numFractional = (double) transform;
                        numFractional /= Math.pow(10, numInString[1].length());
                    }

                    for (int i = 0; i < 5; i++) {
                        numFractional *= radixTarget;
                        integer = (int) numFractional;
                        numFractional -= integer;
                        fractionalDouble = integer;
                        String fractionalDoubleString = Long.toString(fractionalDouble, radixTarget);
                        System.out.print(fractionalDoubleString);
                    }
                } else {
                    System.out.print(numTarget);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
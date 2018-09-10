import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

// CHRISTIAN HJELMSLUND

public class NetPresentValue {

    public static void main(String[] args) {
        System.out.println("Your NPV is: "+calculateNetPresentValue());
    }

    public static double calculateNetPresentValue(){

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        double res;
        int count = 1;
        float interest;

        System.out.println("Provide the value for the interest rate");
        interest = sc.nextFloat();
        System.out.println("Provide the value for the initial investment (non-negative!)");
        res = -sc.nextFloat();
        System.out.println("Provide the cash flow for year "+count+", and remember to use the right sign. \n"+
                "When the final year has been reached simply type \"done\"");

        while (true) {
            if (sc.hasNextFloat()) {
                res = res + sc.nextFloat()/Math.pow((1+interest),count);
                count++;
                System.out.println("Provide the cash flow for year "+count);
            }
            if (sc.nextLine().equals("done")) {
                break;
            }
        }
        return res;
    }
}

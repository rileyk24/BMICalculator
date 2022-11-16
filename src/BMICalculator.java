

import java.util.Scanner;
import java.text.DecimalFormat;
public class BMICalculator {
    /**
     * Convert English to metric units, perform the BMI calculation.
     * * NOTE: this method must properly handle bad data
     * public static double computeBMI(int inches, int pounds)
     *
     * @param inches user's height in inches
     * @param pounds user;s weight in pounds
     * @return user's bmi weight(kg)/height(m^2) a double
     */
    public static double computeBMI(int inches, int pounds) { //.method indicates the method is static
        double kgs, meters;
        if(inches <= 0 || pounds <= 0)
            return 0.;
        meters = inches * 0.0254;
        kgs = pounds * 0.454;
        return kgs/Math.pow(meters, 2);
    }
    /**
     * Uses a Scanner to prompt the user for info, process the
     * feet/inches conversion, calls the computeBMI method and prints the
     * correct information.
     */
    public static void main(String[] args) { // one main entry point, static = one entry point
        Scanner in = new Scanner(System.in);
        String userin = new String();
        int inches, pounds;
        DecimalFormat df = new DecimalFormat("0.00");

        while (true) {


            //sanitize height + convert to inches 6'2"
            //userin.indexOf("'");
            try {
                System.out.print("Enter your height in feet and inches (Ex 6'1\") or 0 to quit: ");
                userin = in.nextLine();
                if (userin.equals("0")) {
                    break; }
                inches = Integer.parseInt(userin.substring(0, userin.indexOf("'"))) * 12;
                inches += Integer.parseInt(userin.substring(userin.indexOf("'") + 1, userin.length() - 1));
                System.out.println("Debug: " + inches);
                System.out.print("Enter your weigh in pounds: ");
                userin =  in.nextLine();
                pounds = Integer.parseInt(userin);
                System.out.println("your bmi, expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(inches, pounds)));

                }
            catch(Exception e){
                    System.out.print("There was an error, see here: " );
                    e.printStackTrace();
                }
            }
        }
    }

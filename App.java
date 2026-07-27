import java.util.Scanner;

public class App {

/**
 * 
 * @param a original number as string
 * @param b orginal base as int
 * @return returns decimal value
 */
    public static double hasDecimalPoint (String a, int b){ //method to convert if there is a decimal point, so only for decimal conversions

        double num = 0; //variable to hold the total value in base 10.

        int dotIndex = a.indexOf('.'); //holds the index of where the decimal point is at

        String beforeDot = a.substring(0,dotIndex); //a new substring of all numbers as a string before the decimal
        String afterDot = a.substring(dotIndex+1); //a new substring of all numbers as a string after the decimal

        double bdecimal = 0; //variable to hold the total value of all numbers in base 10 before the decimal
        double adecimal = 0; //variable to hold the total value of all numbers in base 10 after the decimal

        for (int i = 0; i<beforeDot.length(); i++){ //loops through the characters of the substring before the decimal

            char x = beforeDot.charAt(i); //takes the character at i in the beforeDot substring
            int bvalue = 0; //variable to hold the digit

            if (Character.isDigit(x)){ //checks if its a number
                bvalue = Integer.parseInt(Character.toString(x)); //if yes, then parses it into an integer
            }

            else{ //otherwise 
            
                switch (x) { // if i is any of A-F, it assigns it its value
                    case 'A':
                        bvalue = 10; //A would be 10
                        break;

                    case 'B':
                        bvalue = 11; //B would be 11
                        break;

                    case 'C':
                        bvalue = 12; //C would be 12
                        break;

                    case 'D':
                        bvalue = 13;
                        break;

                    case 'E':
                        bvalue = 14;
                        break;

                    case 'F':
                        bvalue = 15;
                        break;
                        
                    default: //if not from A-F, then it is an error
                        System.out.println("Error: Base 16 can only have letters from A-F");
                        System.exit(0); //and it stops the program
                }
            }

            num += bvalue * Math.pow(b, beforeDot.length()-i-1); //bvalue to the power of the total length minus i and 1
        }


         for (int i = 0; i<afterDot.length(); i++){ //loops through the substring of integers after the decimal

            char x = afterDot.charAt(i);
            int avalue = 0;

            if (Character.isDigit(x)){
                avalue = Integer.parseInt(Character.toString(x));
            }
            
            else{
                switch (x) {
                    case 'A':
                        avalue = 10;
                        break;

                    case 'B':
                        avalue = 11;
                        break;

                    case 'C':
                        avalue = 12;
                        break;

                    case 'D':
                        avalue = 13;
                        break;

                    case 'E':
                        avalue = 14;
                        break;

                    case 'F':
                        avalue = 15;
                        break;
                        
                    default:
                        System.out.println("Error: Base 16 can only have letters from A-F");
                        System.exit(0);
                }
            }

            num += avalue * Math.pow(b, -(i+1)); //adds avalue which will be the int to the power of -(i+1), to give it as a decimal
        }

        return num; //returns num.
    }

    /***
     * 
     * @param number
     * @param base
     * @return the value of the number of base b to base 10
     */
    public static int convertToBase10(String a, int b){ //method to convert values to base 10.
        
        int num = 0; //value which will be the total 


        for (int i = 0; i < a.length(); i++){ //loops through the string

            char x = a.charAt(i); //the character at i
            int value = 0; //the value of whatever is at i

            if (Character.isDigit(x)){ //if the character at i is a digit
                value = Integer.parseInt(Character.toString(x)); //value will be the i, also being able to parse into a int with ease
            }
            else{ //if i is not a digit
                
                switch (x) { //checks if i is any of A-F, if yes, it assigns the value depending on the letter
                    case 'A':
                        value = 10;
                        break;

                    case 'B':
                        value = 11;
                        break;

                    case 'C':
                        value = 12;
                        break;

                    case 'D':
                        value = 13;
                        break;

                    case 'E':
                        value = 14;
                        break;

                    case 'F':
                        value = 15;
                        break;
                            
                    default: //otherwise the string has letters after F, or it is a character
                        System.out.println("Error: Base 16 can only have letters from A-F");
                        System.exit(0);
                }
            }

            num += value * Math.pow(b, a.length()-i-1); //num is the value of i to the power of the length-1-i
        }

        return num;
    }

    /**
     * 
     * @param number
     * @param target-base
     * @return the number (as a base 10) to the target base
     */
    public static String convertToTargetBase(int n, int c){ 

        String output = ""; //string to hold the number in the target base 

        while (n > 0){ // while n is greater than 0
            int s = n%c; //s is going to be the remainder of n / c  as an int
            
            if (s>9){ // if s is greater than 9

                switch (s) { //then it will be converted to one of A-F, depending on its values, and adds it to the output at the beginning
                    case 10:
                        output = 'A' + output; 
                        break;

                    case 11:
                        output = 'B' + output;
                        break;

                    case 12:
                        output = 'C' + output;
                        break;

                    case 13:
                        output = 'D' + output;
                        break;

                    case 14:
                        output = 'E' + output;
                        break;

                    case 15:
                        output = 'F' + output;
                        break;
                        
                    default: //otherwise give an error, which should be impossible, as the highest base allowed is 16
                        System.out.println("Error");
                        
            }

            n = n/c; // reduces n to prevent an infinite stack overflow

            }

            else if ( s < 10){ //if s is less than 10 then 

                output = s + output; //adds the int at the start of the output string
                n = n / c; //reduction step

            }
        }

        return output; //returns output
    }

    public static String convertDecimal (double n, int c){

        String wholeOutput = ""; //string to hold the number in the target base
        
        int whole = (int)n/1; //variable to hold the integer value of n, this will be the output before the decimal point

        while (whole > 0){ //while whole is greater than 0
            int s = whole%c; //the remainder of whole / c
            
            if (s>9){ // if s is greater than 9

                switch (s) { //then it will be converted to one of A-F, depending on its values, and adds it to the output of the values before the decimal point, at the beginning
                    case 10:
                        wholeOutput = 'A' + wholeOutput;
                        break;

                    case 11:
                        wholeOutput = 'B' + wholeOutput;
                        break;

                    case 12:
                        wholeOutput = 'C' + wholeOutput;
                        break;

                    case 13:
                        wholeOutput = 'D' + wholeOutput;
                        break;

                    case 14:
                        wholeOutput = 'E' + wholeOutput;
                        break;

                    case 15:
                        wholeOutput = 'F' + wholeOutput;
                        break;
                        
                    default: //otherwise give an error, which should be impossible, as the highest base allowed is 16
                        System.out.println("Error");
                        
            }

            whole = whole/c; // reduces whole to prevent an infinite stack overflow
        }

        else if (s < 10){ //if s is less than 10 then

                wholeOutput = s + wholeOutput; //adds the int at the start of the output string
                whole = whole / c; //reduction step

            }
    }

    String fractionOutput = ""; //variable to hold the decimal value of n, this will be the output after the decimal point

    double fraction = Math.round((n - Math.floor(n)) * 1000000000.0) / 1000000000.0; //also takes care of the floating point error

    while (fraction > 0){ //while fraction is greater than 0

        fraction = fraction*c; //multiplies by c
        int y = (int)fraction; // int value of fraction

        if (y>9){ //if less than 9

                switch ((int)y) { 
                    case 10:
                        fractionOutput = 'A' + fractionOutput;
                        break;

                    case 11:
                        fractionOutput = 'B' + fractionOutput;
                        break;

                    case 12:
                        fractionOutput = 'C' + fractionOutput;
                        break;

                    case 13:
                        fractionOutput = 'D' + fractionOutput;
                        break;

                    case 14:
                        fractionOutput = 'E' + fractionOutput;
                        break;

                    case 15:
                        fractionOutput = 'F' + fractionOutput;
                        break;
                        
                    default:
                        System.out.println("Error");
                        
            }

            fraction = fraction - y; //substract y from fraction

        }

        else if(y < 10){ // if y is less than 10

            fractionOutput = fractionOutput + (int)y; //adds integer value to fractionOutput
            fraction = fraction - y; //reduction step

        }
    }

    String output = wholeOutput + '.' + fractionOutput; // adds the whole part and the fraction part, with a decimal point in between


        return output;
    }

    /**
     * checks base
     * @return the value if no errors are provoked
     */
    public static int baseCheck(){

        Scanner sC = new Scanner (System.in); //scanner
        int input; //the input that will be outputted
        String line = "";

        while (true){
            try{

                line = sC.nextLine();
                input = Integer.parseInt(line);

                if ((input <= 1) || ((input <= 15) && (input > 10)) || (input > 16)){ //if base is 1 or 11-15 or greater than 16

                    throw new NumberFormatException(); //throw error

                }
                break;

            } catch (NumberFormatException e){

                System.out.println("Error: Base must be between 2-10 or 16");

            }

        }
        return input;
    }

    public static void main(String[] args) throws Exception {

        Scanner sC = new Scanner (System.in);

        System.out.println("Enter a number (can include a decimal point) to convert:");
        String i = sC.nextLine();

        System.out.println("Enter the current base of your previous input");
        int currentBase = baseCheck();

        System.out.println("Enter the target base you want to convert your string into");
        int targetBase = baseCheck();

        if (i.contains(".")){
            double decimalSum = hasDecimalPoint(i, currentBase);
            String fractionalNumber = convertDecimal(decimalSum, targetBase);
            //System.out.println(Math.round(decimalSum * 1000000000.0) / 1000000000.0);

            System.out.printf("Your number converted to base %d is %s", targetBase, fractionalNumber);

        }
        else{
            int baseSum = convertToBase10(i, currentBase);
            String toTarget = convertToTargetBase(baseSum, targetBase);
            System.out.println(baseSum);
            System.out.printf("Your number converted to base %d is %s", targetBase, toTarget);

        }
    }
}

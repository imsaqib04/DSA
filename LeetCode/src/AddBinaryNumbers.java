/*
import java.util.Scanner;

public class AddBinaryNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two binary numbers
        System.out.print("Enter the first binary number: ");
        String binary1 = scanner.nextLine();

        System.out.print("Enter the second binary number: ");
        String binary2 = scanner.nextLine();

        // Adding binary numbers using Integer.parseInt to convert binary to decimal
        String result = addBinary(binary1, binary2);

        // Output the result
        System.out.println("The sum of the two binary numbers is: " + result);

//        scanner.close();
    }

    // Method to add two binary numbers
    public static String addBinary(String a, String b) {
        // Convert binary strings to integers
        int decimalA = Integer.parseInt ( a,2 ); // Parse binary string to integer (base 2)
        int decimalB = Integer.parseInt(b, 2); // Parse binary string to integer (base 2)

        // Add the two decimal values
        int sum = decimalA + decimalB;

        // Convert the sum back to binary
        return Integer.toBinaryString(sum); // Return the binary string representation of the sum
    }
}
*/
public class AddBinaryNumbers {
    public static String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder ();
        int carry = 0;
        int i = a.length () - 1;
        int j = b.length () - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                char currentCharA = a.charAt ( i );
                int currentBitA = Integer.parseInt ( String.valueOf ( currentCharA ) );
                sum += currentBitA;
                i--;
            }

            if (j >= 0) {
                char currentCharB = b.charAt ( j );
                int currentBitB = Integer.parseInt ( String.valueOf ( currentCharB ) );
                sum += currentBitB;
                j--;
            }


            result.append ( sum % 2 );


            carry = sum / 2;

        }
        return result.reverse ().toString ();
    }

    public static void main(String[] args) {
        AddBinaryNumbers abn = new AddBinaryNumbers ();

        String result = AddBinaryNumbers.addBinary ( "1010","0101" );
        System.out.println ("result "+ result);
    }
}
public class MultyplyStrings {
        public String multiply(String num1, String num2) {
            // Handle edge case where one number is 0
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }

            int m = num1.length();
            int n = num2.length();
            int[] pos = new int[m + n]; // Array to store the product digits

            // Iterate from right to left (least significant digits)
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    // Convert characters to integers
                    int digit1 = num1.charAt(i) - '0';
                    int digit2 = num2.charAt(j) - '0';

                    // Calculate product of the two digits
                    int mul = digit1 * digit2;

                    // The position 'p2' is where the current digit goes
                    // The position 'p1' is where the carry goes
                    int p1 = i + j;
                    int p2 = i + j + 1;

                    // Add multiplication result to existing value at p2 (from previous steps)
                    int sum = mul + pos[p2];

                    // Update positions:
                    pos[p1] += sum / 10; // Add carry to the left index
                    pos[p2] = sum % 10;  // Store the remainder at the current index
                }
            }

            // Convert the result array to a String
            StringBuilder sb = new StringBuilder();
            for (int p : pos) {
                // Skip leading zeros
                if (!(sb.length() == 0 && p == 0)) {
                    sb.append(p);
                }
            }

            return sb.toString();
        }
    }

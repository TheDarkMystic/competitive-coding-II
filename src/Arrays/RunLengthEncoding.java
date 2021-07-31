package Arrays;

/**
 * @author jakadam on 2020-07-22
 */

/**
 * Given an input string, write a function that returns the Run Length Encoded string for the input string.
 * For example, if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6”.
 *
 *
 * a) Pick the first character from source string.
 * b) Append the picked character to the destination string.
 * c) Count the number of subsequent occurrences of the picked character and append the count to destination string.
 * d) Pick the next character and repeat steps b) c) and d) if end of string is NOT reached.
 */

// Java program to implement run length encoding

public class RunLengthEncoding {
    /*public static void printRLE(String str)
    {
        int n = str.length();
        for (int i = 0; i < n; i++) {

            // Count occurrences of current character
            int count = 1;
            while (i < n - 1 &&
                    str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            // Print character and its count
            System.out.print(str.charAt(i));
            System.out.print(count);
        }
    }*/

    public static void printRLE(String str){
        int len=str.length();


        for(int i=0; i<len; i++){
            int count=1;
            while(i<len-1 && str.charAt(i)==str.charAt(i+1)){
                    count++;
                    i++;
            }
            System.out.print(str.charAt(i)+""+count);
        }
    }

    public static void main(String[] args)
    {
        String str = "wwwwaaadexxxxxxywww";
        printRLE(str);
    }
}
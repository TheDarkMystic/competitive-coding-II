package Strings;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Example:
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */

public class Palindrome {
    public static void main(String args[]){
        PalindromeSolver solver = new PalindromeSolver();
        //ans: palindrome
        System.out.println(solver.solve("A man, a plan, a canal: Panama"));

        //ans: not a palindrome
        System.out.println(solver.solve("race a car" ));


    }
}

class PalindromeSolver{
    public static int solve(String str){

        /*
        1. convert the string to lowercase
        2. remove all the non alphanumeric characters using regex
        3. convert string to char array for further operations
         */
        char[] strArray=str.toLowerCase()
                        .replaceAll("[^a-zA-Z0-9]","")
                        .toCharArray();

        int len=strArray.length;
        int ans=1;

        // corner case: after removal of non-alphanumeric chars, if length of the string is 0 or 1,
        // return palindrome as answer
        // eg. str= """
        if(len==0 || len==1)
            return ans;

        //compare elements of the Array from both the ends till the mid point is reached
        for(int i=0;i<=len/2;i++){
            if(strArray[i]!=strArray[len-i-1]){
                ans=0;
                break;
            }

        }
        return ans;


        /*
        Solution without using regex

        char[] arr = a.toLowerCase().toCharArray();
	    int i=0;int j=arr.length-1;
	    while(i<j){
	        if(!((arr[i]>='a' && arr[i]<='z') || (arr[i]>='0' && arr[i]<='9'))){i++;continue;}
	        if(!((arr[j]>='a' && arr[j]<='z') || (arr[j]>='0' && arr[j]<='9'))){j--;continue;}
	        if(arr[i++]!=arr[j--])return 0;
	    }
	    return 1;

         */
    }
}
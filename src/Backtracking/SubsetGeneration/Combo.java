/*Given n dice each with m faces, numbered from 1 to m,
find the number of ways to get sum X.
X is the summation of values on each face when all the dice are thrown.

1   => sum x => 1 way

2   => sum 4 => 1,3 2,2

3   => sum 5 => 1,1,3     1,2,2     1,3,1     2,1,2     2,2,1   3,1,1



3   => sum 6 => 1,1,4   1,2,3

3   => sum 4 => 1,1,2   1,2,1



*/
import java.util.*;
public class Combo{




    //static int  finalCount=0;

    static Map<String, Integer> dpMap; // stores (numDice+""+targetSum) as key and number of ways as value
    public static  void main(String ars[]){
        dpMap= new HashMap<>();

        System.out.println(findCombinations(2,6,4));
        System.out.println(findCombinations(2,6,7));


    }


    public static int findCombinations(int numDice, int numFaces, int target){


        //sum successfully achieved
        if(numDice == 0 && target == 0)
            return 1;

        //sum cannot be reached
        if(numDice == 0 || target == 0)
            return 0;


        //memoization : Maintain a string for sub - problems
        String key = numDice+" "+target;
        if(dpMap.containsKey(key))
            return dpMap.get(key);


        int ans = 0;

        //for(int i=1; i<=numDice; i++){
        for(int j=1; j<=numFaces; j++){
            if(target-j>=0 ){// eliminating invalid combinations
                ans= ans+findCombinations(numDice-1, numFaces, target-j);
            }
            else break;
        }

            /*

            removed outer loop . populating all possbible combinations using
            for eachFace of n faces
                cacluate number of ways to achieve remaining sum
                with remaining number of dice

            */
        //}


        //storing solutions to the sub - problem
        dpMap.put(key,ans);
        return ans;

    }
}



//1,3
//2,2


/*
m*m*m*....*m = m^n

    findCombinations(2,6,4)
        findCombinations(1,6,3)
            return 1
        findCombinations(1,6,2)
            return 1
        findCombinations(1,6,1)
            return 1


            0

        1   2   3
        */
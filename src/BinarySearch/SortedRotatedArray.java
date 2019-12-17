package BinarySearch;

import java.util.Arrays;
import java.util.List;

public class SortedRotatedArray {

    public static void main(String args[]) {
        final SortedRotatedArraySolver solver = new SortedRotatedArraySolver();
        //List<Integer> arr = Arrays.asList(11,12,2,3,5,8);
        //List<Integer> arr = Arrays.asList(2,3,5,8,11,12);
        List<Integer> arr = Arrays.asList(40342, 40766, 41307, 42639, 42777, 46079,
                47038, 47923, 48064, 48083, 49760, 49871, 51000, 51035, 53186, 53499,
                53895, 59118, 60467, 60498, 60764, 65158, 65838, 65885, 65919, 66638,
                66807, 66989, 67114, 68119, 68146, 68584, 69494, 70914, 72312, 72432,
                74536, 77038, 77720, 78590, 78769, 78894, 80169, 81717, 81760, 82124,
                82583, 82620, 82877, 83131, 84932, 85050, 85358, 89896, 90991, 91348,
                91376, 92786, 93626, 93688, 94972, 95064, 96240, 96308, 96755, 97197,
                97243, 98049, 98407, 98998, 99785, 350, 2563, 3075, 3161, 3519, 4176,
                4371, 5885, 6054, 6495, 7218, 7734, 9235, 11899, 13070, 14002, 16258,
                16309, 16461, 17338, 19141, 19526, 21256, 21507, 21945, 22753, 25029,
                25524, 27311, 27609, 28217, 30854, 32721, 33184, 34190, 35040, 35753,
                36144, 37342);
        int len=arr.size();
        int minIndex=solver.solve(arr, len);
        System.out.println(arr.get(minIndex));
    }
}

class SortedRotatedArraySolver{
    //returns the number of times the array is rotated
    public int solve(List<Integer> arr, int n){

        int low=0, high=n-1;
        while(low<=high) {
            //case 1: Array is already sorted, return the low
            if (arr.get(low)<arr.get(high))
                return low;

            //case 2: smallest element found, return the index of the smallest element
            /*
            - in a rotated sorted array, the smallest element holds a property, the next and the
                previous, both the adjacent elements to the smallest element are greater than the
                smallest element eg. look at 2 in (11,12,2,3,5,8)
            - to check whether we have spotted the smallest element or not, check the next and the
                prev element.
            - now the mid can point to the last element in array hence we take next =(mid+1+n)%n
                and mid can also point to first element in the array hence we take prev=(mid-1+n)%n;
                to avoid overflows
             */
            int mid=(low+high)/2;
            int next=(mid+1)%n;
            int prev=(mid-1+n)%n;
            if(arr.get(mid)<=arr.get(next) && arr.get(mid)<=arr.get(prev))
                return mid;

            //case 3: left sub array from mid is sorted, search only the right sub array
            else if(arr.get(low)<=arr.get(mid))
                low=mid+1;

            //case 4: right sub array from mid is sorted, search only left sub array
            else if(arr.get(mid)<=arr.get(high))
                high=mid-1;
        }
        return -1;

    }
}
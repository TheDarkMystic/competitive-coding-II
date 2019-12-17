package BinarySearch;

import java.util.Arrays;
import java.util.List;

public class RotatedArraySearch {
    public static void main(String args[]) {
        final RotatedArraySearchSolver solver = new RotatedArraySearchSolver();
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
        int minIndex=solver.solve(arr, len,350);
        //expected:71
        System.out.println(minIndex);
    }
}

class RotatedArraySearchSolver {
    public int solve(List<Integer> arr, int len, int x){
        int low=0, high=len-1;

        while(low<=high){
            int mid=(low+high)/2;
            //case 1: found the element at mid
            if(arr.get(mid)==x)
                return mid;
            //case 2: left sub array from mid is sorted and search in the right sub array
            else if(arr.get(low)<=arr.get(mid)){
                //case 2.1: x lies in the sorted half part
                if(x>arr.get(low) && x<arr.get(mid))
                    high=mid-1;
                else//case 2.2:search in unsorted half
                    low=mid+1;
            }

            //case 3: right sub array from mid is sorted and search in the left sub array
            else if(arr.get(mid)<=arr.get(high)){
                //case 3.1: x lies in the sorted half part
                if(x>arr.get(mid) && x<arr.get(high))
                    low=mid+1;
                else//case 3.2:search in unsorted half
                    high=mid-1;
            }

        }
        return -1;

    }
}
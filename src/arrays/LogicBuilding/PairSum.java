package arrays.LogicBuilding;

public class PairSum {
    public static int PairSum(int arr[],int target)
    {
        int PairCount=0;
        for(int i=0;i<arr.length;i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    PairCount++;
                }
            }
        }
        return PairCount;

    }
    public static void main(String[] args)
    {
        int arr[]={1,2,3,4,5,6,7,8,9};
        int target=9;
        System.out.println("this is the count of pairs:"+PairSum(arr,target));

    }
}

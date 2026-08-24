package arrays.LogicBuilding;

public class LargestElement {
    public static int maxValue(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];

            }
        }
        return max;
    }

    public static int secondMax(int arr[])
    {
        int second =maxValue(arr);
        for(int i=0;i< arr.length;i++)
        {
            if(arr[i]==second) {
                arr[i] = Integer.MIN_VALUE;
            }

    }
        int secondMax=maxValue(arr);
        return secondMax;


    }

    public static void main() {
        int arr[]={1,2,3,4,5,6,7};
        System.out.println("this is the Maximum Element:"+maxValue(arr));
        System.out.println(("this is the  second Maximum Element:"+secondMax(arr)));

    }

    }


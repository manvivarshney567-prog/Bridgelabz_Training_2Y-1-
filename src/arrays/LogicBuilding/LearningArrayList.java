package arrays.LogicBuilding;

import java.util.ArrayList;
import java.util.Arrays;

public class LearningArrayList {
    public static void main() {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(0,3);
        list.add(1,6);
        list.add(2,9);
        list.add(3,12);
        list.add(3,15);
        System.out.println("list the Array"+list);
        int nums[]=new int[5];
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=list.get(i);
            System.out.println("We have converted the ArrayList into Array:");
            System.out.println(Arrays.toString(nums));
        }

    }
}

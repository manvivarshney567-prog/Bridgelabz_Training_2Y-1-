package arrays.HashMap;

import java.util.HashMap;

public class Demomap {
    public static void main(String[] args) {

        HashMap<String, Integer> studentAges = new HashMap<>();

        studentAges.put("Rahul", 21);
        studentAges.put("Mayank", 22);
        studentAges.put("Ayush", 20);

        System.out.println("Ayush's age = " + studentAges.get("Ayush"));

        studentAges.put("Ayush", 21);

        boolean hasMayank = studentAges.containsKey("Mayank");
        boolean hasAge20 = studentAges.containsValue(20);

        System.out.println("Mayank present: " + hasMayank);
        System.out.println("Age 20 present: " + hasAge20);
    }
}
import java.nio.Buffer;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;


public class DCMaximum {

    public static int DCMaximum(int[] A, int left, int right) {
        int max;

        if (left == right) {
            max = A[1];
        }
        else if(left == right-1) {
            if (A[1] > A[right]) {
                max = A[1];

            }
            else {
                max = A[right];

            }
        }
        else
        {
            int m = (left + right)/ 2;
            System.out.println(" Left Point : " + left + " -> " + A[left]);
            System.out.println(" Mid Point : " + m + " -> " + A[m]);
            System.out.println(" Right Point : " + right+ " -> " + A[right] );





            int leftMax = DCMaximum(A, left, m);
            System.out.println("Left Max: " + leftMax);
            int rightMax = DCMaximum(A, m, right);
            System.out.println("Right Max: " + rightMax);




            if (rightMax > leftMax) {
                max = rightMax;
            }
            else {
                max = leftMax;

            }
            System.out.println("MAx:" + max);

            return max;

        }

        return max;

    }








    public static void main(String[] args) {
        //int arr[] = {1,128,155,17,202,256,45,5,56,98};


        // load data from file
        try {
            ArrayList<String> result = new ArrayList<>();


            File file = new File("number.txt");
            BufferedReader bf = new BufferedReader(new FileReader(file));


            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                while (br.ready()) {
                    result.add(br.readLine());
                }
                System.out.println(result);
            }




            String temp = " ";



            int[] intArray = new int[result.size()];
            bf.close();


            bf = new BufferedReader(new FileReader(file));
            int i = 0;
            while((temp = bf.readLine()) != null) {

                intArray[i] = Integer.valueOf(temp);
                System.out.println(intArray[i]);
                i++;

            }
            bf.close();

            DCMaximum(intArray, 0, intArray.length-1);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }



    }
}
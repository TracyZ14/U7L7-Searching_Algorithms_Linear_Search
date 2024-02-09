import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.ArrayList;
public class Advent2019Day2
{
    public static void main(String[] args)
    {
        File f = new File("src/intcode_data");
        Scanner s = null;
        try
        {
            s = new Scanner(f);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found.");
            System.exit(1);
        }

        String[] data = s.nextLine().split(",");
        ArrayList<Integer> operatorCodes = new ArrayList<Integer>();
        for(int i = 0; i < data.length; i++)
        {
            operatorCodes.add(Integer.parseInt(data[i]));
        }
        int index = 0;
        while(operatorCodes.get(index) != 99)
        {
            int firstOperand = operatorCodes.get(operatorCodes.get(index + 1));
            int secondOperand = operatorCodes.get(operatorCodes.get(index + 2));
            int resultIndex = operatorCodes.get(index + 3);
            if(operatorCodes.get(index) == 1)
            {
                operatorCodes.set(resultIndex, (firstOperand + secondOperand));
            }
            if(operatorCodes.get(index) == 2)
            {
                operatorCodes.set(resultIndex, (firstOperand * secondOperand));
            }
            index += 4;
        }
        System.out.println(operatorCodes);
    }
}
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class lab13
{
    private ArrayList<Integer> data;

    public void readData(String filename)
    {
        data = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename)))
        {
            while (scanner.hasNextInt())
            {
                data.add(scanner.nextInt());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + filename);
        }
    }

    public long getTotalCount()
    {
        return data.stream().count();
    }

    public long getOddCount()
    {
        return data.stream().filter(n -> n % 2 != 0).count();
    }

    public long getEvenCount()
    {
        return data.stream().filter(n -> n % 2 == 0).count();
    }

    public long getDistinctGreaterThanFiveCount()
    {
        return data.stream().filter(n -> n > 5).distinct().count();
    }

    public Integer[] getResult1()
    {
        return data.stream().filter(n -> n % 2 == 0 && n > 5 && n < 50).sorted().toArray(Integer[]::new);
    }

    public Integer[] getResult2()
    {
        return data.stream().map(n -> n * n * 3).limit(50).toArray(Integer[]::new);
    }

    public Integer[] getResult3()
    {
        return data.stream().filter(n -> n % 2 != 0).map(n -> n * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
    }
}

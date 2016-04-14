package util.generatoriCasuali;

/**
 * Creato da Vlady il 14/04/2016.
 * in origine parte del progetto:
 * CircoloTennis
 */
import java.lang.*;
import java.util.Random;

public class NumeroTraDue
{
    private static Random rnd;
    private static int[] values;
    private static int size;

    private NumeroTraDue (int min, int max, long seed)
    {
        init (min, max);
        rnd = new Random (seed);
    }

    private setup (int min, int max)
    {
        init (min, max);
        rnd = new Random ();
    }

    private void init (int min, int max)
    {
        if (min > max)
            throw new IllegalArgumentException ();

        size = max - min + 1;
        values = new int[size];

        for (int i = 0; i < size; i++)
            values[i] = min + i;
    }

    public static boolean hasValue ()
    {
        return size > 0;
    }

    public static int extract ()
    {
        if (size == 0)
            throw new IllegalStateException ();

        int idx = rnd.nextInt (size);
        int v = values[idx];

        values[idx] = values[--size];

        return v;
    }
}
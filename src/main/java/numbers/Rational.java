package numbers;

/**
 * Hello world!
 *
 */
public class Rational 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    private int numerator;
    private int denominator;

    public Rational() {
        numerator = 0;
        denominator = 1;
    }

    public Rational(int val) {
        numerator = val;
        denominator = 1;
    }

    public int getNumerator() {
        return numerator;
     }
     
     public int getDenominator() {
        return denominator;
     }
}

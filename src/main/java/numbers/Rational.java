package numbers;

/**
 * Hello world!
 *
 */
public class Rational 
{
    private int numerator;
    private int denominator;

    public Rational() {
        this(0, 1);
    }

    public Rational(int num) {
        this(num, 1);
    }

    public Rational(int num,int denom) {
        numerator = num;
        denominator = denom;
    }

    public int getNumerator() {
        return numerator;
     }
     
     public int getDenominator() {
        return denominator;
     }
}

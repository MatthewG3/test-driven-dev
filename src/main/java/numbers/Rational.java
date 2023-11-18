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
        numerator = 0;
        denominator = 1;
    }

    public Rational(int num) {
        numerator = num;
        denominator = 1;
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

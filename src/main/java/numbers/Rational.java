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
        if (denom == 0) {
            throw new IllegalArgumentException("Denominator value cannot be 0.");
        }
        numerator = num;
        denominator = denom;

        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }

        int gcd = findGCD(num, denom);

        if (gcd != 1) {
            numerator /= gcd;
            denominator /= gcd;
        }
    }

    public Rational(Rational obj) {
        this.numerator = obj.numerator;
        this.denominator = obj.denominator;
    }

    private int findGCD(int a, int b) {
        // Ensure both numbers are non-negative
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public int getNumerator() {
        return numerator;
    }
     
     public int getDenominator() {
        return denominator;
    }

    public Rational opposite() {
        int newNumerator = -1 * this.numerator;
        return new Rational(newNumerator, denominator);
    }

    public Rational reciprocal() {
        int newNumerator = denominator;
        int newDenominator = numerator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational times(Rational r) {
        int newNumerator = this.numerator * r.numerator;
        int newDenominator = this.denominator * r.denominator;
        return new Rational(newNumerator, newDenominator);
    }
}

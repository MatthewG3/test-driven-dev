package numbers;

/**
 * Hello world!
 *
 */
public class Rational extends Number implements Comparable<Number>
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

        int gcd = find_gcd(num, denom);

        if (gcd != 1) {
            numerator /= gcd;
            denominator /= gcd;
        }
    }

    public Rational(Rational obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot take null for Rational object in Constructor");
        }
        this.numerator = obj.numerator;
        this.denominator = obj.denominator;
    }

    private int find_gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public int numerator() {
        return numerator;
    }
     
     public int denominator() {
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
        if (r == null) {
            throw new IllegalArgumentException("Cannot take parameter value as null");
        }
        int newNumerator = this.numerator * r.numerator;
        int newDenominator = this.denominator * r.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational plus(Rational r) {
        if (r == null) {
            throw new IllegalArgumentException("Cannot take parameter value as null");
        }
        int newNumerator = (this.numerator * r.denominator) + (r.numerator * this.denominator);
        int newDenominator = (this.denominator * r.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    public Rational minus(Rational r) {
        if (r == null) {
            throw new IllegalArgumentException("Cannot take parameter value as null");
        }
        int newNumerator = (this.numerator * r.denominator) - (r.numerator * this.denominator);
        int newDenominator = (this.denominator * r.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    public Rational dividedBy(Rational r) {
        if (r == null) {
            throw new IllegalArgumentException("Cannot take parameter value as null");
        }
        if (r.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide Rational by value of 0.");
        }
        int newNumerator = this.numerator * r.denominator;
        int newDenominator = this.denominator * r.numerator;
        return new Rational(newNumerator, newDenominator);
    }

    private int pow(int val, int pow) {
        int res = 1;
        for (int i = 0; i < pow; i++) {
            res *= val;
        }
        return res;
    }

    public Rational raisedToThePowerOf(int n) {
        if (this.numerator == 0 && n < 0) {
            throw new IllegalArgumentException("Cannot raise Rational of value 0 to exponent that is negative.");
        }
        if (n < 0) {
            int newNumerator = pow(denominator, n * -1);
            int newDenominator = pow(numerator, n * -1);
            return new Rational(newNumerator, newDenominator);
        }
        int newNumerator = pow(numerator, n);
        int newDenominator = pow(denominator, n);
        return new Rational(newNumerator, newDenominator);
    }

    public boolean equals(Object o) {
        if (o instanceof Rational) {
            if (this.numerator == ((Rational)o).numerator() && this.denominator == ((Rational)o).denominator()) {
                return true;
            }
            return false;
        }
        else if (o instanceof java.lang.Number) {
            double val = (double) this.numerator / this.denominator;
            if (((java.lang.Number)o).doubleValue() == val) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean greaterThan(Rational r) {
        if (r == null) {
            throw new IllegalArgumentException("Cannot take parameter value as null");
        }
        int thisNum = (this.numerator * r.denominator);
        int rNum = (r.numerator * this.denominator);
        if (thisNum > rNum) {
            return true;
        }
        return false;
    }

    public boolean greaterThan(java.lang.Number n) {
        if (n == null) {
            throw new IllegalArgumentException("Cannot take parameter value as null");
        }
        double val = (double) this.numerator / this.denominator;
        if (val > ((java.lang.Number)n).doubleValue()) {
            return true;
        }
        return false;
    }

    public boolean lessThan(Rational r) {
        if (r == null) {
            throw new IllegalArgumentException("Cannot take parameter value as null");
        }
        int thisNum = (this.numerator * r.denominator);
        int rNum = (r.numerator * this.denominator);
        if (thisNum < rNum) {
            return true;
        }
        return false;
    }

    public boolean lessThan(java.lang.Number n) {
        if (n == null) {
            throw new IllegalArgumentException("Cannot take parameter value as null");
        }
        double val = (double) this.numerator / this.denominator;
        if (val < ((java.lang.Number)n).doubleValue()) {
            return true;
        }
        return false;
    }

    public boolean isZero() {
        if (this.numerator == 0) {
            return true;
        }
        return false;
    }

    public boolean isOne() {
        if (this.numerator == 1 && this.denominator == 1) {
            return true;
        }
        return false;
    }

    public boolean isMinusOne() {
        if (this.numerator == -1 && this.denominator == 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        if (denominator == 1) {
            return numerator + "";
        }
        return numerator + "/" + denominator;
    }

    @Override
    public int intValue() {
        return this.numerator / this.denominator;
    }

    @Override
    public double doubleValue() {
        return (double) this.numerator / this.denominator;
    }

    @Override
    public float floatValue() {
        return (float) this.numerator / this.denominator;
    }

    @Override
    public long longValue() {
        return (long) this.numerator / this.denominator;
    }

    @Override
    public int compareTo(Number n) {
        if (greaterThan(n)) {
            return 1;
        }
        else if (lessThan(n)) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

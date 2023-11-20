package numbers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThrows;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple Rational.
 */
public class RationalTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RationalTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( RationalTest.class );
    }

    /**
     * Test default constructor
     */
    public void test_defualt_constructor() {
        // When I create a default `Rational` value
        Rational value = new Rational();

        // Then the value should have numerator 0
        assertThat("the numerator should be 0", value.numerator(), is(0));

        // And the value should have denominator 1
        assertThat("the denominator should be 1", value.denominator(), is(1));
    }

    /**
     * Test constructor when passing through one integer
     */
    public void test_constructor_numerator_only() {
        // Given that I have constructed a `Rational` value using the argument `2`
        Rational value = new Rational(2);

        // Then the value should have numerator `2`
        assertThat("the numerator should be 2", value.numerator(), is(2));

        // And the value should have denominator `1`
        assertThat("the denominator should be 1", value.denominator(), is(1));
    }

    /**
     * Test constructor when passing through two integers
     */
    public void test_constructor_numerator_denominator() {
        // Given that I have constructed a `Rational` value using the argument `2` and `3`
        Rational value = new Rational(2, 3);

        // Then the value should have numerator `2`
        assertThat("the numerator should be 2", value.numerator(), is(2));

        // And the value should have denominator `3`
        assertThat("the denominator should be 3", value.denominator(), is(3));
    }

    /**
     * Test constructor when passing through two integers
     */
    public void test_constructor_numerator_denominator_simplify() {
        // Given I have created a `Rational` value using `48` and `-72`
        Rational value = new Rational(47, 72);

        // Then the value should have numerator `-2`
        assertThat("47 / 72 = 47 / 72", value.numerator(), is(47));

        // And the value should have denominator `3`
        assertThat("47 / 72 = 47 / 72", value.denominator(), is(72));
    }

    /**
     * Test constructor when passing through two integers
     */
    public void test_constructor_numerator_denominator_simplify_neg_denom() {
        // Given I have created a `Rational` value using `48` and `-72`
        Rational value = new Rational(48, -72);

        // Then the value should have numerator `-2`
        assertThat("48 / -72 = -2 / 3", value.numerator(), is(-2));

        // And the value should have denominator `3`
        assertThat("48 / -72 = -2 / 3", value.denominator(), is(3));
    }

    /**
     * Test constructor when passing through two integers
     */
    public void test_constructor_numerator_denominator_simplify_neg_num() {
        // Given I have created a `Rational` value using `48` and `-72`
        Rational value = new Rational(-48, 72);

        // Then the value should have numerator `-2`
        assertThat("-48 / 72 = -2 / 3", value.numerator(), is(-2));

        // And the value should have denominator `3`
        assertThat("-48 / 72 = -2 / 3", value.denominator(), is(3));
    }

    /**
     * Test constructor when passing through two integers
     */
    public void test_constructor_numerator_denominator_simplify_larger_neg_num() {
        // Given I have created a `Rational` value using `48` and `-72`
        Rational value = new Rational(-144, 72);

        // Then the value should have numerator `-2`
        assertThat("-144 / 72 = -2 / 1", value.numerator(), is(-2));

        // And the value should have denominator `3`
        assertThat("-144 / 72 = -2 / 1", value.denominator(), is(1));
    }

    /**
     * Test constructor when passing through two integers
     */
    public void test_constructor_numerator_denominator_simplify_equal() {
        // Given I have created a `Rational` value using `48` and `-72`
        Rational value = new Rational(12, 12);

        // Then the value should have numerator `-2`
        assertThat("12 / 12 = 1 / 1", value.numerator(), is(1));

        // And the value should have denominator `3`
        assertThat("12 / 12 = 1 / 1", value.denominator(), is(1));
    }

    /**
     * Test constructor when passing through 0 for denominator
     */
    public void test_constructor_numerator_denominator_num_is_zero() {
        // Given I have created a `Rational` value using `48` and `-72`
        Rational value = new Rational(0, 72);

        // Then the value should have numerator `-2`
        assertThat("0 / 72 = 0 / 1", value.numerator(), is(0));

        // And the value should have denominator `3`
        assertThat("0 / 72 = 0 / 1", value.denominator(), is(1));
    }

    /**
     * Test constructor when passing through 0 for denominator
     */
    public void test_constructor_numerator_denominator_denom_is_zero() {
        // And the value should have denominator throw error
        assertThrows(IllegalArgumentException.class, () -> new Rational(1, 0));
    }

    /**
     * Test copy constuctor
     */
    public void test_copy_constructor() {
        // Given that I have created the `Rational` value `2/3`
        Rational original = new Rational(2, 3);

        // When I create a `Rational` value as a copy of the original `Rational` value
        Rational value = new Rational(original);

        // Then the copy's value should have numerator 2
        assertThat("the numerator should be 2", value.numerator(), is(2));

        // And the copy's value should have denominator 3
        assertThat("the denominator should be 3", value.denominator(), is(3));
    }

    /**
     * Test copy constuctor
     */
    public void test_copy_constructor_null() {
        Rational r = null;

        assertThrows(IllegalArgumentException.class, () -> new Rational(r));
    }

    /**
     * Test for opposite when positive
     */
    public void test_opposite_positive() {
        Rational value = new Rational(2, 3);
        Rational opposite = value.opposite();
        assertThat("the opposite of 2 is -2", opposite.numerator(), is(-2));
        assertThat("the denominator should be 3", opposite.denominator(), is(3));
    }

    /**
     * Test for opposite when neg
     */
    public void test_opposite_negative() {
        Rational value = new Rational(-2, 3);
        Rational opposite = value.opposite();
        assertThat("the opposite of -2 is 2", opposite.numerator(), is(2));
        assertThat("the denominator should be 3", opposite.denominator(), is(3));
    }

    /**
     * Test for reciprocal
     */
    public void test_reciprocal_positive() {
        Rational value = new Rational(2, 3);
        Rational reciprocal = value.reciprocal();
        assertThat("the numerator should be 3", reciprocal.numerator(), is(3));
        assertThat("the denominator should be 2", reciprocal.denominator(), is(2));
    }

    /**
     * Test for reciprocal when negative
     */
    public void test_reciprocal_negative() {
        Rational value = new Rational(-2, 3);
        Rational reciprocal = value.reciprocal();
        assertThat("the numerator should be -3", reciprocal.numerator(), is(-3));
        assertThat("the denominator should be 2", reciprocal.denominator(), is(2));
    }

    /**
     * Test for when reciprocal creates a invalid value
     */
    public void test_reciprocal_invalid() {
        Rational value = new Rational(0);
        assertThrows(IllegalArgumentException.class, value::reciprocal);
    }

    /**
     * Test times function for two positive Rationals
     */
    public void test_times_both_positive() {
        Rational p = new Rational(2, 3);
        Rational q = new Rational(5, 7);
        Rational result = p.times(q);
        assertThat("2 * 5 = 10", result.numerator(), is(10));
        assertThat("3 * 7 = 21", result.denominator(), is(21));
    }

    /**
     * Test times function for one positive Rationals
     */
    public void test_times_one_negative() {
        Rational p = new Rational(2, 3);
        Rational q = new Rational(-5, 7);
        Rational result = p.times(q);
        assertThat("2 * -5 = -10", result.numerator(), is(-10));
        assertThat("3 * 7 = 21", result.denominator(), is(21));
    }

    /**
     * Test times function for two negative Rationals
     */
    public void test_times_two_negative() {
        Rational p = new Rational(-2, 3);
        Rational q = new Rational(-5, 7);
        Rational result = p.times(q);
        assertThat("-2 * -5 = 10", result.numerator(), is(10));
        assertThat("3 * 7 = 21", result.denominator(), is(21));
    }

    /**
     * Test times function for negative and 0 Rational
     */
    public void test_times_negative_and_zero() {
        Rational p = new Rational(-2, 3);
        Rational q = new Rational(0, 7);
        Rational result = p.times(q);
        assertThat("-2 * 0 = 0", result.numerator(), is(0));
        assertThat("3 * 7 = 21, but if numerator is 0 denom should be 1", result.denominator(), is(1));
    }

    /**
     * Test times function when null imput
     */
    public void test_times_null() {
        Rational p = new Rational(-2, 3);
        Rational q = null;
        assertThrows(IllegalArgumentException.class, () -> p.times(q));
    }

    /**
     * Test plus function for two positive numbers
     */
    public void test_plus_two_positive() {
        Rational p = new Rational(2, 3);
        Rational q = new Rational(5, 7);
        Rational result = p.plus(q);
        assertThat("2 / 3 + 5 / 7 = 29 / 21", result.numerator(), is(29));
        assertThat("2 / 3 + 5 / 7 = 29 / 21", result.denominator(), is(21));
    }

    /**
     * Test plus function for two positive numbers
     */
    public void test_plus_two_positive_simplify() {
        Rational p = new Rational(2, 3);
        Rational q = new Rational(1, 3);
        Rational result = p.plus(q);
        assertThat("2 / 3 + 1 / 3 = 3 / 3 = 1 / 1", result.numerator(), is(1));
        assertThat("2 / 3 + 1 / 3 = 3 / 3 = 1 / 1", result.denominator(), is(1));
    }

    /**
     * Test plus function for two negative numbers
     */
    public void test_plus_two_negative_simplify() {
        Rational p = new Rational(-2, 3);
        Rational q = new Rational(-1, 3);
        Rational result = p.plus(q);
        assertThat("-2 / 3 + -1 / 3 = -3 / 3 = -1 / 1", result.numerator(), is(-1));
        assertThat("-2 / 3 + -1 / 3 = -3 / 3 = -1 / 1", result.denominator(), is(1));
    }

    /**
     * Test plus function for one positive number
     */
    public void test_plus_one_positive() {
        Rational p = new Rational(2, 3);
        Rational q = new Rational(-5, 7);
        Rational result = p.plus(q);
        assertThat("2 / 3 + -5 / 7 = -1 / 21", result.numerator(), is(-1));
        assertThat("2 / 3 + -5 / 7 = -1 / 21", result.denominator(), is(21));
    }

    /**
     * Test plus function for one positive number and zero
     */
    public void test_plus_one_positive_and_zero() {
        Rational p = new Rational(2, 3);
        Rational q = new Rational();
        Rational result = p.plus(q);
        assertThat("2 / 3 + 0 / 1 = 2 / 3", result.numerator(), is(2));
        assertThat("2 / 3 + 0 / 1 = 2 / 3", result.denominator(), is(3));
    }

    /**
     * Test plus function for one number and its opposite
     */
    public void test_plus_one_positive_and_opposite() {
        Rational p = new Rational(2, 3);
        Rational q = p.opposite();
        Rational result = p.plus(q);
        assertThat("2 / 3 + -2 / 3 = 0 / 1", result.numerator(), is(0));
        assertThat("2 / 3 + -2 / 3 = 0 / 1", result.denominator(), is(1));
    }

    /**
     * Test plus function when null imput
     */
    public void test_plus_null() {
        Rational p = new Rational(-2, 3);
        Rational q = null;
        assertThrows(IllegalArgumentException.class, () -> p.plus(q));
    }

    /**
     * Test minus function for two positive numbers
     */
    public void test_minus_two_positive() {
        Rational p = new Rational(2, 3);
        Rational q = new Rational(5, 7);
        Rational result = p.minus(q);
        assertThat("2 / 3 - 5 / 7 = -1 / 21", result.numerator(), is(-1));
        assertThat("2 / 3 - 5 / 7 = -1 / 21", result.denominator(), is(21));
    }

    /**
     * Test minus function for one positive number
     */
    public void test_minus_one_positive() {
        Rational p = new Rational(2, 3);
        Rational q = new Rational(-5, 7);
        Rational result = p.minus(q);
        assertThat("2 / 3 - -5 / 7 = 29 / 21", result.numerator(), is(29));
        assertThat("2 / 3 - -5 / 7 = 29 / 21", result.denominator(), is(21));
    }

    /** 
     * Test minus function for two positives simplify
    */
    public void test_minus_two_positive_simplify() {
        Rational p = new Rational(4, 3);
        Rational q = new Rational(1, 3);
        Rational result = p.minus(q);
        assertThat("4 / 3 - 1 / 3 = 3 / 3 = 1 / 1", result.numerator(), is(1));
        assertThat("4 / 3 - 1 / 3 = 3 / 3 = 1 / 1", result.denominator(), is(1));
    }

    /** 
     * Test minus function for two negatives simplify
    */
    public void test_minus_two_negatives_simplify() {
        Rational p = new Rational(-4, 3);
        Rational q = new Rational(-1, 3);
        Rational result = p.minus(q);
        assertThat("-4 / 3 - -1 / 3 = -3 / 3 = -1 / 1", result.numerator(), is(-1));
        assertThat("-4 / 3 - -1 / 3 = -3 / 3 = -1 / 1", result.denominator(), is(1));
    }

    /** 
     * Test minus function for one positive and zero
    */
    public void test_minus_two_positive_and_zero() {
        Rational p = new Rational(4, 3);
        Rational q = new Rational();
        Rational result = p.minus(q);
        assertThat("4 / 3 - 0 / 1 = 4 / 3 = 4 / 3", result.numerator(), is(4));
        assertThat("4 / 3 - 0 / 1 = 4 / 3 = 4 / 3", result.denominator(), is(3));
    }

    /** 
     * Test minus function for rational minus itself
    */
    public void test_minus_itself() {
        Rational p = new Rational(4, 3);
        Rational q = new Rational(p);
        Rational result = p.minus(q);
        assertThat("4 / 3 - 4 / 3 = 0 / 3 = 0 / 1", result.numerator(), is(0));
        assertThat("4 / 3 - 4 / 3 = 0 / 3 = 0 / 1", result.denominator(), is(1));
    }

    /**
     * Test minus function when null imput
     */
    public void test_minus_null() {
        Rational p = new Rational(-2, 3);
        Rational q = null;
        assertThrows(IllegalArgumentException.class, () -> p.minus(q));
    }

    /**
     * Test divideBy function for two positive Rationals
     */
    public void test_divide_both_positive() {
        Rational p = new Rational(2, 3);
        Rational q = new Rational(5, 7);
        Rational result = p.dividedBy(q);
        assertThat("(2 / 3) / (5 / 7) = 2 / 3 * 7 / 5 = 14 / 15", result.numerator(), is(14));
        assertThat("(2 / 3) / (5 / 7) = 2 / 3 * 7 / 5 = 14 / 15", result.denominator(), is(15));
    }

    /**
     * Test divideBy function for one positive Rationals
     */
    public void test_divide_one_negative() {
        Rational p = new Rational(2, 3);
        Rational q = new Rational(-5, 7);
        Rational result = p.dividedBy(q);
        assertThat("(2 / 3) / (-5 / 7) = 2 / 3 * -7 / 5 = -14 / 15", result.numerator(), is(-14));
        assertThat("(2 / 3) / (-5 / 7) = 2 / 3 * -7 / 5 = -14 / 15", result.denominator(), is(15));
    }

    /**
     * Test divideBy function for two negative Rationals
     */
    public void test_divide_two_negative() {
        Rational p = new Rational(-2, 3);
        Rational q = new Rational(-5, 7);
        Rational result = p.dividedBy(q);
        assertThat("(-2 / 3) / (-5 / 7) = -2 / 3 * -7 / 5 = 14 / 15", result.numerator(), is(14));
        assertThat("(-2 / 3) / (-5 / 7) = -2 / 3 * -7 / 5 = 14 / 15", result.denominator(), is(15));
    }

    /**
     * Test divideBy function for negative and 0 Rational
     */
    public void test_divide_negative_and_zero() {
        Rational p = new Rational(-2, 3);
        Rational q = new Rational();
        assertThrows(IllegalArgumentException.class, () -> p.dividedBy(q));
    }

    /**
     * Test divideBy function for negative and 0 Rational when this is 0
     */
    public void test_divide_negative_and_zero_part2() {
        Rational p = new Rational();
        Rational q = new Rational(5, 7);
        Rational result = p.dividedBy(q);
        assertThat("(0 / 1) / (-5 / 7) = 0 / 1 * -7 / 5 = 0 / 1", result.numerator(), is(0));
        assertThat("(0 / 1) / (-5 / 7) = 0 / 1 * -7 / 5 = 0 / 1", result.denominator(), is(1));
    }

    /**
     * Test divide function when null imput
     */
    public void test_divide_null() {
        Rational p = new Rational(-2, 3);
        Rational q = null;
        assertThrows(IllegalArgumentException.class, () -> p.dividedBy(q));
    }

    /**
     * Test power function with positive n
     */
    public void test_power_positive() {
        Rational r = new Rational(5, 7);
        Rational result = r.raisedToThePowerOf(2);
        assertThat("(5 / 7)^2 = 25 / 49", result.numerator(), is(25));
        assertThat("(5 / 7)^2 = 25 / 49", result.denominator(), is(49));
    }
    /**
     * Test power function with negative n
     */
    public void test_power_negative() {
        Rational r = new Rational(5, 7);
        Rational result = r.raisedToThePowerOf(-2);
        assertThat("(5 / 7)^-2 = 49 / 25", result.numerator(), is(49));
        assertThat("(5 / 7)^-2 = 49 / 25", result.denominator(), is(25));
    }

    /**
     * Test power function with negative rational
     */
    public void test_power_rational_negative() {
        Rational r = new Rational(-2, 3);
        Rational result = r.raisedToThePowerOf(3);
        assertThat("(-2 / 3)^3 = -8 / 27", result.numerator(), is(-8));
        assertThat("(-2 / 3)^3 = -8 / 27", result.denominator(), is(27));
    }

    /**
     * Test power function with 0 
     */
    public void test_power_zero_positive_rational() {
        Rational r = new Rational(5, 7);
        Rational result = r.raisedToThePowerOf(0);
        assertThat("(5 / 7)^0 = 1 / 1", result.numerator(), is(1));
        assertThat("(5 / 7)^0 = 1 / 1", result.denominator(), is(1));
    }

    /**
     * Test power function with 0 
     */
    public void test_power_negative_rational_zero() {
        Rational r = new Rational();
        assertThrows(IllegalArgumentException.class, () -> r.raisedToThePowerOf(-2));
    }

    /**
     * Test for equals function
     */
    public void test_equals_rational_true() {
        Rational p = new Rational(2, 3);
        Rational q = new Rational(2, 3);
        assertThat("2 / 3 == 2 / 3", p.equals(q), is(true));
    }

    /**
     * Test for equals function
     */
    public void test_equals_rational_false() {
        Rational p = new Rational(2, 3);
        Rational q = new Rational(2, 5);
        assertThat("2 / 3 != 2 / 5", p.equals(q), is(false));
    }

    /**
     * Test for equals function
     */
    public void test_equals_number_true() {
        Rational p = new Rational(2, 1);
        Double q = new Double("2.0");
        assertThat("2 / 1 == 2 / 1", p.equals(q), is(true));
    }

    /**
     * Test for equals function
     */
    public void test_equals_number_true_decimal() {
        Rational p = new Rational(2, 3);
        double val = (double) 2 / 3;
        Double q = Double.valueOf(val);
        assertThat("2 / 3 == 0.6666", p.equals(q), is(true));
    }

    /**
     * Test for equals function
     */
    public void test_equals_number_false() {
        Rational p = new Rational(2, 3);
        Double q = new Double("2.146");
        assertThat("2 / 3 != 2.146", p.equals(q), is(false));
    }

    /**
     * Test for equals function
     */
    public void test_equals_not_rational_or_number() {
        Rational p = new Rational(2, 3);
        String s = "Hello world";
        assertThat("2 / 3 != string val", p.equals(s), is(false));
    }

    /**
     * Test for equals function
     */
    public void test_equals_null() {
        Rational p = new Rational(2, 3);
        Double o = null;
        assertThat("2 / 3 != null obj", p.equals(o), is(false));
    }

    /**
     * Test greaterThan function
     */
    public void test_greater_rational_true() {
        Rational p = new Rational(2, 3);
        Rational q = new Rational(1, 3);
        assertThat("2 / 3 > 1 / 3", p.greaterThan(q), is(true));
    }

    /**
     * Test greaterThan function
     */
    public void test_greater_rational_false() {
        Rational p = new Rational(1, 3);
        Rational q = new Rational(2, 3);
        assertThat("1 / 3 not > 2 / 3", p.greaterThan(q), is(false));
    }

    /**
     * Test greaterThan function
     */
    public void test_greater_number_true() {
        Rational p = new Rational(2, 3);
        Double q = new Double("0.2");
        assertThat("2 / 3 > 0.2", p.greaterThan(q), is(true));
    }

    /**
     * Test greaterThan function
     */
    public void test_greater_number_false() {
        Rational p = new Rational(1, 3);
        Double q = new Double("2.1");
        assertThat("1 / 3 not > 2.1", p.greaterThan(q), is(false));
    }

    /**
     * Test greaterThan function when null imput
     */
    public void test_greater_rational_null() {
        Rational p = new Rational(-2, 3);
        Rational q = null;
        assertThrows(IllegalArgumentException.class, () -> p.greaterThan(q));
    }

    /**
     * Test greaterThan function when null imput
     */
    public void test_greater_number_null() {
        Rational p = new Rational(-2, 3);
        Number q = null;
        assertThrows(IllegalArgumentException.class, () -> p.greaterThan(q));
    }


    /**
     * Test lessThan function
     */
    public void test_less_rational_true() {
        Rational p = new Rational(1, 3);
        Rational q = new Rational(2, 3);
        assertThat("1 / 3 < 2 / 3", p.lessThan(q), is(true));
    }

    /**
     * Test lessThan function
     */
    public void test_less_rational_false() {
        Rational p = new Rational(2, 3);
        Rational q = new Rational(1, 3);
        assertThat("2 / 3 not < 1 / 3", p.lessThan(q), is(false));
    }

    /**
     * Test lessThan function
     */
    public void test_less_number_true() {
        Rational p = new Rational(2, 3);
        Double q = new Double("1.2");
        assertThat("2 / 3 < 1.2", p.lessThan(q), is(true));
    }

    /**
     * Test lessThan function
     */
    public void test_less_number_false() {
        Rational p = new Rational(1, 3);
        Double q = new Double("0.1");
        assertThat("1 / 3 not < 0.1", p.lessThan(q), is(false));
    }

    /**
     * Test lessThan function when null imput
     */
    public void test_less_rational_null() {
        Rational p = new Rational(-2, 3);
        Rational q = null;
        assertThrows(IllegalArgumentException.class, () -> p.lessThan(q));
    }

     /**
     * Test lessThan function when null imput
     */
    public void test_less_number_null() {
        Rational p = new Rational(-2, 3);
        Number q = null;
        assertThrows(IllegalArgumentException.class, () -> p.lessThan(q));
    }

    /**
     * Test isZero function
     */
    public void test_iszero_true() {
        Rational r = new Rational();
        assertThat("0 / 1 == 0", r.isZero(), is(true));
    }

    /**
     * Test isZero function
     */
    public void test_iszero_false() {
        Rational r = new Rational(2, 1);
        assertThat("2 / 1 != 0", r.isZero(), is(false));
    }

    /**
     * Test isOne function
     */
    public void test_isone_true() {
        Rational r = new Rational(1);
        assertThat("1 / 1 == 1", r.isOne(), is(true));
    }

    /**
     * Test isOne function
     */
    public void test_isone_false() {
        Rational r = new Rational(2, 1);
        assertThat("2 / 1 != 1", r.isOne(), is(false));
    }

    /**
     * Test isMinusOne function
     */
    public void test_isminusone_true() {
        Rational r = new Rational(-1);
        assertThat("-1 / 1 == -1", r.isMinusOne(), is(true));
    }

    /**
     * Test isMinusOne function
     */
    public void test_isminusone_false() {
        Rational r = new Rational(2, 1);
        assertThat("2 / 1 != -1", r.isMinusOne(), is(false));
    }

    /**
     * Test toString function
     */
    public void test_toString() {
        Rational r = new Rational(2, 3);
        assertThat("2 / 3 should be '2/3'", r.toString(), is("2/3"));
    }

    /**
     * Test toString function
     */
    public void test_toString_with_negative() {
        Rational r = new Rational(-2, 3);
        assertThat("-2 / 3 should be '-2/3'", r.toString(), is("-2/3"));
    }

    /**
     * Test toString function
     */
    public void test_toString_when_int() {
        Rational r = new Rational(10);
        assertThat("10 / 1 should be '10'", r.toString(), is("10"));
    }

    /**
     * Test intValue override function
     */
    public void test_intval() {
        Rational r = new Rational(2, 3);
        assertThat("2 / 3 should be 0", r.intValue(), is(0));
    }

    /**
     * Test doubleValue override function
     */
    public void test_doubleval() {
        Rational r = new Rational(2, 3);
        double val = (double) r.numerator() / r.denominator();
        assertThat("2 / 3 should be 0.6666", r.doubleValue(), is(val));
    }

    /**
     * Test longValue override function
     */
    public void test_longval() {
        Rational r = new Rational(2, 3);
        long val = (long) r.numerator() / r.denominator();
        assertThat("2 / 3 should be 0.6666", r.longValue(), is(val));
    }

    /**
     * Test floatValue override function
     */
    public void test_floatval() {
        Rational r = new Rational(2, 3);
        float val = (float) r.numerator() / r.denominator();
        assertThat("2 / 3 should be 0.6666", r.floatValue(), is(val));
    }

    /**
     * Test compareTo function
     */
    public void test_compareto_greaterthan() {
        Rational p = new Rational(2, 3);
        double val = (double) 1 / 3;
        Double q = Double.valueOf(val);
        assertThat("2 / 3 > 0.333", p.compareTo(q), is(1));
    }

    /**
     * Test compareTo function
     */
    public void test_compareto_lessthan() {
        Rational p = new Rational(2, 3);
        double val = (double) 4 / 3;
        Double q = Double.valueOf(val);
        assertThat("2 / 3 > 1.3333", p.compareTo(q), is(-1));
    }

    /**
     * Test compareTo function
     */
    public void test_compareto_equalto() {
        Rational p = new Rational(2, 3);
        double val = (double) 2 / 3;
        Double q = Double.valueOf(val);
        assertThat("2 / 3 == 0.6666", p.compareTo(q), is(0));
    }
}

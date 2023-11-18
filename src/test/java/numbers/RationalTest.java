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
        assertThat("the numerator should be 0", value.getNumerator(), is(0));

        // And the value should have denominator 1
        assertThat("the denominator should be 1", value.getDenominator(), is(1));
    }

    /**
     * Test constructor when passing through one integer
     */
    public void test_constructor_numerator_only() {
        // Given that I have constructed a `Rational` value using the argument `2`
        Rational value = new Rational(2);

        // Then the value should have numerator `2`
        assertThat("the numerator should be 2", value.getNumerator(), is(2));

        // And the value should have denominator `1`
        assertThat("the denominator should be 1", value.getDenominator(), is(1));
    }

    /**
     * Test constructor when passing through two integers
     */
    public void test_constructor_numerator_denominator() {
        // Given that I have constructed a `Rational` value using the argument `2` and `3`
        Rational value = new Rational(2, 3);

        // Then the value should have numerator `2`
        assertThat("the numerator should be 2", value.getNumerator(), is(2));

        // And the value should have denominator `3`
        assertThat("the denominator should be 3", value.getDenominator(), is(3));
    }

    /**
     * Test constructor when passing through two integers
     */
    public void test_constructor_numerator_denominator_simplify() {
        // Given I have created a `Rational` value using `48` and `-72`
        Rational value = new Rational(47, 72);

        // Then the value should have numerator `-2`
        assertThat("47 / 72 = 47 / 72", value.getNumerator(), is(47));

        // And the value should have denominator `3`
        assertThat("47 / 72 = 47 / 72", value.getDenominator(), is(72));
    }

    /**
     * Test constructor when passing through two integers
     */
    public void test_constructor_numerator_denominator_simplify_neg_denom() {
        // Given I have created a `Rational` value using `48` and `-72`
        Rational value = new Rational(48, -72);

        // Then the value should have numerator `-2`
        assertThat("48 / -72 = -2 / 3", value.getNumerator(), is(-2));

        // And the value should have denominator `3`
        assertThat("48 / -72 = -2 / 3", value.getDenominator(), is(3));
    }

    /**
     * Test constructor when passing through two integers
     */
    public void test_constructor_numerator_denominator_simplify_neg_num() {
        // Given I have created a `Rational` value using `48` and `-72`
        Rational value = new Rational(-48, 72);

        // Then the value should have numerator `-2`
        assertThat("-48 / 72 = -2 / 3", value.getNumerator(), is(-2));

        // And the value should have denominator `3`
        assertThat("-48 / 72 = -2 / 3", value.getDenominator(), is(3));
    }

    /**
     * Test constructor when passing through two integers
     */
    public void test_constructor_numerator_denominator_simplify_larger_neg_num() {
        // Given I have created a `Rational` value using `48` and `-72`
        Rational value = new Rational(-144, 72);

        // Then the value should have numerator `-2`
        assertThat("-144 / 72 = -2 / 1", value.getNumerator(), is(-2));

        // And the value should have denominator `3`
        assertThat("-144 / 72 = -2 / 1", value.getDenominator(), is(1));
    }

    /**
     * Test constructor when passing through two integers
     */
    public void test_constructor_numerator_denominator_simplify_equal() {
        // Given I have created a `Rational` value using `48` and `-72`
        Rational value = new Rational(12, 12);

        // Then the value should have numerator `-2`
        assertThat("12 / 12 = 1 / 1", value.getNumerator(), is(1));

        // And the value should have denominator `3`
        assertThat("12 / 12 = 1 / 1", value.getDenominator(), is(1));
    }

    /**
     * Test constructor when passing through 0 for denominator
     */
    public void test_constructor_numerator_denominator_num_is_zero() {
        // Given I have created a `Rational` value using `48` and `-72`
        Rational value = new Rational(0, 72);

        // Then the value should have numerator `-2`
        assertThat("0 / 72 = 0 / 1", value.getNumerator(), is(0));

        // And the value should have denominator `3`
        assertThat("0 / 72 = 0 / 1", value.getDenominator(), is(1));
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
        assertThat("the numerator should be 2", value.getNumerator(), is(2));

        // And the copy's value should have denominator 3
        assertThat("the denominator should be 3", value.getDenominator(), is(3));
    }

    /**
     * Test for opposite when positive
     */
    public void test_opposite_positive() {
        Rational value = new Rational(2, 3);
        Rational opposite = value.opposite();
        assertThat("the opposite of 2 is -2", opposite.getNumerator(), is(-2));
        assertThat("the denominator should be 3", opposite.getDenominator(), is(3));
    }

    /**
     * Test for opposite when neg
     */
    public void test_opposite_negative() {
        Rational value = new Rational(-2, 3);
        Rational opposite = value.opposite();
        assertThat("the opposite of -2 is 2", opposite.getNumerator(), is(2));
        assertThat("the denominator should be 3", opposite.getDenominator(), is(3));
    }

    /**
     * Test for reciprocal
     */
    public void test_reciprocal_positive() {
        Rational value = new Rational(2, 3);
        Rational reciprocal = value.reciprocal();
        assertThat("the numerator should be 3", reciprocal.getNumerator(), is(3));
        assertThat("the denominator should be 2", reciprocal.getDenominator(), is(2));
    }

    /**
     * Test for reciprocal when negative
     */
    public void test_reciprocal_negative() {
        Rational value = new Rational(-2, 3);
        Rational reciprocal = value.reciprocal();
        assertThat("the numerator should be -3", reciprocal.getNumerator(), is(-3));
        assertThat("the denominator should be 2", reciprocal.getDenominator(), is(2));
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
        assertThat("2 * 5 = 10", result.getNumerator(), is(10));
        assertThat("3 * 7 = 21", result.getDenominator(), is(21));
    }

    /**
     * Test times function for one positive Rationals
     */
    public void test_times_one_negative() {
        Rational p = new Rational(2, 3);
        Rational q = new Rational(-5, 7);
        Rational result = p.times(q);
        assertThat("2 * -5 = -10", result.getNumerator(), is(-10));
        assertThat("3 * 7 = 21", result.getDenominator(), is(21));
    }

    /**
     * Test times function for two negative Rationals
     */
    public void test_times_two_negative() {
        Rational p = new Rational(-2, 3);
        Rational q = new Rational(-5, 7);
        Rational result = p.times(q);
        assertThat("-2 * -5 = 10", result.getNumerator(), is(10));
        assertThat("3 * 7 = 21", result.getDenominator(), is(21));
    }
    
}

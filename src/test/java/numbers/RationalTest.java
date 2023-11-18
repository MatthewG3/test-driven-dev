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
    // public void test_constructor_numerator_denominator_is_zero() {
    //     // Given that I have constructed a `Rational` value using the argument `2` and `3`
    //     Rational value = new Rational(2, 0);

    //     // And the value should have denominator throw error
    //     assertThrows()
    // }
    
}

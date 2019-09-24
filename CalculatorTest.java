package test.com.piggymetrics.auth;

import com.huawei.sq.Calculator;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Calculator Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>9月 24, 2019</pre>
 */
public class CalculatorTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: calculate(String str)
     */
    @Test
    public void testCalculate() throws Exception {
//TODO: Test goes here...
        assertEquals(Calculator.calculate("1+1"), 2);
        assertEquals(Calculator.calculate("3-1"), 2);
        assertEquals(Calculator.calculate("1*2"), 2);
        assertEquals(Calculator.calculate("4/2"), 2);
        assertEquals(Calculator.calculate("MAX(1,2)"), 2);
        assertEquals(Calculator.calculate("MIN(3,2)"), 2);
        assertEquals(Calculator.calculate("1+(4+5)/(1+3)+MAX(2,7)"), 10);
        assertEquals(Calculator.calculate("-1+2"), 1);

    }

    /**
     * Method: findOperOuterScope(String str, char oper)
     */
    @Test
    public void testFindOperOuterScope() throws Exception {
//TODO: Test goes here...
        int ret1 = Calculator.findOperOuterScope("11+22", '+');
        assertEquals(2, ret1);

        int ret2 = Calculator.findOperOuterScope("(11+22)+33", '+');
        assertEquals(7, ret2);
    }


} 

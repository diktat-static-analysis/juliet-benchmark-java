/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_Property_postdec_67b.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: Property Read data from a system property
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: decrement
 *    GoodSink: Ensure there will not be an underflow before decrementing data
 *    BadSink : Decrement data, which can cause an Underflow
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE191_Integer_Underflow.s04;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE191_Integer_Underflow__int_Property_postdec_67b
{
    public void badSink(CWE191_Integer_Underflow__int_Property_postdec_67a.Container dataContainer ) throws Throwable
    {
        int data = dataContainer.containerOne;

        /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
        data--;
        int result = (int)(data);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(CWE191_Integer_Underflow__int_Property_postdec_67a.Container dataContainer ) throws Throwable
    {
        int data = dataContainer.containerOne;

        /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
        data--;
        int result = (int)(data);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(CWE191_Integer_Underflow__int_Property_postdec_67a.Container dataContainer ) throws Throwable
    {
        int data = dataContainer.containerOne;

        /* FIX: Add a check to prevent an underflow from occurring */
        if (data > Integer.MIN_VALUE)
        {
            data--;
            int result = (int)(data);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too small to decrement.");
        }

    }
}

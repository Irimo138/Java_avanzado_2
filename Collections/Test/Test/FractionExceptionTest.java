package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

import Try_catch.FractionException;

public class FractionExceptionTest {
	 @Test
	    void test() {
	        FractionException fe = new FractionException("mensaje");
	        assertAll("Should create a new FractionException",
	                () -> assertTrue(fe instanceof Exception),
	                () -> assertEquals("mensaje", fe.getMessage())
	                );
	    }
}

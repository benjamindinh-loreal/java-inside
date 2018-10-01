package fr.umlv.javainside.labone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSum {

	@Test
	void test() {
		Sums sum = new Sums() ;
		assertEquals(3,sum.streamSum(2));
	}

}

package com.taxonic.rml.util;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;

import org.junit.Test;

import com.taxonic.rml.util.IriEncoder;

public class IriEncoderTest {

	private Function<String, String> encoder = IriEncoder.create();

	@Test
	public void variousTests() {

		test("hello there", "hello%20there");
		test("[test]", "%5btest%5d");
		test("", "");
		test("test-tester", "test-tester");
		test("test_tester", "test_tester");
		test("test.tester", "test.tester");
		test("~test", "~test");
		test("(test)", "%28test%29");
		test("http://example.com","http%3a%2f%2fexample.com");
		test("100%", "100%25");
		test("1,2", "1%2c2");
		test("葉篤正", "葉篤正");
	}
	
	private void test(String toEncode, String expectedResult) {
		String encoded = encode(toEncode);
		System.out.println(toEncode + " ==> " + encoded);
		assertEquals(expectedResult, encoded);
	}
	
	private String encode(String input) {
		return encoder.apply(input);
	}
	
}
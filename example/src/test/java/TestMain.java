package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.*;

public class TestMain {
	StringCRUD crud = new StringCRUD();

	@Test
	public void checkempty() {
		StringCRUD.testRequest = "Create  ";
		String actualProduct = crud.doStart();
		String expectedProduct = "String  invalid";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void CheckSingleSpaceInput() {
		StringCRUD.testRequest = "CREATE Hello";
		String actualProduct = crud.doStart();
		String expectedProduct = "String Hello created";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void CheckSerevalSpaceInput() {
		StringCRUD.testRequest = "CREATE                  ";
		String actualProduct = crud.doStart();
		String expectedProduct = "String  invalid";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void CheckSingleCharacterInput() {
		StringCRUD.testRequest = "CREATE c";
		String actualProduct = crud.doStart();
		String expectedProduct = "String c created";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void CheckMultipleSameLetterInput() {
		StringCRUD.testRequest = "CREATE ssssssssssssssssssssss";
		String actualProduct = crud.doStart();
		String expectedProduct = "String ssssssssssssssssssssss created";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void CheckTheSameCharacterInLowerAndUpperCasesMixedInTheInput() {
		StringCRUD.testRequest = "CREATE sSsssSssSssSssSssSss";
		String actualProduct = crud.doStart();
		String expectedProduct = "String sSsssSssSssSssSssSss created";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void CheckWordWithDifferentLetters() {
		StringCRUD.testRequest = "CREATE Hello world!";
		String actualProduct = crud.doStart();
		String expectedProduct = "String Hello created";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void CheckOnlySymbols() {
		StringCRUD.testRequest = "CREATE qqqqqqqq q q q q qq qq q ";
		String actualProduct = crud.doStart();
		String expectedProduct = "String qqqqqqqq created";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void checkSeveralWords() {
		StringCRUD.testRequest = "CREATE Hello how are you?";
		String actualProduct = crud.doStart();
		String expectedProduct = "String Hello created";
		assertEquals(expectedProduct, actualProduct);
	}

	@Test(expected = NullPointerException.class)
	public void CheckNull() {
		StringCRUD.testRequest = null;
		String actualProduct = crud.doStart();
	}
	@Test
	public void getByIndex() {
		StringCRUD.testRequest = "GET 5";
		String actualProduct = crud.doStart();
		String expectedProduct = "5-world!";
		assertEquals(expectedProduct, actualProduct);
	}
	@Test
	public void get() {
		StringCRUD.testRequest = "GET";
		String actualProduct = crud.doStart();
		String expectedProduct = "0-hello 1-my 2-dear 3-friend! 4-qqqqqqqq 5-world! 6-ssssssssssssssssssssss 7-Hello 8-sSsssSssSssSssSssSss";
		assertEquals(expectedProduct, actualProduct);
	}
	@Test
	public void updateByIndex() {
		StringCRUD.testRequest = "UPDATE 5 world!";
		String actualProduct = crud.doStart();
		String expectedProduct = "String with id = 5 updated";
		assertEquals(expectedProduct, actualProduct);
	}
	@Test
	public void delite() {
		StringCRUD.testRequest = "DELITE 5";
		String actualProduct = crud.doStart();
		String expectedProduct = "String by index 5 not found";
		assertEquals(expectedProduct, actualProduct);
	}
}

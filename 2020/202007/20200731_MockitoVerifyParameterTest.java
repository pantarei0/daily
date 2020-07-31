package test.support.exercise;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class MockitoVerifyParameterTest {

	private Testee mockedTestee;
	private Map<String, String> param;
	private Map<String, String> validator;

	@Before public void setUp() {
		
		mockedTestee = mock(Testee.class);

		param = new HashMap<>();
		param.put("id", "patnarei");
		param.put("level", "ADMIN");

		validator = new HashMap<>();
		validator.put("id", "patnarei");
		validator.put("level", "ADMIN");
	}

	@Test public void verify_동일한_객체면_내용이_달라도_성공() {
		//GIVEN
		mockedTestee.callMe(param); //WHEN

		param.put("level", "USER");
		param.put("foo", "bar");

		verify(mockedTestee).callMe(param); //THEN
	}

	@Test public void verify_동등한_객체면_성공() {
		//GIVEN
		mockedTestee.callMe(param); //WHEN
		
		assertTrue(param.equals(validator)); //THEN
		verify(mockedTestee).callMe(validator);
		verifyNoMoreInteractions(mockedTestee);
	}
	
	@Test public void verity_동등하지_않으면_호출안됨() {
		//GIVEN
		mockedTestee.callMe(param); //WHEN
		
		validator.put("level", "USER");
		
		assertThat(param, is(not(validator))); //THEN
		verify(mockedTestee, never()).callMe(validator);
//		verifyNoMoreInteractions(mockedTestee); //F
	}
}

interface Testee {
	boolean callMe(Map<String, String> param);
}

package com.employees.control;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tshirt.controller.TShirtStubController;
import com.tshirt.model.TShirt;
import com.tshirt.model.TShirt.Colour;

public class StubControllerTest {

	private TShirtStubController stubCont;
	private static List<TShirt> tshirtList;
	private TShirt tshirt;

	@Before
	public void BeforeTestMethod() {
		stubCont = new TShirtStubController();
		tshirt = new TShirt();
		tshirtList = new ArrayList<TShirt>();
	}

	@Test
	public void listAllTest() {
		tshirtList = stubCont.listAll();
		assertThat(tshirtList.get(0).getId(), is(1L));
		assertThat(tshirtList.get(1).getId(), is(2L));
		assertThat(tshirtList.get(2).getId(), is(3L));
		assertThat(tshirtList.get(3).getId(), is(4L));
	}

	@Test
	public void getTest() {
		tshirt = stubCont.get(1L);
		assertEquals(tshirt.getName(), "NBA");

		tshirt = stubCont.get(3L);
		assertEquals(tshirt.getName(), "FOOTBALL");
	}

	@Test
	public void createTest() {

		tshirt.setId(5L);
		tshirt.setName("SWIMMING");
		tshirt.setSize("S");
		tshirt.setPrice(55.00);
		tshirt.setImage("Default");

		stubCont.create(tshirt);
		tshirtList = stubCont.listAll();
		assertThat(tshirtList, hasSize(5));
	}

	@Test
	public void updateTest() {
		tshirt = stubCont.get(2L);
		tshirt.setName("New name");
		tshirt.setImage("New image");
		stubCont.update(2L, tshirt);

		assertThat(tshirt.getId(), is(2L));
		assertThat(tshirt.getName(), is("New name"));
		assertThat(tshirt.getSize(), is("XL"));
		assertThat(tshirt.getColour(), is(Colour.WHITE));
		assertThat(tshirt.getImage(), is("New image"));

		tshirtList = stubCont.listAll();
		assertThat(tshirtList, hasSize(4));

	}

	@Test
	public void deleteTest() {
		tshirtList = stubCont.listAll();
		stubCont.delete(1L);
		stubCont.delete(2L);
		tshirtList = stubCont.listAll();
		assertThat(tshirtList, hasSize(3));
	}

}

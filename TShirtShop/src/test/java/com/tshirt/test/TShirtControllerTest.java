package com.tshirt.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;

import com.tshirt.controller.TShirtController;
import com.tshirt.model.TShirt;
import com.tshirt.model.TShirt.Colour;
import com.tshirt.repository.TShirtRepository;

public class TShirtControllerTest {

	private static List<TShirt> tshirtList;
	TShirt tshirt, tshirt2, tshirt3;

	@InjectMocks
	private TShirtController tc;

	@Mock
	private TShirtRepository tshirtRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		tshirtList = new ArrayList<TShirt>();
		tshirt = new TShirt();
		tshirt2 = new TShirt();
		tshirt3 = new TShirt();
	}

	@Test
	public void listAllTest() {
		tshirt.setId(1L);
		tshirt.setId(2L);

		tshirtList.add(tshirt);
		tshirtList.add(tshirt2);

		// Testing repository
		when(tshirtRepository.findAll()).thenReturn(tshirtList);
		assertThat(tshirtList.size(), is(greaterThanOrEqualTo(0)));
		assertThat(tshirtList.size(), is(2));

		// Testing controller functionallity
		tshirtList = tc.listAll();
		verify(tshirtRepository).findAll();
		assertThat(tshirtList, is(tshirtRepository.findAll()));

	}

	@Test
	public void tshirtGetOneTest() {
		tshirt.setId(1L);

		// Testing repository
		when(tshirtRepository.findOne(1L)).thenReturn(tshirt);

		tshirt2 = tc.get(1L);
		// Testing controller functionallity
		verify(tshirtRepository).findOne(1L);
		assertThat(tshirt2.getId(), is(1L));

	}

	@Test
	public void tshirtCreateTest() {
		tshirt.setId(2L);
		tshirt.setName("New");
		tshirt.setSize("M");
		tshirt.setColour(Colour.BLACK);
		tshirt.setPrice(34.00);
		tshirt.setImage(null);

		// Testing repository
		when(tshirtRepository.saveAndFlush(tshirt)).thenReturn(tshirt);

		tshirtList.add(tshirt);
		tshirt2 = tc.create(tshirt);

		// Testing controller functionallity
		verify(tshirtRepository).saveAndFlush(tshirt);
		assertThat(tshirt2.getId(), is(2L));
		assertThat(tshirt2.getName(), is("New"));

	}

	@Test
	public void tshirtUpdateTest() {
		tshirt.setId(1L);
		tshirt.setName("NBA");
		tshirt.setSize("M");
		tshirt.setColour(Colour.BLACK);
		tshirt.setPrice(34.00);
		tshirt.setImage(null);

		// Testing repository
		when(tshirtRepository.findOne(1L)).thenReturn(tshirt);
		when(tshirtRepository.saveAndFlush(tshirt)).thenReturn(tshirt);

		tshirt2.setId(tshirt.getId());
		tshirt2.setName("NEW");
		tshirt2.setSize("S");
		tshirt2.setColour(Colour.WHITE);
		tshirt2.setPrice(40.00);
		tshirt2.setImage("images/default.jpg");

		// Testing controller functionallity
		tshirt = tc.update(1L, tshirt2);
		verify(tshirtRepository).findOne(1L);
		assertThat(tshirt.getId(), is(1L));
		assertThat(tshirt.getName(), is("NEW"));
		assertThat(tshirt.getSize(), is("S"));
		assertThat(tshirt.getColour(), is(Colour.WHITE));
		assertThat(tshirt.getPrice(), is(40.00));
		assertThat(tshirt.getImage(), is("images/default.jpg"));

	}

	@Test
	public void tshirtDeleteTest() {
		tshirt.setId(1L);
		tshirt.setName("NBA");
		tshirt.setSize("M");
		tshirt.setColour(Colour.BLACK);
		tshirt.setPrice(34.00);
		tshirt.setImage(null);

		tshirt2.setId(2L);
		tshirt2.setName("NFL");
		tshirt2.setSize("M");
		tshirt2.setColour(Colour.WHITE);
		tshirt2.setPrice(40.00);
		tshirt2.setImage(null);

		tshirt3.setId(2L);
		tshirt3.setName("NFL");
		tshirt3.setSize("M");
		tshirt3.setColour(Colour.WHITE);
		tshirt3.setPrice(40.00);
		tshirt3.setImage(null);

		tshirtList.add(tshirt);
		tshirtList.add(tshirt2);
		tshirtList.add(tshirt3);
		
		// Testing repository
		when(tshirtRepository.saveAndFlush(tshirt)).thenReturn(tshirt);
		when(tshirtRepository.saveAndFlush(tshirt2)).thenReturn(tshirt2);
		when(tshirtRepository.saveAndFlush(tshirt3)).thenReturn(tshirt3);
		when(tshirtRepository.findAll()).thenReturn(tshirtList);
		when(tshirtRepository.findOne(tshirt.getId())).thenReturn(tshirt);
		when(tshirtRepository.findOne(tshirt2.getId())).thenReturn(tshirt2);
		when(tshirtRepository.findOne(tshirt3.getId())).thenReturn(tshirt3);

		// Testing the controller
		tshirtList.remove(tc.delete(1L));
		tshirtList = tc.listAll();
		verify(tshirtRepository).findAll();
		assertThat(tshirtList.size(), is(2));

	}
}

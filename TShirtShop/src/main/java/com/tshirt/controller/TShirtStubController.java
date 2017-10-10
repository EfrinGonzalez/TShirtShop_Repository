package com.tshirt.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tshirt.model.TShirt;

@RestController
@RequestMapping("api/shop/")
public class TShirtStubController {

	@RequestMapping(value="tshirts", method = RequestMethod.GET)
	public List<TShirt> listAll(){
		return TShirtStub.listAll();
	}
	
	@RequestMapping(value = "tshirts/{id}", method = RequestMethod.GET)
	public TShirt get(@PathVariable Long id) {
		return TShirtStub.getOne(id);
	}
	@RequestMapping(value = "tshirts", method = RequestMethod.POST)
	public TShirt create(@RequestBody TShirt tshirt) {
		return TShirtStub.create(tshirt);
	}
	

	@RequestMapping(value = "tshirts/{id}", method = RequestMethod.PUT)
	public TShirt update(@PathVariable Long id, @RequestBody TShirt tshirt) {
		return TShirtStub.update(id, tshirt);
	}
	
	@RequestMapping(value = "tshirts/{id}", method = RequestMethod.DELETE)
	public TShirt delete(@PathVariable Long id) {
		return TShirtStub.delete(id);
	}

	
}


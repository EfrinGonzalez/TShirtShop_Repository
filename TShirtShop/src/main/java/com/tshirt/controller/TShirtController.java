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
public class TShirtController {

	@RequestMapping(value="tshirts", method = RequestMethod.GET)
	public List<TShirt> listAll(){
		return TShirtStub.listAll();
	}
	
	@RequestMapping(value = "tshirts/{id}", method = RequestMethod.GET)
	public TShirt get(@PathVariable Long id) {
		return TShirtStub.getOne(id);
	}
	/*@RequestMapping(value = "tshirts", method = RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
		return shipwreckRepository.saveAndFlush(shipwreck);
	}

	@RequestMapping(value = "tshirts/{id}", method = RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id) {
		return shipwreckRepository.findOne(id);
	}

	@RequestMapping(value = "tshirts/{id}", method = RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
		Shipwreck existingShipwreck = shipwreckRepository.findOne(id);
		BeanUtils.copyProperties(shipwreck, existingShipwreck);
		return shipwreckRepository.saveAndFlush(existingShipwreck);
	}

	@RequestMapping(value = "tshirts/{id}", method = RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id) {
		Shipwreck existingShipwreck = shipwreckRepository.findOne(id);
		shipwreckRepository.delete(existingShipwreck);
		return existingShipwreck;
	}
*/
	
}


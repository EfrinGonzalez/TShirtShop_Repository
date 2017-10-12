package com.tshirt.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tshirt.model.TShirt;
import com.tshirt.repository.TShirtRepository;

@RestController
@RequestMapping("api/shop/")
public class TShirtController {

	@Autowired
	private TShirtRepository tshirtRepository;
	
	@RequestMapping(value="tshirts", method = RequestMethod.GET)
	public List<TShirt> listAll(){
		return tshirtRepository.findAll();
	}
	
	@RequestMapping(value = "tshirts/{id}", method = RequestMethod.GET)
	public TShirt get(@PathVariable Long id) {
		return tshirtRepository.findOne(id);
	}
	@RequestMapping(value = "tshirts", method = RequestMethod.POST)
	public TShirt create(@RequestBody TShirt tshirt) {
		return tshirtRepository.saveAndFlush(tshirt);
	}
	

	@RequestMapping(value = "tshirts/{id}", method = RequestMethod.PUT)
	public TShirt update(@PathVariable Long id, @RequestBody TShirt tshirt) {
		TShirt existingTShirt = tshirtRepository.findOne(id);
		BeanUtils.copyProperties(tshirt, existingTShirt );
		return tshirtRepository.saveAndFlush(existingTShirt);
	}
	
	@RequestMapping(value = "tshirts/{id}", method = RequestMethod.DELETE)
	public TShirt delete(@PathVariable Long id) {
		TShirt existingTShirt = tshirtRepository.findOne(id);
		tshirtRepository.delete(existingTShirt);
		return existingTShirt;
	
	}

	
}


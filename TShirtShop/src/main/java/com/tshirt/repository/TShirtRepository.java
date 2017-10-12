package com.tshirt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tshirt.model.TShirt;

//The JpaRepository It takes the model object and its primary key
public interface TShirtRepository extends JpaRepository<TShirt, Long> {
	
}

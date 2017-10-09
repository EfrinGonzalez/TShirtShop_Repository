package com.tshirt.controller;

import java.util.ArrayList;
import java.util.List;

import com.tshirt.model.TShirt;
import com.tshirt.model.TShirt.Colour;

public class TShirtStub {
	
	public TShirtStub(){}
	
	static List<TShirt> tshirtList;
	
	
	static{
		tshirtList = new ArrayList<TShirt>();
		TShirt t1 = new TShirt(1L, "NBA", "XXL", Colour.BLACK, 34.00, "Default" );
		tshirtList.add(t1);
		TShirt t2 = new TShirt(2L, "NFL", "XL", Colour.WHITE, 34.00, "Default" );
		tshirtList.add(t2);
		TShirt t3 = new TShirt(3L, "FOOTBALL", "M", Colour.GREEN, 34.00, "Default" );
		tshirtList.add(t3);
		TShirt t4 = new TShirt(4L, "CLIMBING", "XXL", Colour.YELLOW, 34.00, "Default" );
		tshirtList.add(t4);
		
		
	}
	
	public static List<TShirt> listAll(){		
		return tshirtList;
	}
	
	public static TShirt getOne(Long id){
		Integer index = (int) (long) id;
		if (index >= 1){
			return tshirtList.get(index-1);//-1 due to index starts from cero in List
		}return null;
		
		}
	

}

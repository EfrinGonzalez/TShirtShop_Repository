package com.tshirt.controller;

import java.util.ArrayList;
import java.util.List;

import com.tshirt.model.TShirt;
import com.tshirt.model.TShirt.Colour;

public class TShirtStub {
	
	public TShirtStub(){}
	
	private static List<TShirt> tshirtList;
	//private static Long idIndex = 3L;
	
	
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
	
	
	
	public static TShirt create(TShirt tshirt){
		tshirt.setId(tshirtList.size()+1L);
		tshirtList.add(tshirt);
		return tshirt;		
	}
	
	public static TShirt getOne(Long id){
		Integer index = (int) (long) id;
		if (index >= 1){
			return tshirtList.get(index-1);//-1 due to index starts from cero in List
		}return null;
		
	}
	
	public static TShirt update(Long id, TShirt tshirt){
		Integer index = (int) (long) id;
		//tshirtList.get(index - 1).set;
		tshirtList.set(index -1, tshirt);
		return tshirtList.get(index-1); 
		
	}
	
	public static TShirt delete(Long id){
		Integer index = (int) (long) id;
		return tshirtList.remove(index - 1);
		
	}

}

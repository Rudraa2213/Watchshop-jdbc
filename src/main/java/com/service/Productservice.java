package com.service;

import java.util.ArrayList;

import com.model.Productmodel;

public interface Productservice {
	
	int Insert(Productmodel pm);
	
	ArrayList<Productmodel> fetchalldata();
	
	ArrayList<Productmodel> fetchdata();
	
	int updaterecord(Productmodel um);
	
	boolean delete(int sno);
}

package com.favorites.dataAccess.dao;

import java.util.List;

import com.favorites.dataAccess.entity.Restaurant;

/**
 * Data object Access interface to get all the restaurants
 * @author rnithoo
 *
 */
public interface RestaurantDaoInterface {

	/**
	 * Adds a restaurant in the database
	 * @param restaurant
	 * @return
	 */
	public Restaurant addRestaurant(Restaurant restaurant);
	
	/**
	 * 
	 * @param id
	 * @return a restaurant identified by id
	 */
	public Restaurant getRestaurantbyId(String id);
	
	/**
	 * 
	 * @return all restaurants in the data base
	 */
	public List<Restaurant> getAllRestaurants();
	
}

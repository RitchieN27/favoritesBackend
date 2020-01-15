package com.favorites.dataAccess.service;

import java.util.List;

import com.favorites.dataAccess.entity.Restaurant;

public interface RestaurantServiceInterface {

	/**
	 * Adds a restaurant in the database
	 * @param restaurant
	 * @return
	 */
	public Restaurant addRestaurant(String name,String address, int rating);
	
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
	
	/**
	 * Delete a restaurant matching the id param
	 * @param id
	 * @return
	 */
	public boolean deleteRestaurant(String id);
	
	/**
	 * Updates the restaurant matching the id param
	 * @param id
	 * @param name
	 * @param address
	 * @param rating
	 * @return
	 */
	public Restaurant updateRestaurant(Restaurant restaurant);
	
}

package com.favorites.dataAccess.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.favorites.dataAccess.dao.RestaurantDaoInterface;
import com.favorites.dataAccess.entity.Restaurant;

@Service("restaurantService")
public class RestaurantService implements RestaurantServiceInterface {

	/**
	 * Default constructor for Spring
	 */
	public RestaurantService() {
	}
	
	@Autowired(required=true)
	@Qualifier("restaurantDao")
	private RestaurantDaoInterface restaurantDAO;
	
	@Override
	public Restaurant addRestaurant(String name,String address, int rating) {
		Restaurant restaurant = new Restaurant();
		restaurant.setName(name);
		restaurant.setAddress(address);
		restaurant.setRating(rating);
		return restaurantDAO.addRestaurant(restaurant);
	}
	
	@Override
	public Restaurant getRestaurantbyId(String id) {
		return restaurantDAO.getRestaurantbyId(id);
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		return restaurantDAO.getAllRestaurants();
	}

	@Override
	public boolean deleteRestaurant(String id) {
		return restaurantDAO.deleteRestaurant(id);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {
		return restaurantDAO.updateRestaurant(restaurant);
	}

}

package com.favorites.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.favorites.dataAccess.entity.Restaurant;
import com.favorites.dataAccess.service.RestaurantServiceInterface;

@Component
@Path("/restaurant")
public class RestServiceRestaurant {
	
	@Autowired(required = true)
	@Qualifier("restaurantService")
	private RestaurantServiceInterface restaurantService;
	
	/**
	 * Default constructor for Spring
	 */
	public RestServiceRestaurant() {
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createRestaurant")
	public Response createRestaurant(Restaurant restaurant) {
		Restaurant createdRestaurant = restaurantService.addRestaurant(restaurant.getName(), restaurant.getAddress(),restaurant.getRating());
		return Response.status(201).entity(createdRestaurant).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getRestaurant/{restaurantId}")
	public Restaurant getRestaurant(@PathParam("restaurantId") String restaurantId) {
		return restaurantService.getRestaurantbyId(restaurantId);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllRestaurants")
	public List<Restaurant> getAllRestaurant() {
		return restaurantService.getAllRestaurants();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateRestaurant")
	public Restaurant updateRestaurant(Restaurant restaurant) {
		return restaurantService.updateRestaurant(restaurant);
	}
	
	@DELETE
	@Path("/deleteRestaurant/{restaurantId}")
	public boolean deleteRestaurant(@PathParam("restaurantId") String restaurantId) {
		return restaurantService.deleteRestaurant(restaurantId);
	}
	
}
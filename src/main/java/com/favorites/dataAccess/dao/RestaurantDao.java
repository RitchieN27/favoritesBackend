package com.favorites.dataAccess.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.favorites.dataAccess.entity.Restaurant;

@Repository("restaurantDao")
@EnableTransactionManagement
public class RestaurantDao implements RestaurantDaoInterface {

	/**
	 * Default constructor for Spring
	 */
	public RestaurantDao() {
	}
	
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Restaurant addRestaurant(Restaurant restaurant) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(restaurant);
		return restaurant;
		
	}
	
	@Override
	@Transactional
	public Restaurant getRestaurantbyId(String restaurantId) {
		
		Session session = sessionFactory.getCurrentSession();
		return session.get(Restaurant.class, Integer.valueOf(restaurantId));
		
	}

	@Override
	@Transactional
	public List<Restaurant> getAllRestaurants() {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Restaurant> criteria = builder.createQuery(Restaurant.class);
		criteria.from(Restaurant.class);
		return session.createQuery(criteria).getResultList();
		
	}

	@Override
	@Transactional
	public boolean deleteRestaurant(String restaurantId) {
		
		Session session = sessionFactory.getCurrentSession();
		Restaurant entity = session.get(Restaurant.class,Integer.valueOf(restaurantId));
		if (entity != null) {
			session.delete(entity);
			return true;
		}
		return false;
		
	}

	@Override
	@Transactional
	public Restaurant updateRestaurant(Restaurant restaurant) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(restaurant);
		return restaurant;
		
	}

}

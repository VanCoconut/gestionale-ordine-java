package com.lipari.app.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.lipari.app.exception.DataException;
import com.lipari.app.model.dao.AddressDao;
import com.lipari.app.model.dao.BasketDao;
import com.lipari.app.model.dao.OrderDao;
import com.lipari.app.model.dao.ProductDao;
import com.lipari.app.model.dao.UserDao;
import com.lipari.app.model.vo.Basket;
import com.lipari.app.model.vo.Order;
import com.lipari.app.model.vo.Product;

public class OrderController {

	private final OrderDao orderDao = new OrderDao();
	private final UserDao userDao = new UserDao();
	private final ProductDao productDao = new ProductDao();
	private final AddressDao addressDao = new AddressDao();
	private final BasketDao basketDao = new BasketDao();
	
	

	
	

	public List<Order> retrieveAllOrders(int userId) {

		try {
			return orderDao.getAllOrders(userId);
		} catch (DataException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Product> retrieveAllProduct() {

		try {
			return productDao.getAllProduct();
		} catch (DataException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Map<Integer, String> retrieveBasketXOrder(String orderId) {
		Map<Integer, String> m = new HashMap<>();
		Map<Integer, Integer> m1 = new HashMap<>();
		try {
			m1 = basketDao.getBasket(orderId).stream().collect(Collectors.toMap(Basket::getQuantita, Basket::getProductId));
			Iterator<Map.Entry<Integer, Integer>> iterator = m1.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Integer> entry = iterator.next();
				m.put(entry.getKey(), productDao.getProduct(entry.getValue()).getDescrizione());
			}
			return m;
		} catch (DataException e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean addProduct(String orderId, int productId, int qta) {

		try {
			return basketDao.setBasket(orderId, productId, qta);
		} catch (DataException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean addOrder(String orderId, int userId, LocalDate data, String indirizzo) {

		try {
			return orderDao.setOrder(orderId, userId, data, indirizzo);
		} catch (DataException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean deleteOrder(String orderId) {

		try {
			return orderDao.deleteOrder(orderId);
		} catch (DataException e) {
			e.printStackTrace();
		}
		return false;

	}

	public Product findProduct(int productId) {

		try {
			return productDao.getProduct(productId);
		} catch (DataException e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean findAddress(int userId, String indirizzo) {

		try {
			return addressDao.getAllAddress(userId).stream().filter(e -> e.equalsIgnoreCase(indirizzo)).toList().isEmpty();
		} catch (DataException e) {
			e.printStackTrace();
		}

		return false;
	}
}

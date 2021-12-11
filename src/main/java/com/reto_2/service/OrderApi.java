package com.reto_2.service;

import com.reto_2.model.Order;
import com.reto_2.model.User;
import com.reto_2.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Alexander Sánchez Osorio
 */
@Service
public class OrderApi {

    private OrderRepository orderRepository;

    public OrderApi(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Metodo para traer todas las ordenes
     * @return
     */
    public List<Order> getAll(){
        return orderRepository.getAll();
    }

    /**
     * Metodo para traer una orden por Id
     * @param id
     * @return
     */
    public Optional getOrderById(int id){
        return orderRepository.getOrderById(id);
    }

        /**
     * Metodo para obtener las zonas
     * @param zona
     * @return
     */
    public List<Order> getOrderByZone(String zona){
        return orderRepository.getOrderByZone(zona);
    }

    /**
     * Metodo para obtener el estado de una orden
     * @param status
     * @return
     */
    public List<Order> getOrderByStatus(String status){
        return orderRepository.getOrderByStatus(status);
    }

    /**
     * Metodo para guardar una orden
     * @param order
     * @return
     */
    public Order save(Order order){

        List<Order> orders = orderRepository.getAll();
        Integer idAuto = orders.size();
        idAuto++;
        Optional<Order> exist = orderRepository.getOrderById(idAuto);
        if (exist.isPresent()){
            return order;
        }
        if (order.getId() == null){
            order.setId(idAuto);
        }

        if(order.getId() == null){
            return orderRepository.save(order);
        }else{
            Optional<Order> existOrder = orderRepository.getOrderById(order.getId());
            if(existOrder.isPresent()){
                return order;
            }else {
                return orderRepository.save(order);
            }
        }
    }

    /**
     * Metodo para actualizar el estado de una orden
     * @param order
     * @return
     */
    public Order orderUpdate(Order order){
        Optional<Order> exist = orderRepository.getOrderById(order.getId());
        if(exist.isPresent()) {
            if (order.getRegisterDay() != null) {
                exist.get().setRegisterDay(order.getRegisterDay());
            }
            if (order.getStatus() != null) {
                exist.get().setStatus(order.getStatus());
            }
            if (order.getSalesMan() != null) {
                exist.get().setSalesMan(order.getSalesMan());
            }
            if (order.getProducts() != null) {
                exist.get().setProducts(order.getProducts());
            }
            if (order.getQuantities() != null) {
                exist.get().setQuantities(order.getQuantities());
            }
            return orderRepository.save(exist.get());
        }
        return order;
    }

    /**
     * Metodo para borrar una orden por id
     * @param idOrder
     */
    public void deleteById (Integer idOrder){
        Optional<Order> order = orderRepository.getOrderById(idOrder);
        if(order.isPresent()){
            orderRepository.deleteById(idOrder);
        }
    }
}

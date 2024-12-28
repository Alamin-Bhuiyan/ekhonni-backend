package  com.ekhonni.backend.service;

import com.ekhonni.backend.model.Order;
import com.ekhonni.backend.respository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order create(Order newOrder) {
        return orderRepository.save(new Order(
                newOrder.getFirstName(),
                newOrder.getLastName(),
                newOrder.getCompanyName(),
                newOrder.getStreetAddress(),
                newOrder.getPhone(),
                newOrder.getNotes(),
                newOrder.getPaymentMethod(),
                newOrder.getSubTotal(),
                newOrder.getTransactionId()
        ));
    }

    public Order update(Long id, Order updatedOrder) {
        return orderRepository.findById(id).map(
            order -> {
                order.setFirstName(updatedOrder.getFirstName());
                order.setLastName(updatedOrder.getLastName());
                order.setCompanyName(updatedOrder.getCompanyName());
                order.setStreetAddress(updatedOrder.getStreetAddress());
                order.setPhone(updatedOrder.getPhone());
                order.setNotes(updatedOrder.getNotes());
                order.setPaymentMethod(updatedOrder.getPaymentMethod());
                order.setSubTotal(updatedOrder.getSubTotal());
                return orderRepository.save(order);
            }
        ).orElse(null);
    }

    public String deleteById(Long id) {
        orderRepository.deleteById(id);
        return "Deleted Successfully";
    }
}

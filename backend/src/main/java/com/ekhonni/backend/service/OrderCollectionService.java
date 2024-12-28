package  com.ekhonni.backend.service;

import com.ekhonni.backend.model.OrderCollection;
import com.ekhonni.backend.respository.FoodRepository;
import com.ekhonni.backend.respository.OrderCollectionRepository;
import  com.ekhonni.backend.respository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCollectionService {
    private final OrderCollectionRepository orderCollectionRepository;
    private final FoodRepository foodRepository;
    private final OrderRepository orderRepository;

    public OrderCollectionService(OrderCollectionRepository orderCollectionRepository, FoodRepository foodRepository, OrderRepository orderRepository) {
        this.orderCollectionRepository = orderCollectionRepository;
        this.foodRepository = foodRepository;
        this.orderRepository = orderRepository;
    }

    public List<OrderCollection> findAll() {
        return orderCollectionRepository.findAll();
    }

    public OrderCollection findById(Long id) {
        return orderCollectionRepository.findById(id).orElse(null);
    }

    public OrderCollection create(OrderCollection newOrderCollection) {
        return foodRepository.findById(newOrderCollection.getFood().getId()).flatMap(
                food ->
                orderRepository.findById(newOrderCollection.getOrder().getId()).map(
                    order -> orderCollectionRepository.save(new OrderCollection(
                            newOrderCollection.getQuantity(),
                            order,
                            food
                    ))
                )).orElse(null);

    }

    public OrderCollection update(Long id, OrderCollection updatedOrderCollection) {
        return orderCollectionRepository.findById(id).flatMap(
            orderCollection -> foodRepository.findById(updatedOrderCollection.getFood().getId()).flatMap(
                food -> orderRepository.findById(updatedOrderCollection.getFood().getId()).map(
                     order -> {
                         orderCollection.setQuantity(updatedOrderCollection.getQuantity());
                         orderCollection.setOrder(order);
                         orderCollection.setFood(food);
                         return orderCollectionRepository.save(orderCollection);
                     }
                ))).orElse(null);
    }

    public String deleteById(Long id) {
        orderCollectionRepository.deleteById(id);
        return "Deleted Successfully";
    }
}

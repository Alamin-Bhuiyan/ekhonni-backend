package  com.ekhonni.backend.controller;

import com.ekhonni.backend.model.Order;
import com.ekhonni.backend.service.OrderService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Transactional
@RestController
@RequestMapping("api/v1/orders/")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("{id}/")
    public Order findById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @ResponseBody @PostMapping
    public Order create(@Valid @RequestBody Order order){
        return orderService.create(order);
    }

    @ResponseBody @PutMapping("{id}/")
    public Order update(@PathVariable Long id, @Valid @RequestBody Order order){
        return orderService.update(id, order);
    }

    @DeleteMapping("{id}/")
    public String delete(@PathVariable Long id) {
        return orderService.deleteById(id);
    }
}

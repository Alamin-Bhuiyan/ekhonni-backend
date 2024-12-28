package  com.ekhonni.backend.controller;

import com.ekhonni.backend.model.OrderCollection;
import com.ekhonni.backend.service.OrderCollectionService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Transactional
@RestController
@RequestMapping("api/v1/order_collections/")
public class OrderCollectionController {
    private final OrderCollectionService orderCollectionService;

    public OrderCollectionController(OrderCollectionService orderCollectionService) {
        this.orderCollectionService = orderCollectionService;
    }

    @GetMapping
    public List<OrderCollection> findAll() {
        return orderCollectionService.findAll();
    }

    @GetMapping("{id}/")
    public OrderCollection findById(@PathVariable Long id) {
        return orderCollectionService.findById(id);
    }

    @ResponseBody @PostMapping
    public OrderCollection create(@Valid @RequestBody OrderCollection newOrderCollection) {
        return orderCollectionService.create(newOrderCollection);
    }

    @ResponseBody @PutMapping("{id}/")
    public OrderCollection update(@PathVariable Long id, @Valid @RequestBody OrderCollection updatedOrderCollection) {
        return orderCollectionService.update(id, updatedOrderCollection);
    }

    @DeleteMapping("{id}/")
    public String deleteById(@PathVariable Long id) {
        return orderCollectionService.deleteById(id);
    }
}

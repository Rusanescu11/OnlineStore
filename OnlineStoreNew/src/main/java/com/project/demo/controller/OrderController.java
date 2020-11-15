package com.project.demo.controller;
import com.project.demo.persitance.dto.OrderDto;
import com.project.demo.persitance.model.OrderModel;
import com.project.demo.repository.OrderRepository;
import com.project.demo.service.OrderService;
import com.project.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/orders/{username}/{id}")
    public void save(@PathVariable(name = "username") String username, @PathVariable(name = "id") Long productID) {
        orderService.addToCart(username, productID);
    }
    @PutMapping("/orders/{idQ}/{id}")
    public void updateQuantity(@PathVariable(name = "idQ") int quantity, @PathVariable(name = "id") Long ordLnID) {
        orderService.updateOrderLineQuantity(quantity,ordLnID);
    }
    @PostMapping("/orders")
    public void add(@RequestBody OrderDto orderDto){
        orderService.add(orderDto);
    }

    @GetMapping("/orders/{id}")
    public OrderDto findById(@PathVariable(name = "id") Long id) {
        return orderService.findById(id);
    }

    @GetMapping("/orders")
    public List<OrderDto> findAll() {
        return orderService.findAll();
    }

    @DeleteMapping("/orders/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        orderService.deleteById(id);
    }

    @PutMapping("/orders/{id}/{address}/{additionalComment}")
    public void update(@PathVariable(name = "id") Long id,@PathVariable(name = "address") String address,@PathVariable(name = "additionalComment") String additionalComment) {
        orderService.update(id,address,additionalComment);
    }

    @GetMapping("/orderslines/{id}")
    public OrderDto getOrderLines(@PathVariable(name = "id") Long id) {
        OrderDto orderDTO = orderService.findById(id);
        return orderDTO;
    }

    @DeleteMapping("/orders/OrdLn/{idOrdLn}")
    public void deleteOrdLn(@PathVariable(name = "idOrdLn") Long id){
        orderService.deleteOrdLn(id);
    }

    @GetMapping("/orders/{username}/find")
    public OrderModel getOrder(@PathVariable(name = "username") String username){
        return this.orderService.findByUserName(username);
    }

    @PostMapping("/ordersPromo/{code}/{id}")
    public void saveCode(@PathVariable(name = "code") String code, @PathVariable(name = "id") Long id) {
        orderService.applyPromo(code, id);
    }

    @GetMapping("/orders/{username}/orders")
    public List<OrderDto> getOrdersByUsername(@PathVariable(name = "username") String username){
        return this.orderService.findOrdersByName(username);
    }
}

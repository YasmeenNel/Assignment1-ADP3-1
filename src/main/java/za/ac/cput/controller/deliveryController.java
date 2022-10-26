package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Delivery;
import za.ac.cput.service.DeliveryService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/delivery")
public class deliveryController {


    private DeliveryService deliveryService;

    public deliveryController(DeliveryService deliveryService){
        this.deliveryService = deliveryService;
    }

    @RequestMapping(value ="/create",method = RequestMethod.POST)
    public ResponseEntity<Delivery> create(@RequestBody Delivery delivery)
    {
        System.out.println(String.format("create request: %s", delivery));
        Delivery created = deliveryService.create(delivery);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/read/{id}")
    public Delivery read(@PathVariable String id)
    {
        return deliveryService.read(id);
    }

    @PostMapping("/update")
    public Delivery update(@RequestBody Delivery delivery)
    {
        return deliveryService.update(delivery);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable String id)
    {
        return deliveryService.delete(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Delivery>> getAll() {
        List<Delivery> deliveries = this.deliveryService.getAll();
        return ResponseEntity.ok(deliveries);
    }
}

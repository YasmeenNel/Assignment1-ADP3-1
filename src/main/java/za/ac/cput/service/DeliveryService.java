package za.ac.cput.service;
/*
    DeliveryService.java
    Entity for DeliveryService
    Author: Jody Heideman (219307725)
    Date: 14/08/2022
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Delivery;
import za.ac.cput.repository.IDeliveryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryService implements IDeliveryService{

    @Autowired
    private IDeliveryRepository repository;
    private static IDeliveryService service;


    public static IDeliveryService getService() {
        if (service == null)
            service = new DeliveryService();
        return service;

    }

    public Delivery create(Delivery delivery) {
       return this.repository.save(delivery);

        }

    public Delivery read(String deliveryId) {
        return this.repository.findById(deliveryId).orElse(null);
    }

    public Delivery update(Delivery delivery) {
        if (this.repository.existsById(delivery.getDeliveryID()))
            return this.repository.save(delivery);
        return delivery;
    }

    public boolean delete(String deliveryId) {
        this.repository.deleteById(deliveryId);

        if(this.repository.existsById(deliveryId)) return false;
        else return true;
    }


    public List<Delivery> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toList());
    }
}

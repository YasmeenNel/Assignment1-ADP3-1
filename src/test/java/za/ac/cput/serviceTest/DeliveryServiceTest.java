package za.ac.cput.serviceTest;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Delivery;
import za.ac.cput.factory.DeliveryFactory;
import za.ac.cput.service.DeliveryService;
import za.ac.cput.service.IDeliveryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class DeliveryServiceTest {
   @Autowired
    private DeliveryService service;
    private final Delivery delivery = DeliveryFactory.createDelivery(
            "01",
            "Pick-up",
            "15 Cresant street",
            "13:00"
    );


    @Test
     void a_create() {
        Delivery created = this.service.create(delivery);
        assertEquals(created.getDeliveryID(), delivery.getDeliveryID());
        System.out.println("created" + created);

    }
    @Test
     void b_read() {
        Delivery read = service.read(delivery.getDeliveryID());
        assertNotNull(read);
        System.out.println("read:" + read);
    }

    @Test
    void c_update() {
        Delivery old = service.read("01");
        Delivery updated = new Delivery.Builder().copy(old)
                .setDeliveryAddress("15th Lucid Drive")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated Address " + "" + updated);

    }

    @Test
     void e_delete() {
        boolean done = service.delete("01");
        assertTrue(done);
        System.out.println("successfully deleted " + "" + done);
    }


    @Test
      void findAll(){
        System.out.println("Display all");
        System.out.println(service.getAll());
    }

}

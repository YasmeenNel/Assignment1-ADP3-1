package za.ac.cput.serviceTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Receptionist;
import za.ac.cput.factory.DeliveryFactory;
import za.ac.cput.factory.ReceptionistFactory;

import za.ac.cput.service.DeliveryService;
import za.ac.cput.service.IReceptionistService;
import za.ac.cput.service.ReceptionistService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceptionistServiceTest {

    @Autowired
    private ReceptionistService service;
    private final Receptionist receptionist =  ReceptionistFactory.createReceptionist("01",
            "13:00",
            "01",
            "Table for 1 at 13:00");

    @Test
    void a_create() {
        Receptionist created = this.service.create(receptionist);
        assertEquals(created.getReceptionistID(), receptionist.getReceptionistID());
        System.out.println("created" + created);

    }
    @Test
    void b_read() {
        Receptionist read = service.read(receptionist.getReceptionistID());
        assertNotNull(read);
        System.out.println("read:" + read);
    }

    @Test
    void c_update() {
        Receptionist old = service.read("01");
        Receptionist updated = new Receptionist.Builder().copy(old)
                .setReceptionistTime("15:00")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated Time " + "" + updated);

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

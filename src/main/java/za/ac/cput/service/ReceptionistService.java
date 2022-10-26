package za.ac.cput.service;
/*
    ReceptionistService.java
    Entity for ReceptionistService
    Author: Jody Heideman (219307725)
    Date: 14/08/2022
*/

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Receptionist;
import za.ac.cput.repository.IReceptionistRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceptionistService implements IReceptionistService{


    private IReceptionistRepository repository;
    private static IReceptionistService service;


    public static IReceptionistService getService() {
        if (service == null)
            service = new ReceptionistService();
        return service;

    }

    public Receptionist create(Receptionist receptionist) {
        return this.repository.save(receptionist);
    }


    public Receptionist read(String receptionistId) {
        return this.repository.findById(receptionistId)
                .orElse(null);
    }

    public Receptionist update(Receptionist receptionist) {

        if (this.repository.existsById(receptionist.getReceptionistID()))
            return this.repository.save(receptionist);
        return receptionist;
    }

    public boolean delete(String receptionistId) {
        this.repository.deleteById(receptionistId);

        if(this.repository.existsById(receptionistId)) return false;
        else return true;

    }


    public List<Receptionist> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toList());
    }
}


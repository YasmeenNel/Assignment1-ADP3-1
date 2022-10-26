package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Receptionist;
import za.ac.cput.service.DeliveryService;
import za.ac.cput.service.ReceptionistService;

import java.util.List;
@RestController
@RequestMapping("/receptionist")
public class receptionistController {


    private ReceptionistService receptionistService;

    public receptionistController(ReceptionistService receptionistService){
        this.receptionistService = receptionistService;
    }

    @RequestMapping(value ="/create",method = RequestMethod.POST)
    public ResponseEntity<Receptionist> create(@RequestBody Receptionist receptionist)
    {
        System.out.println(String.format("create request: %s", receptionist));
        Receptionist created = receptionistService.create(receptionist);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/read/{id}")
    public Receptionist read(@PathVariable String id)
    {
        return receptionistService.read(id);
    }

    @PostMapping("/update")
    public Receptionist update(@RequestBody Receptionist receptionist)
    {
        return receptionistService.update(receptionist);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable String id)
    {
        return receptionistService.delete(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Receptionist>> getAll() {
        List<Receptionist> receptionists = this.receptionistService.getAll();
        return ResponseEntity.ok(receptionists);
    }
}

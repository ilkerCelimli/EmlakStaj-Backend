package com.emlak.backend.api;

import com.emlak.backend.entity.Personel;
import com.emlak.backend.input.PersonelInput;
import com.emlak.backend.service.PersonelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/personel")
@RestController
public class PersonelApi {

    private final PersonelService personelService;

    public PersonelApi(PersonelService personelService) {
        this.personelService = personelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personel> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(personelService.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Personel>> findAll() {
        return ResponseEntity.ok().body(personelService.findAll());
    }

    @PostMapping("/createPersonel")
    public ResponseEntity<Void> createPersonel(@RequestBody PersonelInput p) {
        this.personelService.save(this.personelService.handleInput(p));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/updatePersonel")
    public ResponseEntity<Void> updatePersonel(@PathVariable("id") String id, @RequestBody PersonelInput p) {
        Personel updateEntity = this.personelService.handleInput(p);
        Personel dbEntity = this.personelService.findById(id);
        if (!updateEntity.getName().equals(dbEntity.getName())) {
            dbEntity.setName(updateEntity.getName());
        }
        if (!updateEntity.getPhoneNumber().equals(dbEntity.getPhoneNumber())) {
            dbEntity.setPhoneNumber(updateEntity.getPhoneNumber());

        }
        this.personelService.update(dbEntity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        this.personelService.delete(id);

        return ResponseEntity.ok().build();
    }
}

package com.emlak.backend.service;

import com.emlak.backend.entity.Personel;
import com.emlak.backend.input.PersonelInput;
import com.emlak.backend.repository.PersonelRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonelService extends BaseService<Personel> {

    private final PersonelRepository personelRepository;

    public PersonelService(PersonelRepository personelRepository) {
        super(personelRepository);
        this.personelRepository = personelRepository;
    }

    public Personel handleInput(PersonelInput p) {
        return Personel.builder()
                .name(p.getName())
                .phoneNumber(p.getPhoneNumber())
                .img(p.getImg().getBytes())
                .build();
    }

}

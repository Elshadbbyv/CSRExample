package csr.example.csrexample.service;

import csr.example.csrexample.model.PersonDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PersonService {
    void add(PersonDto dto);
    PersonDto getById(Long id);


    List<PersonDto> getAll();

    void update(PersonDto dto, Long id);




    void deleteById(Long id);
}

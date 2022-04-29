package csr.example.csrexample.service.impl;

import csr.example.csrexample.dao.entity.PersonEntity;
import csr.example.csrexample.dao.repository.PersonRepository;
import csr.example.csrexample.model.PersonDto;
import csr.example.csrexample.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(PersonDto dto) {
        PersonEntity entity = new PersonEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());
        entity.setGender(dto.getGender());
        repository.save(entity);
    }

    @Override
    public PersonDto getById(Long id) {
        PersonEntity entity = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Id not founded"));
        PersonDto dto = new PersonDto();
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setAge(entity.getAge());
        dto.setGender(entity.getGender());
        return dto;
    }

    @Override
    public List<PersonDto> getAll() {
        List<PersonEntity> people = repository.getAll();


        return people.stream()
                .map(entity -> new PersonDto(entity.getName(), entity.getSurname(), entity.getAge(), entity.getGender()))
                .collect(Collectors.toList());
    }


    @Override
    public void update(PersonDto dto, Long id) {

        PersonEntity entity = repository.findByIdCustom(id)
                .orElseThrow(()-> new RuntimeException("Id not founded"));
        PersonDto dto1 = new PersonDto();
        dto1.setName(entity.getName());
        dto1.setSurname(entity.getSurname());
        dto1.setAge(entity.getAge());
        dto1.setGender(entity.getGender());

    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

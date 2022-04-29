package csr.example.csrexample.controller;

import csr.example.csrexample.model.PersonDto;
import csr.example.csrexample.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping()
    public void add(@RequestBody PersonDto dto){
        service.add( dto);

    }
    @GetMapping("/{id")
    public PersonDto getById(@PathVariable Long id){
        return service.getById(id);

    }
    @GetMapping()
    public List<PersonDto> getAll(){
        return service.getAll();
    }
    @PatchMapping("{/id}")
    public void update(@RequestBody PersonDto dto,@PathVariable Long id){
        service.update(dto, id);

    }
    @DeleteMapping("{/id}")
    public  void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }






}

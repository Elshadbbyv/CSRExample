package csr.example.csrexample.controller;

import csr.example.csrexample.dto.CardDto;
import csr.example.csrexample.service.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService service;

    public CardController(CardService service) {
        this.service = service;
    }

    @PostMapping
    public void add(@RequestBody CardDto dto) {
        service.add(dto);
    }

    @GetMapping("/{id}")
    public CardDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<CardDto> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CardDto dto, @PathVariable Long id) {
        service.update(dto, id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        service.deleteById(id);
    }
}

package csr.example.csrexample.controller;


import csr.example.csrexample.service.HumanService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/human")
public class HumanController {

    private final HumanService service;

    public HumanController(HumanService service) {
        this.service = service;
    }

    @PostMapping("/read/{word}")
    public void read(@PathVariable String word) {
        service.read(word);
    }
}

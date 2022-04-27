package csr.example.csrexample.service.impl;


import csr.example.csrexample.service.HumanService;
import org.springframework.stereotype.Service;

@Service
public class HumanServiceImpl implements HumanService {

    @Override
    public void read(String word) {
        System.out.println(word);
    }
}

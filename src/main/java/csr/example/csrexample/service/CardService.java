package csr.example.csrexample.service;


import csr.example.csrexample.model.CardDto;

import java.util.List;

public interface CardService {

    void add(CardDto dto);

    CardDto getById(Long id);

    List<CardDto> getAll();

    void update(CardDto dto, Long id);

    void deleteById(Long id);
}
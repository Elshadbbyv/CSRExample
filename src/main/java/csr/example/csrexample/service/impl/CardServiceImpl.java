package csr.example.csrexample.service.impl;


import csr.example.csrexample.dao.entity.CardEntity;
import csr.example.csrexample.dao.repository.CardRepository;

import csr.example.csrexample.model.CardDto;
import csr.example.csrexample.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository repository;

    public CardServiceImpl(CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(CardDto dto) {
        CardEntity cardEntity = new CardEntity();
        cardEntity.setCardId(dto.getCardId());

        repository.save(cardEntity);
    }

    @Override
    public CardDto getById(Long id) {
        CardEntity cardEntity = repository.getCardEntityById(id)
                .orElseThrow(() -> new RuntimeException("Id not founded"));

        CardDto dto = new CardDto();
        dto.setCardId(cardEntity.getCardId());

        return dto;
    }

    @Override
    public List<CardDto> getAll() {
        List<CardEntity> cards = repository.getAll();

        return cards.stream()
                .map(cardEntity -> new CardDto(cardEntity.getCardId()))
                .collect(Collectors.toList());
    }

    @Override
    public void update(CardDto dto, Long id) {

        CardEntity cardEntity = repository.findByIdCustom(id)
                .orElseThrow(() -> new RuntimeException("Id not found"));

        cardEntity.setCardId(dto.getCardId());

        repository.save(cardEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

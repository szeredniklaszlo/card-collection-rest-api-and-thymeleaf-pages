package me.laszloszerednik.vizsgaszeredniklaszlotamas.service;

import lombok.RequiredArgsConstructor;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.data.entity.CardEntity;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.data.entity.mapper.CardEntityMapper;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.data.repository.CardEntityRepository;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.Card;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardEntityRepository cardEntityRepository;
    private final CardEntityMapper cardEntityMapper;

    public Card create(Card newCard) {
        CardEntity newCardEntity = cardEntityMapper.toEntity(newCard);

        CardEntity savedCardEntity = cardEntityRepository.save(newCardEntity);
        return cardEntityMapper.fromEntity(savedCardEntity);
    }

    public Card read(Long id) {
        CardEntity cardEntity = cardEntityRepository.findById(id).orElseThrow();

        return cardEntityMapper.fromEntity(cardEntity);
    }

    public List<Card> readAll() {
        List<CardEntity> cardEntities = cardEntityRepository.findAll();

        return cardEntityMapper.fromEntities(cardEntities);
    }

    public List<Card> getByLowerLimit(Double lowerLimit) {
        List<CardEntity> cardEntities = cardEntityRepository.findAllByQuantityRatioIsGreaterThan(lowerLimit);

        return cardEntityMapper.fromEntities(cardEntities);
    }

    public Card update(Card updatedCard) {
        if (!cardEntityRepository.existsById(updatedCard.getId())) {
            throw new EntityNotFoundException();
        }

        CardEntity updatedCardEntity = cardEntityMapper.toEntity(updatedCard);
        CardEntity persistedCardEntity = cardEntityRepository.save(updatedCardEntity);

        return cardEntityMapper.fromEntity(persistedCardEntity);
    }

    public Card delete(Long id) {
        CardEntity cardEntityToBeDeleted = cardEntityRepository.findById(id).orElseThrow();
        Card cardToBeDeleted = cardEntityMapper.fromEntity(cardEntityToBeDeleted);

        cardEntityRepository.deleteById(id);
        return cardToBeDeleted;
    }
}

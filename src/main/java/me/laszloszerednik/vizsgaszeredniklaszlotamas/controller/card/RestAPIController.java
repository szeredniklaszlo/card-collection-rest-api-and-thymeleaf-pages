package me.laszloszerednik.vizsgaszeredniklaszlotamas.controller.card;

import lombok.RequiredArgsConstructor;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.controller.card.dto.CardDTO;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.controller.card.dto.mapper.CardDTOMapper;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.Card;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.service.CardService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController("cardRestAPIController")
@RequestMapping("card")
@RequiredArgsConstructor
public class RestAPIController {
    private final CardService cardService;
    private final CardDTOMapper cardDTOMapper;

    @GetMapping
    public List<CardDTO> getCards() {
        List<Card> cards = cardService.readAll();

        return cardDTOMapper.toDTOs(cards);
    }

    @GetMapping("{id}")
    public CardDTO getCard(@PathVariable Long id) {
        Card card = cardService.read(id);

        return cardDTOMapper.toDTO(card);
    }

    @PostMapping
    public CardDTO postCard(@RequestBody @Valid CardDTO newCardDTO) {
        Card newCard = cardDTOMapper.fromDTO(newCardDTO);

        Card createdCard = cardService.create(newCard);
        return cardDTOMapper.toDTO(createdCard);
    }

    @PutMapping("{id}")
    public CardDTO putCard(@PathVariable Long id, @RequestBody @Valid CardDTO editedCardDTO) {
        editedCardDTO.setId(id);
        Card editedCard = cardDTOMapper.fromDTO(editedCardDTO);

        Card persistedCard = cardService.update(editedCard);
        return cardDTOMapper.toDTO(persistedCard);
    }

    @DeleteMapping("{id}")
    public CardDTO deleteCard(@PathVariable Long id) {
        Card deletedCard = cardService.delete(id);

        return cardDTOMapper.toDTO(deletedCard);
    }
}

package me.laszloszerednik.vizsgaszeredniklaszlotamas.controller.card;

import lombok.RequiredArgsConstructor;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.controller.card.dto.CardDTO;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.controller.card.dto.mapper.CardDTOMapper;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.controller.kollection.dto.mapper.KollectionDTOMapper;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.Card;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.Kollection;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.service.CardService;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.service.KollectionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("cardViewController")
@RequiredArgsConstructor
public class ViewController {
    private final CardService cardService;
    private final KollectionService kollectionService;
    private final CardDTOMapper cardDTOMapper;
    private final KollectionDTOMapper kollectionDTOMapper;

    @GetMapping("list")
    public String getList(Model model) {
        List<Card> cards = cardService.readAll();
        model.addAttribute("cards", cardDTOMapper.toDTOs(cards));

        return "list";
    }

    @GetMapping("card-details")
    public String getCardDetails(
            @RequestParam("id") Long id,
            Model model
    ) {
        Card card = cardService.read(id);
        List<Kollection> collections = kollectionService.readAll();

        model.addAttribute("cardDTO", cardDTOMapper.toDTO(card));
        model.addAttribute("collections", kollectionDTOMapper.toDTOs(collections));

        return "card-details";
    }

    @PostMapping("update")
    public String postUpdate(@ModelAttribute("cardDTO") CardDTO newCardDTO) {
        if (newCardDTO.getCollection().getId() == null) {
            newCardDTO.setCollection(null);
        }

        Card newCard = cardDTOMapper.fromDTO(newCardDTO);
        cardService.update(newCard);

        return "redirect:/card-details?id=" + newCardDTO.getId();
    }

    @GetMapping("create")
    public String getCreate(Model model) {
        model.addAttribute("cardDTO", new CardDTO());

        return "create";
    }

    @PostMapping("create")
    public String postCreate(@ModelAttribute("cardDTO") CardDTO cardDTO) {
        Card newCard = cardDTOMapper.fromDTO(cardDTO);
        cardService.create(newCard);

        return "redirect:/list";
    }

    @GetMapping("list-requested")
    public String getListRequested() {
        return "list-requested";
    }

    @GetMapping("list-requested/result")
    public String getListRequested(
            @RequestParam("lowerLimit") String lowerLimit,
            Model model
    ) {
        List<Card> cards = cardService.getByLowerLimit(Double.valueOf(lowerLimit));
        model.addAttribute("cards", cardDTOMapper.toDTOs(cards));

        return "list-requested-result";
    }

    @GetMapping("estimated-price-calculator")
    public String getEstimatedPriceCalculator(
            @RequestParam("id") Long id,
            Model model
    ) {
        model.addAttribute("id", id);

        return "estimated-price-calculator";
    }

    @GetMapping("estimated-price-calculator/result")
    public String getEstimatedPriceCalculatorResult(
            @RequestParam("id") Long id,
            @RequestParam("strategy") String strategy,
            Model model
    ) {
        Card card = cardService.read(id);
        model.addAttribute("cardDTO", cardDTOMapper.toDTO(card, strategy));

        return "estimated-price-calculator-result";
    }
}

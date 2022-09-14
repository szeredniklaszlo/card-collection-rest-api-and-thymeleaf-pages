package me.laszloszerednik.vizsgaszeredniklaszlotamas.controller.kollection;

import lombok.RequiredArgsConstructor;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.controller.kollection.dto.KollectionDTO;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.controller.kollection.dto.mapper.KollectionDTOMapper;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.domain.Kollection;
import me.laszloszerednik.vizsgaszeredniklaszlotamas.service.KollectionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("kollectionViewController")
@RequiredArgsConstructor
public class ViewController {
    private final KollectionService kollectionService;
    private final KollectionDTOMapper kollectionDTOMapper;

    @GetMapping("kollection-create")
    public String getKollectionCreate(Model model) {
        model.addAttribute("kollectionDTO", new KollectionDTO());
        return "kollection-create";
    }

    @PostMapping("kollection-create")
    public String postKollection(@ModelAttribute("kollectionDTO") KollectionDTO kollectionDTO) {
        Kollection createdKollection = kollectionDTOMapper.fromDTO(kollectionDTO);
        kollectionService.create(createdKollection);

        return "kollection-create";
    }
}

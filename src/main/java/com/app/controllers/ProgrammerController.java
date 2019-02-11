package com.app.controllers;


import com.app.dto.ProgrammerDto;
import com.app.dto.ProgrammerSkillsDto;
import com.app.model.Gender;
import com.app.model.Skill;
import com.app.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

@Controller
@RequestMapping("programmers")
public class ProgrammerController {
    private ProgrammerService programmerService;
    private CompanyService companyService;
    private SkillService skillService;
    private ModelMapper modelMapper;

    public ProgrammerController(ProgrammerService programmerService, CompanyService companyService, SkillService skillService, ModelMapper modelMapper) {
        this.programmerService = programmerService;
        this.companyService = companyService;
        this.skillService = skillService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addProgrammerGet(Model model) {
        model.addAttribute("programmer", new ProgrammerSkillsDto());
        model.addAttribute("genders", Gender.values());
        model.addAttribute("skills", skillService.getSkills().stream().map(Skill::getSkill).collect(Collectors.toList()));
        model.addAttribute("experiences", Arrays.asList(1, 2, 5, 10, 15));
        model.addAttribute("companies", companyService.getCompanies());
        model.addAttribute("errors", new HashMap<>());
        return "programmers/new";
    }

    @PostMapping("/add")
    public String addProgrammerPost(
            @Valid @ModelAttribute ProgrammerSkillsDto programmerSkillsDto,
            BindingResult bindingResult,
            Model model
    ) throws IOException {

        System.out.println("1");
        if (bindingResult.hasErrors()) {
            System.out.println("2");
            model.addAttribute("programmer", programmerSkillsDto);
            model.addAttribute("genders", Gender.values());
            model.addAttribute("skills", skillService.getSkills().stream().map(Skill::getSkill).collect(Collectors.toList()));
            model.addAttribute("experiences", Arrays.asList(1, 2, 5, 10, 15));
            model.addAttribute("companies", companyService.getCompanies());
            model.addAttribute("errors", bindingResult
                    .getFieldErrors()
                    .stream()
                    .collect(Collectors.toMap(
                            FieldError::getField,
                            FieldError::getDefaultMessage,
                            (v1, v2) -> String.join(", ", new String[]{v1, v2})
                        )
                    )

            );
            return "programmers/new";
        }

        programmerService.addProgrammer(programmerSkillsDto);
        return "redirect:/";
    }
}

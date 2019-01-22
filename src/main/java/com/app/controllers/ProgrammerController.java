package com.app.controllers;


import com.app.dto.ProgrammerDto;
import com.app.dto.ProgrammerSkillsDto;
import com.app.model.Gender;
import com.app.model.Skill;
import com.app.service.CompanyService;
import com.app.service.ModelMapper;
import com.app.service.ProgrammerService;
import com.app.service.SkillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Arrays;
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
        return "programmers/new";
    }

    @PostMapping("/add")
    public String addProgrammerPost(@ModelAttribute ProgrammerSkillsDto programmerSkillsDto) throws IOException {
        programmerService.addProgrammer(programmerSkillsDto);
        return "redirect:/";
    }
}

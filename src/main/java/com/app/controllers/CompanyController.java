package com.app.controllers;

import com.app.dto.CompanyDto;
import com.app.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/add")
    public String addCompanyGet(Model model) {
        model.addAttribute("company", new CompanyDto());
        return "companies/new";
    }

    @PostMapping("/add")
    public String addCompanyPost(@ModelAttribute CompanyDto companyDto) {
        companyService.addCompany(null);
        return "redirect:/";
    }

}

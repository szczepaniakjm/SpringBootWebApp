package com.app.service;

import com.app.dto.CompanyDto;
import com.app.exceptions.MyException;
import com.app.model.Company;
import com.app.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;
    private ModelMapper modelMapper;

    public CompanyService(
            CompanyRepository companyRepository,
            ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    public void addCompany(CompanyDto companyDto) {

        if (companyDto == null) {
            throw new MyException("COMPANY OBJECT IS NULL");
        }
        companyRepository.save(modelMapper.fromCompanyDtoToCompany(companyDto));
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

}

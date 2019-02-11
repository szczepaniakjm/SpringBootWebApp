package com.app.service;

import com.app.model.Skill;
import com.app.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private SkillRepository skillRepository;
    private ModelMapper modelMapper;

    public SkillService(SkillRepository skillRepository, ModelMapper modelMapper) {
        this.skillRepository = skillRepository;
        this.modelMapper = modelMapper;
    }

    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }
}

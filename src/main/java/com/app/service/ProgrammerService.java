package com.app.service;

import com.app.dto.ProgrammerDto;
import com.app.dto.ProgrammerSkillsDto;
import com.app.exceptions.MyException;
import com.app.model.Programmer;
import com.app.repository.ProgrammerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ProgrammerService {

    private final ProgrammerRepository programmerRepository;
    private final ModelMapper modelMapper;
    private final FileService fileService;


    public void addProgrammer(ProgrammerSkillsDto programmerSkillsDto) throws IOException {

        System.out.println(programmerSkillsDto.getSkills());
        // majac w programmer mape elementow typu Skill dla kazdego skill pobierasz
        // ustalasz id pobierajajc dane po nazwie skilla
        Programmer programmer = modelMapper.fromProgrammerSkillsDtoToProgrammer(programmerSkillsDto);
        programmer.setPhoto(fileService.addFile(programmerSkillsDto.getMultipartFile()));
        programmerRepository.save(programmer);
    }
}

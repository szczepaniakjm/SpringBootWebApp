package com.app.service;

import com.app.dto.ProgrammerDto;
import com.app.dto.ProgrammerSkillsDto;
import com.app.exceptions.MyException;
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

        System.out.println(programmerSkillsDto);
        fileService.addFile(programmerSkillsDto.getMultipartFile());

        /*if (programmerDto == null) {
            throw new MyException("COMPANY OBJECT IS NULL");
        }
        programmerRepository.save(modelMapper.fromProgrammerDtoToProgrammer(programmerDto));*/
    }
}

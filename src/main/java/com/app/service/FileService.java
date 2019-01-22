package com.app.service;

import com.app.exceptions.MyException;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FileService {

    private final String rootPath = System.getProperty("user.dir");

    private String filePath(MultipartFile file) {

        final String imgPath = "\\src\\main\\resources\\static\\";
        String[] arr = file.getOriginalFilename().split("\\.");
        final String extension = arr[arr.length - 1];
        return rootPath + imgPath + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm-ss")) + "." + extension;
    }

    public void addFile(MultipartFile file) throws IOException {
        if (file == null) {
            throw new MyException("MULTIPART FILE IS NOT CORRECT");
        }

        if (file.getBytes().length == 0) {
            throw new MyException("FILE IS EMPTY");
        }

        String path = filePath(file); //przekazuję plik, tworzę sciezke
        FileCopyUtils.copy(file.getBytes(), new File(path));
    }

}

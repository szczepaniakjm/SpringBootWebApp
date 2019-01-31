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

    private String generateFilename(MultipartFile file) {
        String[] arr = file.getOriginalFilename().split("\\.");
        final String extension = arr[arr.length - 1];
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm-ss")) + "." + extension;
    }
    private String filePath() {
        final String imgPath = "\\src\\main\\resources\\static\\img\\";
        return rootPath + imgPath;
    }

    public String addFile(MultipartFile file) throws IOException {
        if (file == null) {
            throw new MyException("MULTIPART FILE IS NOT CORRECT");
        }

        if (file.getBytes().length == 0) {
            throw new MyException("FILE IS EMPTY");
        }

        String filename = generateFilename(file);
        String path = filePath() + filename; // tworzę sciezke pliku
        FileCopyUtils.copy(file.getBytes(), new File(path));
        return filename;
    }

    public void changeFile(MultipartFile file, String filename) throws IOException {
        if (file == null) {
            throw new MyException("MULTIPART FILE IS NOT CORRECT");
        }

        if (filename == null) {
            throw new MyException("FILENAME IS NOT CORRECT");
        }

        if (file.getBytes().length == 0) {
            throw new MyException("FILE IS EMPTY");
        }

        String path = filePath() + filename; // tworzę sciezke pliku
        FileCopyUtils.copy(file.getBytes(), new File(path));
    }

    public boolean removeFile(String filename) throws IOException {
        if (filename == null) {
            throw new MyException("FILE IS NULL");
        }

        String path = filePath();
        return new File(path + filename).delete();
    }

}

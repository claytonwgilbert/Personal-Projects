package com.cg.shopme.admin;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {

    public static void saveFile(String uploadFileDir, String fileName, MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadFileDir);

        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        try(InputStream inputStream = multipartFile.getInputStream()){
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException ex){
            throw new IOException("Could not save file: " + fileName, ex);
        }
    }

    public static void cleanDirectory(String dir){
        Path dirPath = Paths.get(dir);

        try {
            Files.list(dirPath).forEach(file -> {
                if(!Files.isDirectory(file)){
                    try {
                        Files.delete(file);
                    } catch (IOException exception) {
                        System.out.println("Could not delete: " + file);
                    }
                }
            });
        } catch (IOException exception) {
            System.out.println("Could not list directory: " + dirPath);
        }
    }


}

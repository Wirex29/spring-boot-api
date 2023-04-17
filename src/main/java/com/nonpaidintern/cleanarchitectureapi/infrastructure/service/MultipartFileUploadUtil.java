package com.nonpaidintern.cleanarchitectureapi.infrastructure.service;

import com.nonpaidintern.cleanarchitectureapi.application.common.interfaces.FileUploadUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Component
public class MultipartFileUploadUtil implements FileUploadUtil<MultipartFile, String> {

    @Override
    public String save(MultipartFile file, String destination) {

        Path uploadPath = Paths.get(destination);
        Path filePath;

        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (InputStream inputStream = file.getInputStream()) {

            filePath = uploadPath.resolve(getFileName(file));

            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return getFileName(file);
    }

    private String getFileName(MultipartFile file) {
        // Possible addition of random string to file name

        return StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
    }

}

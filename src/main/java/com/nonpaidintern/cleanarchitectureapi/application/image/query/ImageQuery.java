package com.nonpaidintern.cleanarchitectureapi.application.image.query;

import io.jkratz.mediator.core.Request;
import io.jkratz.mediator.core.RequestHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageQuery implements Request<byte[]> {

    private String fileName;

    @Component
    static class ImageQueryHandler implements RequestHandler<ImageQuery, byte[]> {

        @Override
        public byte[] handle(ImageQuery imageQuery) {

            String filePath = "img/" + imageQuery.getFileName();

            try {
                return Files.readAllBytes(Paths.get(filePath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

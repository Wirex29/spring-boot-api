package com.nonpaidintern.cleanarchitectureapi.application.image.command;

import com.nonpaidintern.cleanarchitectureapi.application.common.interfaces.FileUploadUtil;
import io.jkratz.mediator.core.Request;
import io.jkratz.mediator.core.RequestHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadImageCommand implements Request<UploadImageDto> {

    private MultipartFile file;

    @Component
    static class UploadImageCommandHandler implements RequestHandler<UploadImageCommand, UploadImageDto> {

        private final FileUploadUtil<MultipartFile, String> fileUploadUtil;

        @Value("${server.port}")
        private int port;

        @Autowired
        UploadImageCommandHandler(FileUploadUtil<MultipartFile, String> fileUploadUtil) {
            this.fileUploadUtil = fileUploadUtil;
        }

        @Override
        public UploadImageDto handle(UploadImageCommand uploadImageCommand) {

            String uploadDest = "img/";
            String filePath = fileUploadUtil.save(uploadImageCommand.getFile(), uploadDest);

            try {

                String uri = InetAddress.getLocalHost().getHostAddress() + ":" + port + "/api/v1/image/" + filePath;

                return new UploadImageDto(uri);

            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }

        }
    }

}

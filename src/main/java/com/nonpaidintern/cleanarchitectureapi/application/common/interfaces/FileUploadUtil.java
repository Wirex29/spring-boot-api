package com.nonpaidintern.cleanarchitectureapi.application.common.interfaces;

import org.springframework.stereotype.Component;

@Component
public interface FileUploadUtil<T, R> {

    R save(T file, String destination);
}

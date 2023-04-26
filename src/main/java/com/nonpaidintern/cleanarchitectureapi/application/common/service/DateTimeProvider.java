package com.nonpaidintern.cleanarchitectureapi.application.common.service;

import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public interface DateTimeProvider {

    OffsetDateTime timeNow();

    OffsetDateTime timeNow(String offset);
}

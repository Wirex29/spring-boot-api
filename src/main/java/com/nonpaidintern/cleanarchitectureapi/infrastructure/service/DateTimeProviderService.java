package com.nonpaidintern.cleanarchitectureapi.infrastructure.service;

import com.nonpaidintern.cleanarchitectureapi.application.common.service.DateTimeProvider;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
public class DateTimeProviderService implements DateTimeProvider {
    @Override
    public OffsetDateTime timeNow() {
        return OffsetDateTime.now(ZoneOffset.of("+07:00"));
    }

    @Override
    public OffsetDateTime timeNow(String offset) {
        return OffsetDateTime.now(ZoneOffset.of(offset));
    }
}

package ru.iteco.account.serviceAndMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.iteco.account.modelAndEntity.ExternalInfo;

@Component
@Slf4j
class ExternalServiceImpl implements ExternalService {
    @Override
    public ExternalInfo getInfo() {
        log.info("Call get Info!");
        return ExternalInfo.builder().info("INFO!!").build();
    }
}

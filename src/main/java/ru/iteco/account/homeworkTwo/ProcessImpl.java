package ru.iteco.account.homeworkTwo;

import org.springframework.stereotype.Component;
import ru.iteco.account.homeworkTwo.service.ExternalInfo;

@Component
public class ProcessImpl implements Process {
    @Override
    public boolean run(ExternalInfo externalInfo) {
        return false;
    }
}

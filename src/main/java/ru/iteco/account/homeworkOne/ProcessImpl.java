package ru.iteco.account.homeworkOne;

import org.springframework.stereotype.Component;

@Component
public class ProcessImpl implements Process {
    @Override
    public boolean run(ExternalInfo externalInfo) {
        return false;
    }
}

package ru.iteco.account.modelAndEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExternalInfo {
    private String info;
}
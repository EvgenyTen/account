package ru.iteco.account.modelAndEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {
    private String street;
    private String city;
    private String home;
    private String country;
}

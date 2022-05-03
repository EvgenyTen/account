package ru.iteco.account.modelAndEntity;

import lombok.Builder;
import lombok.Data;
import ru.iteco.account.exceptionsAndValidations.Create;
import ru.iteco.account.exceptionsAndValidations.Update;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Builder
public class UserDto {
    @NotNull(groups = Create.class)
    @Null(groups = Update.class)
    private Integer id;
    @NotBlank
    private String name;
    @Email
    private String email;

    private AddressDto address;
}

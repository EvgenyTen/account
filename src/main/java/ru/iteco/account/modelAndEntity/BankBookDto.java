package ru.iteco.account.modelAndEntity;

import lombok.Builder;
import lombok.Data;
import ru.iteco.account.exceptionsAndValidations.Create;
import ru.iteco.account.exceptionsAndValidations.Currency;
import ru.iteco.account.exceptionsAndValidations.Update;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

@Data
@Builder
public class BankBookDto {

    @Null(groups = Create.class)
    @NotNull(groups = Update.class)
    private Integer id;
    private Integer userId;
    @NotBlank(message = "Not blank!")
    private String number;
    @Min(value = 0L)
    private BigDecimal amount;
    @Currency
    private String currency;

}
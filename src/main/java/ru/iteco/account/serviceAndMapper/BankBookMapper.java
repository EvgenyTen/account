package ru.iteco.account.serviceAndMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.iteco.account.modelAndEntity.BankBookDto;
import ru.iteco.account.modelAndEntity.BankBookEntity;

@Mapper(componentModel = "spring")
public interface BankBookMapper {
    @Mapping(target = "currency", source = "currency.name")
    BankBookDto mapToDto(BankBookEntity bankBookEntity);
   @Mapping(target = "currency.name", source = "currency")
    BankBookEntity mapToEntity(BankBookDto bankBookDto);
}

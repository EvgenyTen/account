package ru.iteco.account.controllerAndRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iteco.account.modelAndEntity.CurrencyEntity;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer> {
    CurrencyEntity findByName(String name);
}

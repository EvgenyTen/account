package ru.iteco.account.controllerAndRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iteco.account.modelAndEntity.BankBookEntity;
import ru.iteco.account.modelAndEntity.CurrencyEntity;

import java.util.List;
import java.util.Optional;

public interface BankBookRepository extends JpaRepository<BankBookRepository, Integer> {
    List<BankBookEntity> findAllByUserId(Integer userId);

    Optional<BankBookEntity> findByUserIdAndNumberAndCurrency(Integer userId, CurrencyEntity currency);

    void deleteAllByUserid(Integer userid);
}

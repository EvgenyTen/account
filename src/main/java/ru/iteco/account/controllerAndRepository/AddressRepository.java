package ru.iteco.account.controllerAndRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iteco.account.modelAndEntity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
}

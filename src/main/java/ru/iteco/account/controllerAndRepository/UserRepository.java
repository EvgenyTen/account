package ru.iteco.account.controllerAndRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iteco.account.modelAndEntity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}

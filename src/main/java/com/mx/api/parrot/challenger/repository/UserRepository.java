package com.mx.api.parrot.challenger.repository;

import org.springframework.data.repository.CrudRepository;

import com.mx.api.parrot.challenger.model.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

	UserEntity findByUsername(String username);
}
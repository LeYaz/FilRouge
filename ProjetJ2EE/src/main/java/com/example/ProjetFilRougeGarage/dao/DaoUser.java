package com.example.ProjetFilRougeGarage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjetFilRougeGarage.beans.User;

public interface DaoUser extends JpaRepository<User, Integer> {

}

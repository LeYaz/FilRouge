package com.example.ProjetFilRougeGarage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjetFilRougeGarage.beans.Client;

public interface DaoClient extends JpaRepository<Client, Integer> {

}

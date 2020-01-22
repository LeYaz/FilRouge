package com.example.ProjetFilRougeGarage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjetFilRougeGarage.beans.Vehicule;


public interface DaoVehicule extends JpaRepository<Vehicule, Integer> {

}

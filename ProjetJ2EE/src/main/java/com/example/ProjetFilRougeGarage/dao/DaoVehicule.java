package com.example.ProjetFilRougeGarage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ProjetFilRougeGarage.beans.Vehicule;


public interface DaoVehicule extends JpaRepository<Vehicule, Integer> {
	@Query("select v from Vehicule v where v.desactiver = false")
	public List<Vehicule> listActive();
}

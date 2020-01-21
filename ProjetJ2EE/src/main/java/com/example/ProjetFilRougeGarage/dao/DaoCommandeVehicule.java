package com.example.ProjetFilRougeGarage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ProjetFilRougeGarage.beans.CommandeVehicule;

public interface DaoCommandeVehicule extends JpaRepository<CommandeVehicule, Integer> {
	@Query("select c from CommandeVehicule c where c.desactiver = false")
	public List<CommandeVehicule> listActive();
}

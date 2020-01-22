package com.example.ProjetFilRougeGarage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ProjetFilRougeGarage.beans.FactureFiche;


public interface DaoFactureFiche extends JpaRepository<FactureFiche, Integer> {

	
	@Query("select f from FactureFiche f where f.desactiver = false")
	public List<FactureFiche> listActive();
}

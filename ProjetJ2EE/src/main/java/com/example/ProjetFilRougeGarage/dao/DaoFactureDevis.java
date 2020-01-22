package com.example.ProjetFilRougeGarage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ProjetFilRougeGarage.beans.FactureDevis;
import com.example.ProjetFilRougeGarage.beans.Fiche;


public interface DaoFactureDevis extends JpaRepository<FactureDevis, Integer> {
	@Query("select f from FactureDevis f where f.desactiver = false")
	public List<FactureDevis> listActive();
}

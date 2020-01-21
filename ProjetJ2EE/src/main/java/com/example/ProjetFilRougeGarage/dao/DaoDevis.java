package com.example.ProjetFilRougeGarage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ProjetFilRougeGarage.beans.Devis;


public interface DaoDevis extends JpaRepository<Devis, Integer> {
	@Query("select d from Devis d where d.desactiver =false")
	public List<Devis> listActive();
}

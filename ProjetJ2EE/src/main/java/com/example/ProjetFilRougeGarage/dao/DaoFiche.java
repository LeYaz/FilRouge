package com.example.ProjetFilRougeGarage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ProjetFilRougeGarage.beans.Fiche;

public interface DaoFiche extends JpaRepository<Fiche, Integer> {
	@Query("select f from Fiche f where f.desactiver = false")
	public List<Fiche> listActive();
}

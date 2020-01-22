package com.example.ProjetFilRougeGarage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ProjetFilRougeGarage.beans.Priorite;

public interface DaoPriorite extends JpaRepository<Priorite, Integer> {
	@Query("select p from Priorite p where name like ?1 ")
	List<Priorite> findByName(String prioritename);
}

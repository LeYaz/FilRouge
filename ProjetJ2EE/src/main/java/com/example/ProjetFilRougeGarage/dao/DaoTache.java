package com.example.ProjetFilRougeGarage.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.ProjetFilRougeGarage.beans.Tache;

public interface DaoTache extends JpaRepository<Tache, Integer> {
	
	@Query("select t from Tache t where t.desactiver = false")
	public List<Tache> listActive();

	
	

}

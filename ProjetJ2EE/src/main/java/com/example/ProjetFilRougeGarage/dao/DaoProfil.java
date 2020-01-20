package com.example.ProjetFilRougeGarage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ProjetFilRougeGarage.beans.Profil;

public interface DaoProfil extends JpaRepository<Profil, Integer> {
	@Query("select p from Profil p where name like ?1 ")
	List<Profil> findByName(String profilname);
}

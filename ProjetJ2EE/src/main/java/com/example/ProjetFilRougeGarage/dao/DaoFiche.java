package com.example.ProjetFilRougeGarage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjetFilRougeGarage.beans.Fiche;

public interface DaoFiche extends JpaRepository<Fiche, Integer> {

}

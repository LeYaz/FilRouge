-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 12 déc. 2019 à 22:01
-- Version du serveur :  10.3.16-MariaDB
-- Version de PHP :  7.1.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `garagepoefr`
--
CREATE DATABASE IF NOT EXISTS `garagepoefr` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `garagepoefr`;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `code_postal` varchar(50) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `mobile` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `prenom`, `adresse`, `code_postal`, `ville`, `telephone`, `mobile`) VALUES
(1, 'FAIVRE', 'GEORGES', '12 rue nationale', '69000', 'LYON', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `commande_piece`
--

CREATE TABLE `commande_piece` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_piece` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  `date_creation` date NOT NULL,
  `date_cloture` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `commande_vehicule`
--

CREATE TABLE `commande_vehicule` (
  `id` int(11) NOT NULL,
  `id_devis` int(11) DEFAULT NULL,
  `etat` bit(1) DEFAULT b'0',
  `date_creation` date DEFAULT NULL,
  `date_cloture` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `devis`
--

CREATE TABLE `devis` (
  `id` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_vehicule` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date_creation` date NOT NULL,
  `etatdevis` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `facture_devis`
--

CREATE TABLE `facture_devis` (
  `id` int(11) NOT NULL,
  `id_devis` int(11) NOT NULL,
  `prixHT` float DEFAULT 0,
  `tauxTVA` float DEFAULT 0.2,
  `date_creation` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `facture_fiche`
--

CREATE TABLE `facture_fiche` (
  `id` int(11) NOT NULL,
  `id_fiche` int(11) NOT NULL,
  `prixHT` float DEFAULT 0,
  `tauxTVA` float DEFAULT 0.2
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `fiche`
--

CREATE TABLE `fiche` (
  `id` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `etatfiche` bit(1) DEFAULT b'0',
  `id_priorite` int(11) NOT NULL,
  `Date_creation` date NOT NULL,
  `Date_cloture` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `pieces`
--

CREATE TABLE `pieces` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `quantite` int(11) DEFAULT NULL,
  `date_saisie` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `priorite`
--

CREATE TABLE `priorite` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE `profil` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `profil`
--

INSERT INTO `profil` (`id`, `name`) VALUES
(1, 'MECANICIEN'),
(2, 'ADMINISTRATEUR'),
(3, 'COMMERCIAL'),
(4, 'CHEF_ATELIER'),
(5, 'MAGASINIER');

-- --------------------------------------------------------

--
-- Structure de la table `profil_user`
--

CREATE TABLE `profil_user` (
  `id_user` int(11) NOT NULL,
  `id_profil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `profil_user`
--

INSERT INTO `profil_user` (`id_user`, `id_profil`) VALUES
(1, 2),
(1, 4),
(2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

CREATE TABLE `tache` (
  `id` int(11) NOT NULL,
  `commentaire` varchar(200) DEFAULT NULL,
  `id_user` int(11) NOT NULL,
  `id_fiche` int(11) NOT NULL,
  `id_priorite` int(11) NOT NULL,
  `id_piece` int(11) NOT NULL,
  `qte` int(11) DEFAULT 0,
  `etattache` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `login` varchar(15) NOT NULL,
  `pwd` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `lastname`, `firstname`, `login`, `pwd`) VALUES
(1, 'DURAND', 'JEAN', 'JDURAND', '1234'),
(2, 'MARTIN', 'JEANNE', 'JMARTIN', '1234');

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `id` int(11) NOT NULL,
  `modele` varchar(50) NOT NULL,
  `quantite` int(11) NOT NULL,
  `prixHT` float DEFAULT 0,
  `date_creation` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vehicule`
--

INSERT INTO `vehicule` (`id`, `modele`, `quantite`, `prixHT`, `date_creation`) VALUES
(1, '307', 12, 15345, '2019-12-12'),
(2, 'GOLF IV', 6, 17450, '2019-12-11');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commande_piece`
--
ALTER TABLE `commande_piece`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_piece` (`id_piece`);

--
-- Index pour la table `commande_vehicule`
--
ALTER TABLE `commande_vehicule`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_devis` (`id_devis`);

--
-- Index pour la table `devis`
--
ALTER TABLE `devis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_client` (`id_client`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_vehicule` (`id_vehicule`);

--
-- Index pour la table `facture_devis`
--
ALTER TABLE `facture_devis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_devis` (`id_devis`);

--
-- Index pour la table `facture_fiche`
--
ALTER TABLE `facture_fiche`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_fiche` (`id_fiche`);

--
-- Index pour la table `fiche`
--
ALTER TABLE `fiche`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_client` (`id_client`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_priorite` (`id_priorite`);

--
-- Index pour la table `pieces`
--
ALTER TABLE `pieces`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `priorite`
--
ALTER TABLE `priorite`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `profil`
--
ALTER TABLE `profil`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `profil_user`
--
ALTER TABLE `profil_user`
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_profil` (`id_profil`);

--
-- Index pour la table `tache`
--
ALTER TABLE `tache`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_fiche` (`id_fiche`),
  ADD KEY `id_priorite` (`id_priorite`),
  ADD KEY `id_piece` (`id_piece`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `commande_piece`
--
ALTER TABLE `commande_piece`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `commande_vehicule`
--
ALTER TABLE `commande_vehicule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `devis`
--
ALTER TABLE `devis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `facture_devis`
--
ALTER TABLE `facture_devis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `facture_fiche`
--
ALTER TABLE `facture_fiche`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `fiche`
--
ALTER TABLE `fiche`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pieces`
--
ALTER TABLE `pieces`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `priorite`
--
ALTER TABLE `priorite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `profil`
--
ALTER TABLE `profil`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `tache`
--
ALTER TABLE `tache`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `vehicule`
--
ALTER TABLE `vehicule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande_piece`
--
ALTER TABLE `commande_piece`
  ADD CONSTRAINT `commande_piece_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `commande_piece_ibfk_2` FOREIGN KEY (`id_piece`) REFERENCES `pieces` (`id`);

--
-- Contraintes pour la table `commande_vehicule`
--
ALTER TABLE `commande_vehicule`
  ADD CONSTRAINT `commande_vehicule_ibfk_1` FOREIGN KEY (`id_devis`) REFERENCES `devis` (`id`);

--
-- Contraintes pour la table `devis`
--
ALTER TABLE `devis`
  ADD CONSTRAINT `devis_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `devis_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `devis_ibfk_3` FOREIGN KEY (`id_vehicule`) REFERENCES `vehicule` (`id`);

--
-- Contraintes pour la table `facture_devis`
--
ALTER TABLE `facture_devis`
  ADD CONSTRAINT `facture_devis_ibfk_1` FOREIGN KEY (`id_devis`) REFERENCES `devis` (`id`);

--
-- Contraintes pour la table `facture_fiche`
--
ALTER TABLE `facture_fiche`
  ADD CONSTRAINT `facture_fiche_ibfk_1` FOREIGN KEY (`id_fiche`) REFERENCES `fiche` (`id`);

--
-- Contraintes pour la table `fiche`
--
ALTER TABLE `fiche`
  ADD CONSTRAINT `fiche_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `fiche_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `fiche_ibfk_3` FOREIGN KEY (`id_priorite`) REFERENCES `priorite` (`id`);

--
-- Contraintes pour la table `profil_user`
--
ALTER TABLE `profil_user`
  ADD CONSTRAINT `profil_user_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `profil_user_ibfk_2` FOREIGN KEY (`id_profil`) REFERENCES `profil` (`id`);

--
-- Contraintes pour la table `tache`
--
ALTER TABLE `tache`
  ADD CONSTRAINT `tache_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `tache_ibfk_2` FOREIGN KEY (`id_fiche`) REFERENCES `fiche` (`id`),
  ADD CONSTRAINT `tache_ibfk_3` FOREIGN KEY (`id_priorite`) REFERENCES `priorite` (`id`),
  ADD CONSTRAINT `tache_ibfk_4` FOREIGN KEY (`id_piece`) REFERENCES `pieces` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
-- SET AUTOCOMMIT = 0;
-- START TRANSACTION;
-- SET time_zone = "+00:00";


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
  `mobile` varchar(50) NOT NULL,
`desactiver` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `prenom`, `adresse`, `code_postal`, `ville`, `telephone`, `mobile`, `desactiver`) VALUES 
(1, 'RUPPIN', 'Teddy', '1 rue jean', '73000', 'Chambery', '0479548454', '0688545465', b'0'),
(2, 'LINCOLN', 'Abraham', 'rue 1','01000', 'Paris', '0611111111', '0411111111', b'0'),
(3, 'WASHINGTON', 'George', 'rue 2','02000', 'New York', '0622222222', '0422222222', b'0'),
(4, 'KENNEDY', 'John Fidgerald', 'rue 3','03000', 'Chicago', '0633333333', '0433333333', b'0'),
(5, 'TSE TUNG', 'Mao', '1 rue ying', '25', 'Pekin', '0479988454', '0686345465', b'0'),
(6, 'MACRON', 'Emmanuel', 'rue4','01000', 'Paris', '0611511111', '0411115111', b'0'),
(7, 'CHIRAC', 'Jacques', 'rue 5','02000', 'New York', '0622222232', '0422422222', b'0'),
(8, 'SARKOZY', 'Nicolas', 'rue 6','03000', 'Chicago', '0633933333', '0433334533', b'0');

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
  `date_cloture` date DEFAULT NULL,
`desactiver` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `commande_piece` (`id`, `id_user`, `id_piece`, `quantite`, `date_creation`, `date_cloture`, `desactiver`) VALUES
(1, '1', '4', '5', '2020-02-12', NULL, b'0'),
(2, '2', '3', '25', '2020-02-13', NULL, b'0'),
(3, '3', '2', '45', '2020-02-14', NULL, b'0'),
(4, '4', '1', '235', '2020-02-15', NULL, b'0');

-- --------------------------------------------------------

--
-- Structure de la table `commande_vehicule`
--

CREATE TABLE `commande_vehicule` (
  `id` int(11) NOT NULL,
  `id_devis` int(11) DEFAULT NULL,
  `etat` bit(1) DEFAULT b'0',
  `date_creation` date DEFAULT NULL,
  `date_cloture` date DEFAULT NULL,
`desactiver` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `commande_vehicule` (`id`, `id_devis`, `etat`, `date_creation`, `date_cloture`, `desactiver`) VALUES
(1, '1', b'0', '2020-01-29', NULL, b'0'),
(2, '2', b'0', '2020-02-21', NULL, b'0'),
(3, '3', b'0', '2020-03-29', NULL, b'0'),
(4, '4', b'0', '2020-04-29', NULL, b'0');

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
  `etatdevis` bit(1) DEFAULT b'0',
`desactiver` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `devis` (`id`, `id_client`, `id_vehicule`, `id_user`, `date_creation`, `etatdevis`, `desactiver`) VALUES
(1, '1', '1', '1', '2020-01-01', b'0', b'0'),
(2, '2', '2', '2', '2020-01-02', b'0', b'0'),
(3, '3', '3', '3', '2020-01-03', b'1', b'0'),
(4, '4', '4', '4', '2020-01-04', b'1', b'0');

-- --------------------------------------------------------

--
-- Structure de la table `facture_devis`
--

CREATE TABLE `facture_devis` (
  `id` int(11) NOT NULL,
  `id_devis` int(11) NOT NULL,
  `prixHT` float DEFAULT 0,
  `tauxTVA` float DEFAULT 0.2,
  `date_creation` date NOT NULL,
`desactiver` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `facture_devis` (`id`, `id_devis`, `prixHT`, `tauxTVA`, `date_creation`, `desactiver`) VALUES
(1, '1', '1000', '0.2', '2020-01-08', b'0'),
(2, '2', '50', '0.2', '2020-01-05', b'0'),
(3, '3', '250', '0.2', '2020-01-04', b'0'),
(4, '4', '680', '0.2', '2020-05-22', b'0');

-- --------------------------------------------------------

--
-- Structure de la table `facture_fiche`
--

CREATE TABLE `facture_fiche` (
  `id` int(11) NOT NULL,
  `id_fiche` int(11) NOT NULL,
  `prixHT` float DEFAULT 0,
  `tauxTVA` float DEFAULT 0.2,
`desactiver` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `facture_fiche` (`id`, `id_fiche`, `prixHT`, `tauxTVA`, `desactiver`) VALUES
(1, '1', '45', '0.2', b'0'),
(2, '2', '58', '0.2', b'0'),
(3, '3', '15', '0.2', b'0'),
(4, '4', '23', '0.2', b'0');

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
  `Date_cloture` date DEFAULT NULL,
  `prixHT` float DEFAULT 0,
  `description`   varchar(200),
  `desactiver` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `fiche` (`id`, `id_client`, `id_user`, `etatfiche`, `id_priorite`, `Date_creation`, `Date_cloture`, `prixHT`, `description`, `desactiver`) VALUES
(1, '5', '1', b'0', '1', '2020-01-15', NULL, '50', ' ', b'0'),
(2, '6', '2', b'0', '2', '2020-01-16', NULL, '40', ' ', b'0'),
(3, '7', '3', b'0', '3', '2020-01-17', '2020-01-25', '30', ' ', b'0'),
(4, '8', '4', b'0', '4', '2020-01-18', '2020-01-26', '60', ' ', b'0');

-- --------------------------------------------------------

--
-- Structure de la table `pieces`
--

CREATE TABLE `pieces` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `quantite` int(11) DEFAULT NULL,
  `date_saisie` date DEFAULT NULL,
 `desactiver` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `pieces` (`id`, `libelle`,`quantite`,`date_saisie`, `desactiver`) VALUES
(1, 'moteurM1', '10', '2020-01-04', b'0'),
(2, 'pneuP1 ', '20', '2020-01-05', b'0'),
(3, 'siegeS1 ', '30', '2020-01-14', b'0'),
(4, 'couroieC1', '10', '2020-01-24', b'0'),
(5, 'vitreVi1 ', '20', '2020-01-16', b'0'),
(6, 'volantVo1 ', '30', '2020-01-08', b'0');



-- --------------------------------------------------------

--
-- Structure de la table `priorite`
--

CREATE TABLE `priorite` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL,
`desactiver` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `priorite` (`id`, `libelle`, `desactiver`) VALUES
(1, 'tres urgent', b'0'),
(2, 'urgent', b'0'),
(3, 'normal', b'0'),
(4, 'non prioritaire', b'0');

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE `profil` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
`desactiver` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `profil`
--

INSERT INTO `profil` (`id`, `name`, `desactiver`) VALUES
(1, 'admin', b'0'),
(2, 'chef d atelier', b'0'),
(3, 'mecanicien', b'0'),
(4, 'magasinier', b'0'),
(5, 'commercial', b'0');

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
(1, 1),
(2, 2),
(3, 3),
(4, 4);

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
  `etattache` bit(1) DEFAULT b'0',
`desactiver` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `tache` (`id`, `commentaire`, `id_user`, `id_fiche`, `id_priorite`, `id_piece`, `qte`, `etattache`, `desactiver`) VALUES 
(1, 'changer le moteur', '1', '1', '1', '1', '5', b'0', b'0'),
(2, 'changer les sieges', '2', '2', '1', '1', '25', b'0', b'0'),
(3, 'changer les vitres', '3', '3', '1', '1', '15', b'1', b'0'),
(4, 'passer l\'aspirateur', '4', '4', '1', '1', '85', b'1', b'0');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `login` varchar(15) NOT NULL,
  `pwd` varchar(10) NOT NULL,
`desactiver` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `lastname`, `firstname`, `login`, `pwd`, `desactiver`) VALUES
(1, 'DURAND', 'Jean', 'JDURAND', '1234', b'0'),
(2, 'MARTIN', 'Jeanne', 'JMARTIN', '1234', b'0'),
(3, 'RASTA', 'Maxime', 'MRASTA', '5678', b'0'),
(4, 'MIRTE', 'Manon', 'MMIRTE', '5678', b'0');

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `id` int(11) NOT NULL,
  `marque` varchar(50) NOT NULL,
  `modele` varchar(50) NOT NULL,
  `quantite` int(11) NOT NULL,
  `prixHT` float DEFAULT 0,
  `date_creation` date NOT NULL,
`desactiver` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `vehicule` (`id`, `marque`, `modele`,`quantite`,  `prixHT`, `date_creation`, `desactiver`) VALUES
(1, 'renault','megane', '10', '15000', '2020-01-04', b'0'),
(2, 'renault','scenic', '20', '23500', '2020-01-05', b'0'),
(3, 'renault','laguna', '30', '38000', '2020-01-06', b'0'),
(4, 'peugeot','208', '10', '12000', '2020-01-07', b'0'),
(5, 'peugeot','308', '20', '21500', '2020-01-08', b'0'),
(6, 'peugeot','508', '10', '48000', '2020-01-09', b'0');



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



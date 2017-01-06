-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 05 Janvier 2017 à 15:14
-- Version du serveur :  10.1.19-MariaDB
-- Version de PHP :  5.6.28



/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pizzeriabd`
--

-- --------------------------------------------------------

--
-- Structure de la table `pizza`
--

CREATE TABLE `pizza` (
  `id` int(11) NOT NULL,
  `CategoriePizza` varchar(255) DEFAULT NULL,
  `code` varchar(3) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `pizza`
--

INSERT INTO `pizza` (`id`, `CategoriePizza`, `code`, `image`, `nom`, `prix`) VALUES
(1, 'SANS_VIANDE', 'MAR', 'Pizza_4saisons.jpg', 'Margherita', 14),
(2, 'VIANDE', 'REI', 'Pizza_Reine.jpg', 'La Reine', 11.5),
(3, 'SANS_VIANDE', 'FRO', 'Pizza_4fromages.jpg', 'La 4 fromages', 12),
(4, 'VIANDE', 'CAN', 'Pizza_Bolognese.jpg', 'La cannibale', 12.5),
(5, 'VIANDE', 'SAV', 'Pizza_Napolitaine.jpg', 'La savoyarde', 13),
(7, 'VIANDE', 'IND', 'Pizza_alademande.jpg', 'L''indienne', 14.5),
(9, 'POISSON', 'EMP', NULL, 'Empreur', 18),
(12, 'VIANDE', 'REF', NULL, 'Referente', 14.55),
(13, 'VIANDE', 'ARI', NULL, 'Ariva', 13.5);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `pizza`
--
ALTER TABLE `pizza`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `pizza`
--
ALTER TABLE `pizza`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

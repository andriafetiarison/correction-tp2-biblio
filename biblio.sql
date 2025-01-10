-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 10 Janvier 2025 à 05:57
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `biblio`
--

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE IF NOT EXISTS `livre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(100) NOT NULL,
  `auteur` varchar(50) NOT NULL,
  `annee` varchar(4) NOT NULL,
  `genre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `livre`
--

INSERT INTO `livre` (`id`, `titre`, `auteur`, `annee`, `genre`) VALUES
(1, 'Mes amis, mes amours', 'Marc Levy', '2012', 'Roman'),
(2, 'Bébé calme', 'Caroline Deacon', '2005', 'Enfants'),
(3, 'Fahalalana', 'Jules Michel', '1992', 'Prière'),
(4, 'Amour toxique', 'Anne L. Marie', '1999', 'Roman'),
(6, 'Soniako', 'J. Dieu Donné', '2006', 'Roman'),
(7, 'Cinq soirées sur la prière intérieure', 'Henri CAFFAREL', '1980', 'Prière');

-- --------------------------------------------------------

--
-- Structure de la table `pret`
--

CREATE TABLE IF NOT EXISTS `pret` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_livre` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `date_pret` date DEFAULT NULL,
  `date_retour` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_livre` (`id_livre`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `pret`
--

INSERT INTO `pret` (`id`, `id_livre`, `id_user`, `date_pret`, `date_retour`) VALUES
(1, 1, 1, '2025-01-01', '2025-01-09');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `telephone` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `mail`, `telephone`) VALUES
(1, 'Rakoto Jean', 'rakoto.jean@gmail.com', 330000000),
(2, 'Rajohnson Liva', 'liva0325@gmail.com', 340000001);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `pret`
--
ALTER TABLE `pret`
  ADD CONSTRAINT `pret_ibfk_1` FOREIGN KEY (`id_livre`) REFERENCES `livre` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `pret_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

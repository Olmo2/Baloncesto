-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 06-03-2020 a las 15:51:33
-- Versión del servidor: 5.7.11
-- Versión de PHP: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `baloncesto`
--
CREATE DATABASE IF NOT EXISTS `baloncesto` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `baloncesto`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

DROP TABLE IF EXISTS `equipos`;
CREATE TABLE `equipos` (
  `Nombre` varchar(20) NOT NULL,
  `Ciudad` varchar(20) DEFAULT NULL,
  `Conferencia` varchar(10) DEFAULT NULL,
  `Division` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`Nombre`, `Ciudad`, `Conferencia`, `Division`) VALUES
('Boston Celtics', 'Boston', 'Este', 'Atlántico'),
('Chicago Bulls', 'Chicago', 'Este', 'Central'),
('Cleveland Cavaliers', 'Cleveland', 'Este', 'Central'),
('Dallas Mavericks', 'Dallas', 'Oeste', 'Suroeste'),
('Detroit Pistons', 'Detroit', 'Este', 'Central'),
('Houston Rockets', 'Houston', 'Oeste', 'Suroeste'),
('Indiana Pacers', 'Indianápolis', 'Este', 'Central'),
('Los Angeles Lakers', 'Los Ángeles', 'Oeste', 'Pacífico'),
('Miami Heat', 'Miami', 'Este', 'Sureste'),
('Orlando Magic', 'Orlando', 'Este', 'Sureste'),
('Phoenix Suns', 'Phoenix', 'Oeste', 'Pacific'),
('Portland Trail Blaze', 'Potland', 'Oeste', 'Noroeste'),
('Toronto Raptors', 'Toronto', 'Este', 'Atlántico'),
('Utah Jazz', 'Utah', 'Oeste', 'Noroesteg'),
('Washington Wizards', 'Washintong', 'Este', 'Sureste');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadisticas`
--

DROP TABLE IF EXISTS `estadisticas`;
CREATE TABLE `estadisticas` (
  `temporada` varchar(5) NOT NULL,
  `jugador` int(11) NOT NULL,
  `Puntos_por_partido` decimal(5,2) DEFAULT NULL,
  `Asistencias_por_partido` decimal(5,2) DEFAULT NULL,
  `Tapones_por_partido` decimal(5,2) DEFAULT NULL,
  `Rebotes_por_partido` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estadisticas`
--

INSERT INTO `estadisticas` (`temporada`, `jugador`, `Puntos_por_partido`, `Asistencias_por_partido`, `Tapones_por_partido`, `Rebotes_por_partido`) VALUES
('2020', 1, '30.00', '12.00', '2.00', '9.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
CREATE TABLE `jugadores` (
  `codigo` int(11) NOT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  `Procedencia` varchar(20) DEFAULT NULL,
  `Altura` varchar(4) DEFAULT NULL,
  `Peso` int(11) DEFAULT NULL,
  `Posicion` varchar(12) DEFAULT NULL,
  `Nombre_equipo` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `jugadores`
--

INSERT INTO `jugadores` (`codigo`, `Nombre`, `Procedencia`, `Altura`, `Peso`, `Posicion`, `Nombre_equipo`) VALUES
(1, 'Luka Doncic', '', '2,01', 104, 'Escolta', 'Dallas Mavericks'),
(2, 'Seth Curry', 'Duke', '1,88', 83, 'Escolta', 'Dallas Mavericks'),
(3, 'Kristaps Porzingis', '', '2,21', 108, 'Ala Pivot', 'Dallas Mavericks'),
(4, 'J.J.Barea', 'Northeastern', '1,78', 81, 'Base', 'Dallas Mavericks');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partidos`
--

DROP TABLE IF EXISTS `partidos`;
CREATE TABLE `partidos` (
  `codigo` int(11) NOT NULL,
  `equipo_local` varchar(20) DEFAULT NULL,
  `equipo_visitante` varchar(20) DEFAULT NULL,
  `puntos_local` decimal(5,0) DEFAULT NULL,
  `puntos_visitante` decimal(5,0) DEFAULT NULL,
  `temporada` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `partidos`
--

INSERT INTO `partidos` (`codigo`, `equipo_local`, `equipo_visitante`, `puntos_local`, `puntos_visitante`, `temporada`) VALUES
(1, 'Boston Celtics', 'Dallas Mavericks', '89', '115', '2020');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `equipos`
--
ALTER TABLE `equipos`
  ADD PRIMARY KEY (`Nombre`);

--
-- Indices de la tabla `estadisticas`
--
ALTER TABLE `estadisticas`
  ADD PRIMARY KEY (`temporada`,`jugador`),
  ADD KEY `jugador` (`jugador`);

--
-- Indices de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `Nombre_equipo` (`Nombre_equipo`);

--
-- Indices de la tabla `partidos`
--
ALTER TABLE `partidos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `equipo_local` (`equipo_local`),
  ADD KEY `equipo_visitante` (`equipo_visitante`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `estadisticas`
--
ALTER TABLE `estadisticas`
  ADD CONSTRAINT `estadisticas_ibfk_1` FOREIGN KEY (`jugador`) REFERENCES `jugadores` (`codigo`);

--
-- Filtros para la tabla `jugadores`
--
ALTER TABLE `jugadores`
  ADD CONSTRAINT `jugadores_ibfk_1` FOREIGN KEY (`Nombre_equipo`) REFERENCES `equipos` (`Nombre`);

--
-- Filtros para la tabla `partidos`
--
ALTER TABLE `partidos`
  ADD CONSTRAINT `partidos_ibfk_1` FOREIGN KEY (`equipo_local`) REFERENCES `equipos` (`Nombre`),
  ADD CONSTRAINT `partidos_ibfk_2` FOREIGN KEY (`equipo_visitante`) REFERENCES `equipos` (`Nombre`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

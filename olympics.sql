SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";
CREATE DATABASE IF NOT EXISTS `olympics` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `olympics`;
CREATE TABLE `area` (
  `id` int(11) NOT NULL,
  `id_multisportcenter` int(11) NOT NULL,
  `location` varchar(50) NOT NULL,
  `sport` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `area` (`id`, `id_multisportcenter`, `location`, `sport`) VALUES
(1, 1, 'Pistas', 'Atletismo'),
(2, 1, 'Campo', 'Rugbi'),
(3, 3, 'Pista', 'Atletismo'),
(4, 3, 'Campo', 'Fútbol');
CREATE TABLE `comissioner_event` (
  `id` int(11) NOT NULL,
  `id_event` int(11) NOT NULL,
  `id_comissioner` int(11) NOT NULL,
  `rol` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `comissioner_event` (`id`, `id_event`, `id_comissioner`, `rol`) VALUES
(1, 7, 1, 'JUEZ'),
(2, 7, 2, 'OBSERVADOR');
CREATE TABLE `commissioner` (
  `id` int(11) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `commissioner` (`id`, `dni`, `name`) VALUES
(1, '00000000-T', 'Felipe'),
(2, '00000001-R', 'María');
CREATE TABLE `equipment` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `equipment` (`id`, `name`) VALUES
(1, 'CortaCesped'),
(2, 'Balón');
CREATE TABLE `equipment_event` (
  `id` int(11) NOT NULL,
  `id_equipment` int(11) NOT NULL,
  `id_event` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `equipment_event` (`id`, `id_equipment`, `id_event`) VALUES
(1, 2, 1),
(2, 2, 7);
CREATE TABLE `event` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_sportcomplex` int(11) NOT NULL,
  `id_area` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `event` (`id`, `name`, `date`, `id_sportcomplex`, `id_area`) VALUES
(1, 'España-Italia', '2019-10-22 22:00:00', 1, 2),
(2, '100 metros liso', '2019-10-23 22:00:00', 1, 1),
(4, 'CAJASUR-BADALONA', '2019-10-04 22:00:00', 2, 0),
(5, 'ITALIA-BELGICA', '2019-10-29 23:00:00', 3, 1),
(6, '200M VALLAS', '2019-10-30 23:00:00', 3, 2),
(7, 'BETIS-SEVILLA', '2019-10-18 22:00:00', 4, NULL);
CREATE TABLE `headquarter` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `budget` float(9,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `headquarter` (`id`, `name`, `budget`) VALUES
(1, 'Córdoba', 1000000.00),
(2, 'Sevilla', 2000000.00);
CREATE TABLE `multisportcenter` (
  `id_sportcomplex` int(11) NOT NULL,
  `information` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `multisportcenter` (`id_sportcomplex`, `information`) VALUES
(1, 'Lejos de la ciudad'),
(3, 'Bien comunicado');
CREATE TABLE `sportcenter` (
  `id_sportcomplex` int(11) NOT NULL,
  `sport` varchar(50) NOT NULL,
  `information` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `sportcenter` (`id_sportcomplex`, `sport`, `information`) VALUES
(2, 'Basket', 'Nada reseñable'),
(4, 'Fútbol', 'Musho Betis!');
CREATE TABLE `sportcomplex` (
  `id` int(11) NOT NULL,
  `location` varchar(50) NOT NULL,
  `boss` varchar(50) NOT NULL,
  `id_headquarter` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `sportcomplex` (`id`, `location`, `boss`, `id_headquarter`) VALUES
(1, 'Rabanales', 'Carlos', 1),
(2, 'Vistaalegre', 'Eva', 1),
(3, 'Estadio Olímpico', 'Pepe', 2),
(4, 'Estadio del Betis', 'Juan', 2);
ALTER TABLE `area`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_sportcomlex` (`id_multisportcenter`);
ALTER TABLE `comissioner_event`
  ADD PRIMARY KEY (`id`),
  ADD KEY `evento` (`id_event`),
  ADD KEY `comisario` (`id_comissioner`);
ALTER TABLE `commissioner`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `equipment`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `equipment_event`
  ADD PRIMARY KEY (`id`),
  ADD KEY `equipamiento` (`id_equipment`),
  ADD KEY `enero` (`id_event`);
ALTER TABLE `event`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_sportcomplex` (`id_sportcomplex`);
ALTER TABLE `headquarter`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `multisportcenter`
  ADD PRIMARY KEY (`id_sportcomplex`);
ALTER TABLE `sportcenter`
  ADD PRIMARY KEY (`id_sportcomplex`);
ALTER TABLE `sportcomplex`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sede` (`id_headquarter`);
ALTER TABLE `area`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
ALTER TABLE `comissioner_event`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
ALTER TABLE `commissioner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
ALTER TABLE `equipment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
ALTER TABLE `equipment_event`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
ALTER TABLE `event`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
ALTER TABLE `headquarter`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
ALTER TABLE `sportcomplex`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
ALTER TABLE `area`
  ADD CONSTRAINT `id_sportcomlex` FOREIGN KEY (`id_multisportcenter`) REFERENCES `multisportcenter` (`id_sportcomplex`) ON UPDATE CASCADE;
ALTER TABLE `comissioner_event`
  ADD CONSTRAINT `comisario` FOREIGN KEY (`id_comissioner`) REFERENCES `commissioner` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `evento` FOREIGN KEY (`id_event`) REFERENCES `event` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `equipment_event`
  ADD CONSTRAINT `enero` FOREIGN KEY (`id_event`) REFERENCES `event` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `equipamiento` FOREIGN KEY (`id_equipment`) REFERENCES `equipment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `event`
  ADD CONSTRAINT `id_sportcomplex` FOREIGN KEY (`id_sportcomplex`) REFERENCES `sportcomplex` (`id`);
ALTER TABLE `multisportcenter`
  ADD CONSTRAINT `complex` FOREIGN KEY (`id_sportcomplex`) REFERENCES `sportcomplex` (`id`);
ALTER TABLE `sportcenter`
  ADD CONSTRAINT `sededemono` FOREIGN KEY (`id_sportcomplex`) REFERENCES `sportcomplex` (`id`);
ALTER TABLE `sportcomplex`
  ADD CONSTRAINT `sede` FOREIGN KEY (`id_headquarter`) REFERENCES `headquarter` (`id`);
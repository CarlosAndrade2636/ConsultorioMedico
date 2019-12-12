-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-12-2019 a las 21:04:06
-- Versión del servidor: 10.4.8-MariaDB-log
-- Versión de PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `consultorio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citamedica`
--

CREATE TABLE `citamedica` (
  `idCita` int(11) NOT NULL,
  `fechaCita` date NOT NULL,
  `horaCita` time NOT NULL,
  `motivo` varchar(255) NOT NULL,
  `medico` int(11) NOT NULL,
  `paciente` int(11) NOT NULL,
  `estado` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consulrece`
--

CREATE TABLE `consulrece` (
  `idConsuRece` int(11) NOT NULL,
  `idReceta` int(11) NOT NULL,
  `idConsulta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultamedica`
--

CREATE TABLE `consultamedica` (
  `idConsulta` int(11) NOT NULL,
  `sintomas` varchar(255) NOT NULL,
  `diagnostico` varchar(255) NOT NULL,
  `presionArterial` varchar(255) NOT NULL,
  `frecuenciaCardiaca` varchar(255) NOT NULL,
  `frecuenciaRespiratoria` varchar(255) NOT NULL,
  `temperaturaCorporal` varchar(255) NOT NULL,
  `peso` varchar(255) NOT NULL,
  `talla` varchar(255) NOT NULL,
  `turno` int(11) NOT NULL,
  `cita` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamento`
--

CREATE TABLE `medicamento` (
  `idMedicina` int(11) NOT NULL,
  `nombreMedicina` varchar(255) NOT NULL,
  `tipoMedicina` varchar(255) NOT NULL,
  `fechaCaducidad` date NOT NULL,
  `dosis` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamentoreceta`
--

CREATE TABLE `medicamentoreceta` (
  `idMedRes` int(11) NOT NULL,
  `idMedicamento` int(11) NOT NULL,
  `idReceta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `idMedico` int(11) NOT NULL,
  `correoMedico` varchar(255) NOT NULL,
  `especialidadMedico` varchar(255) NOT NULL,
  `usuarioMedico` int(11) NOT NULL,
  `personaMedico` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL,
  `tipoSangre` varchar(255) NOT NULL,
  `lugarNac` varchar(255) NOT NULL,
  `etnia` varchar(255) NOT NULL,
  `personaPaciente` int(11) NOT NULL,
  `usuarioPaciente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idPerosona` int(11) NOT NULL,
  `cedula` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `fecha` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta`
--

CREATE TABLE `receta` (
  `idReceta` int(11) NOT NULL,
  `frecuenciaUso` varchar(500) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `idMedREs` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turno`
--

CREATE TABLE `turno` (
  `idTurno` int(11) NOT NULL,
  `fechaTurno` date NOT NULL,
  `horaTurno` time NOT NULL,
  `valor` double NOT NULL,
  `paciente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombreUsuario` varchar(255) NOT NULL,
  `passUsuario` varchar(255) NOT NULL,
  `rolUsuario` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citamedica`
--
ALTER TABLE `citamedica`
  ADD PRIMARY KEY (`idCita`),
  ADD KEY `citaMedico` (`medico`),
  ADD KEY `citaPaciente` (`paciente`);

--
-- Indices de la tabla `consulrece`
--
ALTER TABLE `consulrece`
  ADD PRIMARY KEY (`idConsuRece`),
  ADD KEY `consulreset` (`idConsulta`),
  ADD KEY `resetconsul` (`idReceta`);

--
-- Indices de la tabla `consultamedica`
--
ALTER TABLE `consultamedica`
  ADD PRIMARY KEY (`idConsulta`),
  ADD KEY `citaConsulta` (`cita`),
  ADD KEY `turnoConsulta` (`turno`);

--
-- Indices de la tabla `medicamento`
--
ALTER TABLE `medicamento`
  ADD PRIMARY KEY (`idMedicina`);

--
-- Indices de la tabla `medicamentoreceta`
--
ALTER TABLE `medicamentoreceta`
  ADD PRIMARY KEY (`idMedRes`),
  ADD KEY `recetaMedi` (`idReceta`),
  ADD KEY `medicaReceta` (`idMedicamento`);

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`idMedico`),
  ADD KEY `personaMedico` (`personaMedico`),
  ADD KEY `usuaruiMedico` (`usuarioMedico`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`idPaciente`),
  ADD KEY `personaPaciente` (`personaPaciente`),
  ADD KEY `usaurioPaciente` (`usuarioPaciente`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idPerosona`);

--
-- Indices de la tabla `receta`
--
ALTER TABLE `receta`
  ADD PRIMARY KEY (`idReceta`);

--
-- Indices de la tabla `turno`
--
ALTER TABLE `turno`
  ADD PRIMARY KEY (`idTurno`),
  ADD KEY `turnoPaciente` (`paciente`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citamedica`
--
ALTER TABLE `citamedica`
  MODIFY `idCita` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `consulrece`
--
ALTER TABLE `consulrece`
  MODIFY `idConsuRece` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `consultamedica`
--
ALTER TABLE `consultamedica`
  MODIFY `idConsulta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `medicamento`
--
ALTER TABLE `medicamento`
  MODIFY `idMedicina` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `medicamentoreceta`
--
ALTER TABLE `medicamentoreceta`
  MODIFY `idMedRes` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `medico`
--
ALTER TABLE `medico`
  MODIFY `idMedico` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `idPaciente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idPerosona` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `receta`
--
ALTER TABLE `receta`
  MODIFY `idReceta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `turno`
--
ALTER TABLE `turno`
  MODIFY `idTurno` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citamedica`
--
ALTER TABLE `citamedica`
  ADD CONSTRAINT `citaMedico` FOREIGN KEY (`medico`) REFERENCES `medico` (`idMedico`),
  ADD CONSTRAINT `citaPaciente` FOREIGN KEY (`paciente`) REFERENCES `paciente` (`idPaciente`);

--
-- Filtros para la tabla `consulrece`
--
ALTER TABLE `consulrece`
  ADD CONSTRAINT `consulreset` FOREIGN KEY (`idConsulta`) REFERENCES `consultamedica` (`idConsulta`),
  ADD CONSTRAINT `resetconsul` FOREIGN KEY (`idReceta`) REFERENCES `receta` (`idReceta`);

--
-- Filtros para la tabla `consultamedica`
--
ALTER TABLE `consultamedica`
  ADD CONSTRAINT `citaConsulta` FOREIGN KEY (`cita`) REFERENCES `citamedica` (`idCita`),
  ADD CONSTRAINT `turnoConsulta` FOREIGN KEY (`turno`) REFERENCES `turno` (`idTurno`);

--
-- Filtros para la tabla `medicamentoreceta`
--
ALTER TABLE `medicamentoreceta`
  ADD CONSTRAINT `medicaReceta` FOREIGN KEY (`idMedicamento`) REFERENCES `medicamento` (`idMedicina`),
  ADD CONSTRAINT `recetaMedi` FOREIGN KEY (`idReceta`) REFERENCES `receta` (`idReceta`);

--
-- Filtros para la tabla `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `personaMedico` FOREIGN KEY (`personaMedico`) REFERENCES `persona` (`idPerosona`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usuaruiMedico` FOREIGN KEY (`usuarioMedico`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD CONSTRAINT `personaPaciente` FOREIGN KEY (`personaPaciente`) REFERENCES `persona` (`idPerosona`),
  ADD CONSTRAINT `usaurioPaciente` FOREIGN KEY (`usuarioPaciente`) REFERENCES `usuario` (`idUsuario`);

--
-- Filtros para la tabla `turno`
--
ALTER TABLE `turno`
  ADD CONSTRAINT `turnoPaciente` FOREIGN KEY (`paciente`) REFERENCES `paciente` (`idPaciente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

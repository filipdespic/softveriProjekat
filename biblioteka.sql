-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: May 22, 2019 at 02:19 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `biblioteka`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
CREATE TABLE IF NOT EXISTS `administrator` (
  `SifraAdmina` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Ime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Prezime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `KorisnickoIme` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `KorisnickaLozinka` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`SifraAdmina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`SifraAdmina`, `Ime`, `Prezime`, `KorisnickoIme`, `KorisnickaLozinka`) VALUES
('21', 'Viktor', 'Despic', 'vik', '9f18dd541d5584cda47442d085f1ac5ded16b925'),
('333', 'Viktor', 'Despic', 'des', 'e9d596e7807a846bc76a51e845fcc844f24dfdaa');

-- --------------------------------------------------------

--
-- Table structure for table `clan`
--

DROP TABLE IF EXISTS `clan`;
CREATE TABLE IF NOT EXISTS `clan` (
  `SifraClana` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `JMBG` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Ime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Prezime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Telefon` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`SifraClana`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `clan`
--

INSERT INTO `clan` (`SifraClana`, `JMBG`, `Ime`, `Prezime`, `Telefon`, `Email`) VALUES
('1554902188', '1234561234562', 'Petar', 'Petrovic', '0622229934', 'petarpetrovic@mail.com'),
('15549021882', '4242426357461', 'Jelena', 'Jelic', '069885993', 'jelicmail@gmail.com'),
('1558443026', '1212123123123', 'Bojan', 'Rakovic', '0695969591', '123@mail.com'),
('1558443321', '0308885235654', 'Marko', 'Markovic', '0622224442', 'mmmm@mail.com'),
('1558444845', '1233222555666', 'Novak', 'Tomović', '0601113332', 'n.tomovic.91@mail.com'),
('423523523', '1234567890123', 'Viktor', 'Despić', '06652535353', 'despic.viktor@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `iznajmljivanje`
--

DROP TABLE IF EXISTS `iznajmljivanje`;
CREATE TABLE IF NOT EXISTS `iznajmljivanje` (
  `SifraIznajmljivanja` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `SifraPrimerka` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `SifraClana` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `SifraAdmina` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DatumIznajmljivanja` date NOT NULL,
  `DatumVracanja` date DEFAULT NULL,
  PRIMARY KEY (`SifraIznajmljivanja`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `iznajmljivanje`
--

INSERT INTO `iznajmljivanje` (`SifraIznajmljivanja`, `SifraPrimerka`, `SifraClana`, `SifraAdmina`, `DatumIznajmljivanja`, `DatumVracanja`) VALUES
('1557842616', '155784241575bfb077ae88074491ac33f7c3e14420d150afbf', '15549021882', '21', '2019-05-14', '2019-05-16'),
('1557842621', '155784242075bfb077ae88074491ac33f7c3e14420d150afbf', '1554902188', '21', '2019-05-14', NULL),
('1557842625', '155784251596631601269e781e5719161c9a619f3e20f57e0f', '423523523', '21', '2019-05-14', '1970-01-01'),
('1557842631', '15578425362a6ae85e1424679bf9b9c66ba5c204ce96c1dcca', '1554902188', '21', '2019-05-14', NULL),
('1558102473', '155784249096631601269e781e5719161c9a619f3e20f57e0f', '423523523', '21', '2019-05-17', '2019-05-17'),
('1558447838', '15578425660098fa895a11c1157e9c1797d479b2b757e0e8fe', '1558443028', '21', '2019-05-21', NULL),
('1558449717', '15578425660098fa895a11c1157e9c1797d479b2b757e0e8fe', '423523523', '21', '2019-05-21', NULL),
('1558449721', '15578425660098fa895a11c1157e9c1797d479b2b757e0e8fe', '423523523', '21', '2019-05-21', NULL),
('1558449727', '15578425660098fa895a11c1157e9c1797d479b2b757e0e8fe', '423523523', '21', '2019-05-21', NULL),
('1558523330', '155784239675bfb077ae88074491ac33f7c3e14420d150afbf', '423523523', '333', '2019-05-22', '2019-05-22'),
('1558523334', '155784249096631601269e781e5719161c9a619f3e20f57e0f', '423523523', '333', '2019-05-22', NULL),
('1558523337', '15578425452a6ae85e1424679bf9b9c66ba5c204ce96c1dcca', '423523523', '333', '2019-05-22', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `knjiga`
--

DROP TABLE IF EXISTS `knjiga`;
CREATE TABLE IF NOT EXISTS `knjiga` (
  `ISBN` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `NazivKnjige` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Autor` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `GodinaObjavljivanja` int(11) NOT NULL,
  PRIMARY KEY (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `knjiga`
--

INSERT INTO `knjiga` (`ISBN`, `NazivKnjige`, `Autor`, `GodinaObjavljivanja`) VALUES
('1231233213215', 'Roman o Londonu', 'Miloš Crnjanski', 1900),
('1231236667773', 'Mrtve Duše', 'Nikolaj Gogolj', 1900),
('1239872356734', 'Autobiografija', 'Bransilav Nušić', 1900),
('1981981892222', 'Seobe', 'Miloš Crnjanski', 1900),
('2221112222225', 'Kaputt', 'Kurcio malaparte', 1900),
('2223339999991', 'Ovako srećan narod', 'Radoje Domanović', 1900),
('2356126845', 'Stepski Vuk', 'Herman Hese', 1920),
('5552221111113', 'Proces', 'Franc Kafka', 1900),
('5556667772223', 'Nečista krv', 'Borisav Stanković', 1900),
('5556667772331', 'Berlin Aleksanderplac', 'Alfred Deblin', 1900),
('8877665544111', 'Blago Cara Radovana', 'Jovan Dučić', 1900),
('9998887774445', 'Pored puta', 'Ivo Andrić', 1900);

-- --------------------------------------------------------

--
-- Table structure for table `primerak`
--

DROP TABLE IF EXISTS `primerak`;
CREATE TABLE IF NOT EXISTS `primerak` (
  `SifraPrimerka` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ISBN` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Izdavac` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`SifraPrimerka`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `primerak`
--

INSERT INTO `primerak` (`SifraPrimerka`, `ISBN`, `Izdavac`) VALUES
('155784239675bfb077ae88074491ac33f7c3e14420d150afbf', '1231233213215', 'Laguna'),
('155784241575bfb077ae88074491ac33f7c3e14420d150afbf', '1231236667773', 'Laguna'),
('155784241775bfb077ae88074491ac33f7c3e14420d150afbf', '1239872356734', 'Laguna'),
('155784242075bfb077ae88074491ac33f7c3e14420d150afbf', '2221112222225', 'Laguna'),
('155784242475bfb077ae88074491ac33f7c3e14420d150afbf', '2223339999991', 'Laguna'),
('155784242775bfb077ae88074491ac33f7c3e14420d150afbf', '2356126845', 'Laguna'),
('155784242975bfb077ae88074491ac33f7c3e14420d150afbf', '5552221111113', 'Laguna'),
('155784243275bfb077ae88074491ac33f7c3e14420d150afbf', '5556667772223', 'Laguna'),
('155784243475bfb077ae88074491ac33f7c3e14420d150afbf', '5556667772331', 'Laguna'),
('155784243675bfb077ae88074491ac33f7c3e14420d150afbf', '8877665544111', 'Laguna'),
('155784243875bfb077ae88074491ac33f7c3e14420d150afbf', '8877665544111', 'Laguna'),
('155784244075bfb077ae88074491ac33f7c3e14420d150afbf', '9998887774445', 'Laguna'),
('155784249096631601269e781e5719161c9a619f3e20f57e0f', '1231233213215', 'Vulkan'),
('155784249396631601269e781e5719161c9a619f3e20f57e0f', '1231236667773', 'Vulkan'),
('155784249696631601269e781e5719161c9a619f3e20f57e0f', '1239872356734', 'Vulkan'),
('155784249996631601269e781e5719161c9a619f3e20f57e0f', '2221112222225', 'Vulkan'),
('155784250196631601269e781e5719161c9a619f3e20f57e0f', '2223339999991', 'Vulkan'),
('155784250396631601269e781e5719161c9a619f3e20f57e0f', '2356126845', 'Vulkan'),
('155784250696631601269e781e5719161c9a619f3e20f57e0f', '5552221111113', 'Vulkan'),
('155784251096631601269e781e5719161c9a619f3e20f57e0f', '5556667772223', 'Vulkan'),
('155784251296631601269e781e5719161c9a619f3e20f57e0f', '5556667772331', 'Vulkan'),
('155784251596631601269e781e5719161c9a619f3e20f57e0f', '8877665544111', 'Vulkan'),
('155784251896631601269e781e5719161c9a619f3e20f57e0f', '9998887774445', 'Vulkan'),
('15578425272a6ae85e1424679bf9b9c66ba5c204ce96c1dcca', '9998887774445', 'Delfi'),
('15578425302a6ae85e1424679bf9b9c66ba5c204ce96c1dcca', '8877665544111', 'Delfi'),
('15578425332a6ae85e1424679bf9b9c66ba5c204ce96c1dcca', '5556667772331', 'Delfi'),
('15578425362a6ae85e1424679bf9b9c66ba5c204ce96c1dcca', '5556667772223', 'Delfi'),
('15578425382a6ae85e1424679bf9b9c66ba5c204ce96c1dcca', '2223339999991', 'Delfi'),
('15578425412a6ae85e1424679bf9b9c66ba5c204ce96c1dcca', '1239872356734', 'Delfi'),
('15578425452a6ae85e1424679bf9b9c66ba5c204ce96c1dcca', '1231233213215', 'Delfi'),
('15578425660098fa895a11c1157e9c1797d479b2b757e0e8fe', '1231233213215', 'Agora Zrenjanin'),
('15578425680098fa895a11c1157e9c1797d479b2b757e0e8fe', '2223339999991', 'Agora Zrenjanin'),
('15578425700098fa895a11c1157e9c1797d479b2b757e0e8fe', '5556667772331', 'Agora Zrenjanin');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

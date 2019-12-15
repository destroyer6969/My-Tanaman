-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 16, 2019 at 08:07 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mytanaman`
--

-- --------------------------------------------------------

--
-- Table structure for table `informasi`
--

CREATE TABLE `informasi` (
  `nama` varchar(20) NOT NULL,
  `suhu_atas` float NOT NULL,
  `suhu_bawah` float NOT NULL,
  `cahaya_atas` float NOT NULL,
  `cahaya_bawah` float NOT NULL,
  `kelembaban_atas` float NOT NULL,
  `kelembaban_bawah` float NOT NULL,
  `tgl_tanam` date NOT NULL,
  `lama_cahaya` int(11) NOT NULL,
  `relay1` int(11) NOT NULL DEFAULT 0,
  `relay2` int(11) NOT NULL DEFAULT 0,
  `relay3` int(11) NOT NULL DEFAULT 0,
  `relay4` int(11) NOT NULL DEFAULT 0,
  `relay5` int(11) NOT NULL DEFAULT 0,
  `relay6` int(11) NOT NULL DEFAULT 0,
  `relay7` int(11) NOT NULL DEFAULT 0,
  `relay8` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `informasi`
--

INSERT INTO `informasi` (`nama`, `suhu_atas`, `suhu_bawah`, `cahaya_atas`, `cahaya_bawah`, `kelembaban_atas`, `kelembaban_bawah`, `tgl_tanam`, `lama_cahaya`, `relay1`, `relay2`, `relay3`, `relay4`, `relay5`, `relay6`, `relay7`, `relay8`) VALUES
('Bayam', 38, 30, 28, 24, 8, 15, '2019-10-07', 16, 1, 0, 0, 0, 0, 0, 0, 0),
('Sawi', 35, 25, 25, 20, 15, 10, '2019-10-01', 7, 1, 0, 0, 1, 1, 0, 0, 1),
('Tomat', 33, 27, 25, 20, 18, 8, '2019-10-04', 9, 1, 1, 0, 0, 0, 0, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `sensors`
--

CREATE TABLE `sensors` (
  `nama` varchar(50) NOT NULL,
  `suhu` float NOT NULL,
  `cahaya` float NOT NULL,
  `kelembaban` float NOT NULL,
  `sudah_disinari` float NOT NULL,
  `waktu` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sensors`
--

INSERT INTO `sensors` (`nama`, `suhu`, `cahaya`, `kelembaban`, `sudah_disinari`, `waktu`) VALUES
('Sawi', 32.685, 25.355, 17.32, 1.306, '2019-11-12 09:07:06'),
('Tomat', 31.131, 17.393, 5.075, 0.242, '2019-11-12 09:07:06'),
('Bayam', 30.52, 21.432, 12.038, 3.298, '2019-11-12 09:07:06');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `informasi`
--
ALTER TABLE `informasi`
  ADD PRIMARY KEY (`nama`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

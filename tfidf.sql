-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2022 at 10:38 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tfidf`
--

-- --------------------------------------------------------

--
-- Table structure for table `kalimat`
--

CREATE TABLE `kalimat` (
  `id` int(11) NOT NULL,
  `text` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kalimat`
--

INSERT INTO `kalimat` (`id`, `text`) VALUES
(1, 'bencana akan menambah susah rakyat'),
(2, 'polri berhasil mengevakuasi seorang warga cianjur'),
(3, 'turut berduka atas musibah gempa bumi cianjur'),
(4, 'korban gempa bumi cianjur jawa barat membutuhkan bantuan'),
(5, 'bantuan logistik korban gempa bumi cianjur terus mengalir'),
(6, 'polri lakukan penanganan gempa bumi cianjur'),
(7, 'warga cianjur korban gempa bumi mengeluh tidak ada pakaian'),
(8, 'warga mengeluhkan kesehatannya'),
(9, 'penggalangan bantuan korban gempa bumi cianjur berlangsung'),
(10, 'petugas menolong korban bencana gempa bumi cianjur tetap dilakukan');

-- --------------------------------------------------------

--
-- Table structure for table `kalimat2`
--

CREATE TABLE `kalimat2` (
  `id` int(11) NOT NULL,
  `teks` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kalimat2`
--

INSERT INTO `kalimat2` (`id`, `teks`) VALUES
(1, 'bencana akan menambah susah rakyat'),
(2, 'polri berhasil mengevakuasi seorang warga cianjur'),
(3, 'turut berduka atas musibah gempa bumi cianjur'),
(4, 'korban gempa bumi cianjur jawa barat membutuhkan bantuan'),
(5, 'bantuan logistik korban gempa bumi cianjur terus mengalir'),
(6, 'polri lakukan penanganan gempa bumi cianjur'),
(7, 'warga cianjur korban gempa bumi mengeluh tidak ada pakaian'),
(8, 'warga mengeluhkan kesehatannya'),
(9, 'penggalangan bantuan korban gempa bumi cianjur berlangsung'),
(10, 'petugas menolong korban bencana gempa bumi cianjur tetap dilakukan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kalimat`
--
ALTER TABLE `kalimat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kalimat2`
--
ALTER TABLE `kalimat2`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kalimat`
--
ALTER TABLE `kalimat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `kalimat2`
--
ALTER TABLE `kalimat2`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 12 Jul 2026 pada 18.08
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_klinik`
--

DELIMITER $$
--
-- Prosedur
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_tambah_pasien` (IN `p_nama` VARCHAR(100), IN `p_alamat` VARCHAR(150), IN `p_jenis` VARCHAR(20))   BEGIN
    INSERT INTO pasien(nama_pasien, alamat, jenis_pasien)
    VALUES(p_nama, p_alamat, p_jenis);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_tambah_pemeriksaan` (IN `p_id_pasien` INT, IN `p_keluhan` VARCHAR(200), IN `p_biaya` INT, IN `p_tanggal` DATE)   BEGIN
    INSERT INTO pemeriksaan(id_pasien, keluhan, biaya, tanggal)
    VALUES(p_id_pasien, p_keluhan, p_biaya, p_tanggal);
END$$

--
-- Fungsi
--
CREATE DEFINER=`root`@`localhost` FUNCTION `fn_total_pendapatan` () RETURNS INT(11) DETERMINISTIC BEGIN
    DECLARE total INT;

    SELECT IFNULL(SUM(biaya), 0)
    INTO total
    FROM pemeriksaan;

    RETURN total;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pasien`
--

CREATE TABLE `pasien` (
  `id_pasien` int(11) NOT NULL,
  `nama_pasien` varchar(150) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `jenis_pasien` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pasien`
--

INSERT INTO `pasien` (`id_pasien`, `nama_pasien`, `alamat`, `jenis_pasien`) VALUES
(1, 'Faisal', 'Sukabumi', 'BPJS'),
(2, 'Faisal A', 'Cicurug', 'Umum'),
(3, 'Arif', 'Sukabumi', 'BPJS');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemeriksaan`
--

CREATE TABLE `pemeriksaan` (
  `id_periksa` int(11) NOT NULL,
  `id_pasien` int(11) DEFAULT NULL,
  `keluhan` varchar(100) DEFAULT NULL,
  `biaya` int(11) DEFAULT NULL,
  `tanggal` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pemeriksaan`
--

INSERT INTO `pemeriksaan` (`id_periksa`, `id_pasien`, `keluhan`, `biaya`, `tanggal`) VALUES
(1, 1, 'kaki', 2000, '2026-03-03'),
(2, 3, 'demam', 100000, '2026-07-18');

--
-- Trigger `pemeriksaan`
--
DELIMITER $$
CREATE TRIGGER `trg_validasi_biaya` BEFORE INSERT ON `pemeriksaan` FOR EACH ROW BEGIN
    IF NEW.biaya < 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Biaya pemeriksaan tidak boleh negatif';
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vw_data_pemeriksaan`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vw_data_pemeriksaan` (
`id_periksa` int(11)
,`nama_pasien` varchar(150)
,`alamat` varchar(100)
,`jenis_pasien` varchar(30)
,`keluhan` varchar(100)
,`biaya` int(11)
,`tanggal` date
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vw_laporan_pendapatan`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vw_laporan_pendapatan` (
`id_periksa` int(11)
,`nama_pasien` varchar(150)
,`biaya` int(11)
,`tanggal` date
);

-- --------------------------------------------------------

--
-- Struktur untuk view `vw_data_pemeriksaan`
--
DROP TABLE IF EXISTS `vw_data_pemeriksaan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_data_pemeriksaan`  AS SELECT `p`.`id_periksa` AS `id_periksa`, `ps`.`nama_pasien` AS `nama_pasien`, `ps`.`alamat` AS `alamat`, `ps`.`jenis_pasien` AS `jenis_pasien`, `p`.`keluhan` AS `keluhan`, `p`.`biaya` AS `biaya`, `p`.`tanggal` AS `tanggal` FROM (`pemeriksaan` `p` join `pasien` `ps` on(`p`.`id_pasien` = `ps`.`id_pasien`)) ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vw_laporan_pendapatan`
--
DROP TABLE IF EXISTS `vw_laporan_pendapatan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_laporan_pendapatan`  AS SELECT `p`.`id_periksa` AS `id_periksa`, `ps`.`nama_pasien` AS `nama_pasien`, `p`.`biaya` AS `biaya`, `p`.`tanggal` AS `tanggal` FROM (`pemeriksaan` `p` join `pasien` `ps` on(`p`.`id_pasien` = `ps`.`id_pasien`)) ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`id_pasien`);

--
-- Indeks untuk tabel `pemeriksaan`
--
ALTER TABLE `pemeriksaan`
  ADD PRIMARY KEY (`id_periksa`),
  ADD KEY `id_pasien` (`id_pasien`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `pasien`
--
ALTER TABLE `pasien`
  MODIFY `id_pasien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `pemeriksaan`
--
ALTER TABLE `pemeriksaan`
  MODIFY `id_periksa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `pemeriksaan`
--
ALTER TABLE `pemeriksaan`
  ADD CONSTRAINT `pemeriksaan_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

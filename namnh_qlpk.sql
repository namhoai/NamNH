-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 12, 2018 at 10:51 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `namnh_qlpk`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_benhan`
--

CREATE TABLE `tbl_benhan` (
  `ID` int(10) NOT NULL,
  `BenhNhanID` int(10) NOT NULL,
  `KetQua` varchar(255) DEFAULT NULL,
  `KhamLS` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_benhan`
--

INSERT INTO `tbl_benhan` (`ID`, `BenhNhanID`, `KetQua`, `KhamLS`) VALUES
(1, 1, NULL, NULL),
(2, 2, NULL, NULL),
(3, 3, NULL, NULL),
(4, 4, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_benhnhan`
--

CREATE TABLE `tbl_benhnhan` (
  `ID` int(10) NOT NULL,
  `Ten` varchar(255) DEFAULT NULL,
  `Tuoi` int(10) NOT NULL,
  `SDT` varchar(255) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_benhnhan`
--

INSERT INTO `tbl_benhnhan` (`ID`, `Ten`, `Tuoi`, `SDT`, `DiaChi`) VALUES
(1, 'Nguyen Hoai Nam', 55, '01699542514', 'Ha Noi'),
(2, 'Truong Thanh Dung', 58, '0965877485', 'Ha Nam'),
(3, 'Hoang Trung Dung', 25, '0987452654', 'Ha Tinh'),
(4, 'Ho Trung Phong', 22, '0965841236', 'Quang Nam');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_buong`
--

CREATE TABLE `tbl_buong` (
  `ID` int(10) NOT NULL,
  `PhongKhamID` int(10) NOT NULL,
  `Ten` varchar(255) DEFAULT NULL,
  `ViTri` varchar(255) DEFAULT NULL,
  `Loai` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_buong`
--

INSERT INTO `tbl_buong` (`ID`, `PhongKhamID`, `Ten`, `ViTri`, `Loai`) VALUES
(1, 1, 'Phong Kham 01', '201-A1', 'Phong Kham'),
(2, 1, 'Phong Kham 02', '301-A2', 'Phong Kham'),
(3, 1, 'Xet Nghiem Mau 01', '201 - B2', 'Xet Nghiem'),
(4, 1, 'Xet Nghiem Nuoc Tieu', '202 - B2', 'Xet Nghiem'),
(5, 1, 'Chup XQuang', '205 - A4', 'Xet Nghiem'),
(6, 1, 'Xet Nghiem Mau 02', '206 - A1', 'Xet Nghiem');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_dangkykham`
--

CREATE TABLE `tbl_dangkykham` (
  `ID` int(10) NOT NULL,
  `BenhAnID` int(10) NOT NULL,
  `BuongID` int(10) NOT NULL,
  `TrangThai` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_dangkykham`
--

INSERT INTO `tbl_dangkykham` (`ID`, `BenhAnID`, `BuongID`, `TrangThai`) VALUES
(1, 1, 1, 'Cho Kham'),
(2, 4, 1, 'Cho Kham'),
(3, 2, 1, 'Dang Xet Nghiem');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_phieuxetnghiem`
--

CREATE TABLE `tbl_phieuxetnghiem` (
  `ID` int(10) NOT NULL,
  `BuongID` int(10) NOT NULL,
  `BenhAnID` int(10) NOT NULL,
  `XetNghiemID` int(10) NOT NULL,
  `KetQua` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_phieuxetnghiem`
--

INSERT INTO `tbl_phieuxetnghiem` (`ID`, `BuongID`, `BenhAnID`, `XetNghiemID`, `KetQua`) VALUES
(1, 3, 2, 1, 'Bình thường');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_thuoc`
--

CREATE TABLE `tbl_thuoc` (
  `ID` int(10) NOT NULL,
  `Ten` varchar(255) DEFAULT NULL,
  `MoTa` varchar(255) DEFAULT NULL,
  `Ma` varchar(255) DEFAULT NULL,
  `NhaSX` varchar(255) DEFAULT NULL,
  `Gia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_thuoc`
--

INSERT INTO `tbl_thuoc` (`ID`, `Ten`, `MoTa`, `Ma`, `NhaSX`, `Gia`) VALUES
(1, 'Diclo fenac', 'Thuoc Diclo fenac', '255445455', 'Dong Ha', 5000),
(2, 'Paracetamol', 'Thuoc Paracetamol', '25256645455', 'Dong Anh', 2000),
(3, 'Clorphenamin', 'thuoc clorphenamin', '125478965', 'Ha Nam', 6000),
(4, 'Alpha chymotrypsin', 'thuoc Alpha chymotrypsin', '25588855', 'Thai Ha', 4000),
(5, 'Meloxicama', 'thuoc Meloxicama', '65897411', 'Minh Anh', 3000);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_thuocdung`
--

CREATE TABLE `tbl_thuocdung` (
  `ID` int(10) NOT NULL,
  `BenhAnID` int(10) NOT NULL,
  `ThuocID` int(10) NOT NULL,
  `SoLuong` int(10) NOT NULL,
  `ChiPhi` float NOT NULL,
  `CachSD` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_thuocdung`
--

INSERT INTO `tbl_thuocdung` (`ID`, `BenhAnID`, `ThuocID`, `SoLuong`, `ChiPhi`, `CachSD`) VALUES
(1, 4, 3, 20, 120000, '2 vien/ngay');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_xetnghiem`
--

CREATE TABLE `tbl_xetnghiem` (
  `ID` int(10) NOT NULL,
  `Ten` varchar(255) DEFAULT NULL,
  `ChiPhi` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_xetnghiem`
--

INSERT INTO `tbl_xetnghiem` (`ID`, `Ten`, `ChiPhi`) VALUES
(1, 'Xet Nghiem Mau', 100000),
(2, 'Xet Nghiem Nuoc Tieu', 50000),
(3, 'Chup XQuang', 200000),
(4, 'Sieu Am', 60000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_benhan`
--
ALTER TABLE `tbl_benhan`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`),
  ADD UNIQUE KEY `ID_2` (`ID`),
  ADD UNIQUE KEY `ID_3` (`ID`),
  ADD KEY `FKtbl_BenhAn184273` (`BenhNhanID`);

--
-- Indexes for table `tbl_benhnhan`
--
ALTER TABLE `tbl_benhnhan`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`),
  ADD UNIQUE KEY `ID_2` (`ID`),
  ADD UNIQUE KEY `ID_3` (`ID`);

--
-- Indexes for table `tbl_buong`
--
ALTER TABLE `tbl_buong`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`),
  ADD UNIQUE KEY `ID_2` (`ID`),
  ADD UNIQUE KEY `ID_3` (`ID`);

--
-- Indexes for table `tbl_dangkykham`
--
ALTER TABLE `tbl_dangkykham`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`),
  ADD UNIQUE KEY `ID_2` (`ID`),
  ADD UNIQUE KEY `ID_3` (`ID`),
  ADD KEY `FKtbl_DangKy653629` (`BenhAnID`),
  ADD KEY `FKtbl_DangKy502956` (`BuongID`);

--
-- Indexes for table `tbl_phieuxetnghiem`
--
ALTER TABLE `tbl_phieuxetnghiem`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKtbl_PhieuX729848` (`BenhAnID`),
  ADD KEY `FKtbl_PhieuX91069` (`BuongID`),
  ADD KEY `FKtbl_PhieuX768249` (`XetNghiemID`);

--
-- Indexes for table `tbl_thuoc`
--
ALTER TABLE `tbl_thuoc`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`),
  ADD UNIQUE KEY `ID_2` (`ID`),
  ADD UNIQUE KEY `ID_3` (`ID`);

--
-- Indexes for table `tbl_thuocdung`
--
ALTER TABLE `tbl_thuocdung`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`),
  ADD UNIQUE KEY `ID_2` (`ID`),
  ADD UNIQUE KEY `ID_3` (`ID`),
  ADD KEY `FKtbl_ThuocD765171` (`BenhAnID`),
  ADD KEY `FKtbl_ThuocD411606` (`ThuocID`);

--
-- Indexes for table `tbl_xetnghiem`
--
ALTER TABLE `tbl_xetnghiem`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_benhan`
--
ALTER TABLE `tbl_benhan`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_benhnhan`
--
ALTER TABLE `tbl_benhnhan`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_buong`
--
ALTER TABLE `tbl_buong`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_dangkykham`
--
ALTER TABLE `tbl_dangkykham`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_phieuxetnghiem`
--
ALTER TABLE `tbl_phieuxetnghiem`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_thuoc`
--
ALTER TABLE `tbl_thuoc`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_thuocdung`
--
ALTER TABLE `tbl_thuocdung`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_xetnghiem`
--
ALTER TABLE `tbl_xetnghiem`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_benhan`
--
ALTER TABLE `tbl_benhan`
  ADD CONSTRAINT `FKtbl_BenhAn184273` FOREIGN KEY (`BenhNhanID`) REFERENCES `tbl_benhnhan` (`ID`);

--
-- Constraints for table `tbl_dangkykham`
--
ALTER TABLE `tbl_dangkykham`
  ADD CONSTRAINT `FKtbl_DangKy502956` FOREIGN KEY (`BuongID`) REFERENCES `tbl_buong` (`ID`),
  ADD CONSTRAINT `FKtbl_DangKy653629` FOREIGN KEY (`BenhAnID`) REFERENCES `tbl_benhan` (`ID`);

--
-- Constraints for table `tbl_phieuxetnghiem`
--
ALTER TABLE `tbl_phieuxetnghiem`
  ADD CONSTRAINT `FKtbl_PhieuX729848` FOREIGN KEY (`BenhAnID`) REFERENCES `tbl_benhan` (`ID`),
  ADD CONSTRAINT `FKtbl_PhieuX768249` FOREIGN KEY (`XetNghiemID`) REFERENCES `tbl_xetnghiem` (`ID`),
  ADD CONSTRAINT `FKtbl_PhieuX91069` FOREIGN KEY (`BuongID`) REFERENCES `tbl_buong` (`ID`);

--
-- Constraints for table `tbl_thuocdung`
--
ALTER TABLE `tbl_thuocdung`
  ADD CONSTRAINT `FKtbl_ThuocD411606` FOREIGN KEY (`ThuocID`) REFERENCES `tbl_thuoc` (`ID`),
  ADD CONSTRAINT `FKtbl_ThuocD765171` FOREIGN KEY (`BenhAnID`) REFERENCES `tbl_benhan` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

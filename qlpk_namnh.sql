-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 26, 2018 at 10:58 AM
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
-- Database: `qlpk_namnh`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_benhan`
--

CREATE TABLE `tbl_benhan` (
  `ID` int(10) NOT NULL,
  `BenhNhanID` int(10) NOT NULL,
  `BuongID` int(10) NOT NULL,
  `KetQua` varchar(255) DEFAULT NULL,
  `KhamLS` varchar(255) DEFAULT NULL,
  `TrangThai` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_benhan`
--

INSERT INTO `tbl_benhan` (`ID`, `BenhNhanID`, `BuongID`, `KetQua`, `KhamLS`, `TrangThai`) VALUES
(1, 1, 1, 'Tot', 'Binh Thuong', 'Cho Kham');

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
(1, 'Nguyen Hoai Nam', 55, '01254785414', 'Ha Noi'),
(2, 'Ho Trung Phong', 35, '02589745632', 'Ha Nam');

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
(1, 1, 'Phong Kham 01', '201-A2', 'Phong Kham'),
(2, 1, 'Buồng xét nghiệm máu - 01', '201 - B1', 'Xet Nghiem'),
(3, 1, 'Buồng xét nghiệm máu - 02', '301 - B2', 'Xet Nghiem'),
(4, 1, 'Buồng xét nghiệm nước tiểu - 01', '304 - B1', 'Xet Nghiem'),
(5, 1, 'Buồng xét nghiệm nước tiểu - 02', '204 - B2', 'Xet Nghiem'),
(6, 1, 'Chup X-Quang 01', '305-B3', 'Xet Nghiem');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_buong_xetnghiem`
--

CREATE TABLE `tbl_buong_xetnghiem` (
  `ID` int(10) NOT NULL,
  `XetNghiemID` int(10) NOT NULL,
  `BuongID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_buong_xetnghiem`
--

INSERT INTO `tbl_buong_xetnghiem` (`ID`, `XetNghiemID`, `BuongID`) VALUES
(1, 1, 2),
(2, 1, 3),
(3, 2, 4),
(4, 2, 5),
(5, 3, 6),
(6, 4, 6);

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
(4, 6, 1, 4, ''),
(6, 1, 1, 1, 'Tot'),
(7, 1, 1, 1, 'Tot');

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
(1, 'Thuoc 01', 'Thuoc 01', 'INT_3365', 'Ha Noi', 5000),
(2, 'Thuoc 02', 'Thuoc 02', 'INT_1115', 'Bao Thanh', 2000);

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
(3, 1, 2, 22, 44000, '1 viên/ngày'),
(8, 1, 1, 0, 0, NULL),
(12, 1, 1, 0, 0, NULL);

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
(1, 'Xét Nghiệm Máu', 50000),
(2, 'Xét Nghiêm Nước Tiểu', 20000),
(3, 'Chụp X-Quang tay', 200000),
(4, 'Chụp X-Quang chan', 300000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_benhan`
--
ALTER TABLE `tbl_benhan`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKtbl_BenhAn184273` (`BenhNhanID`),
  ADD KEY `FKtbl_BenhAn900973` (`BuongID`);

--
-- Indexes for table `tbl_benhnhan`
--
ALTER TABLE `tbl_benhnhan`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tbl_buong`
--
ALTER TABLE `tbl_buong`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tbl_buong_xetnghiem`
--
ALTER TABLE `tbl_buong_xetnghiem`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKtbl_Buong_228207` (`XetNghiemID`),
  ADD KEY `FKtbl_Buong_905387` (`BuongID`);

--
-- Indexes for table `tbl_phieuxetnghiem`
--
ALTER TABLE `tbl_phieuxetnghiem`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKtbl_PhieuX729848` (`BenhAnID`),
  ADD KEY `FKtbl_PhieuX768249` (`XetNghiemID`),
  ADD KEY `FKtbl_PhieuX91069` (`BuongID`);

--
-- Indexes for table `tbl_thuoc`
--
ALTER TABLE `tbl_thuoc`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tbl_thuocdung`
--
ALTER TABLE `tbl_thuocdung`
  ADD PRIMARY KEY (`ID`),
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
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_benhnhan`
--
ALTER TABLE `tbl_benhnhan`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_buong`
--
ALTER TABLE `tbl_buong`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_buong_xetnghiem`
--
ALTER TABLE `tbl_buong_xetnghiem`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_phieuxetnghiem`
--
ALTER TABLE `tbl_phieuxetnghiem`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_thuoc`
--
ALTER TABLE `tbl_thuoc`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_thuocdung`
--
ALTER TABLE `tbl_thuocdung`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

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
  ADD CONSTRAINT `FKtbl_BenhAn184273` FOREIGN KEY (`BenhNhanID`) REFERENCES `tbl_benhnhan` (`ID`),
  ADD CONSTRAINT `FKtbl_BenhAn900973` FOREIGN KEY (`BuongID`) REFERENCES `tbl_buong` (`ID`);

--
-- Constraints for table `tbl_buong_xetnghiem`
--
ALTER TABLE `tbl_buong_xetnghiem`
  ADD CONSTRAINT `FKtbl_Buong_228207` FOREIGN KEY (`XetNghiemID`) REFERENCES `tbl_xetnghiem` (`ID`),
  ADD CONSTRAINT `FKtbl_Buong_905387` FOREIGN KEY (`BuongID`) REFERENCES `tbl_buong` (`ID`);

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

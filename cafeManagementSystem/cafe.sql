-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 31, 2024 at 10:44 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cafe`
--
CREATE DATABASE IF NOT EXISTS `cafe` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `cafe`;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `prod_id` varchar(100) NOT NULL,
  `prodName` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double(10,2) NOT NULL,
  `date` date NOT NULL,
  `image` varchar(100) NOT NULL,
  `em_username` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `customer_id`, `prod_id`, `prodName`, `type`, `quantity`, `price`, `date`, `image`, `em_username`) VALUES
(63, 1, 'PROD-0001', 'Burgers', 'Meals', 2, 2.00, '2024-03-28', 'D:\\\\Red-Camellias.jpg', 'ADMIN'),
(64, 1, 'PROD-0002', 'Spaghetti', 'Meals', 3, 6.00, '2024-03-28', 'D:\\\\\\\\images (1).jpg', 'ADMIN'),
(65, 2, 'PROD-0001', 'Burgers', 'Meals', 3, 3.00, '2024-03-28', 'D:\\\\Red-Camellias.jpg', 'ADMIN'),
(66, 2, 'PROD-0002', 'Spaghetti', 'Meals', 3, 6.00, '2024-03-28', 'D:\\\\\\\\images (1).jpg', 'ADMIN'),
(67, 2, 'PROD-0003', 'Ice Tea', 'Drinks', 3, 1.68, '2024-03-28', 'D:\\\\\\\\download (2).jpg', 'ADMIN'),
(68, 2, 'PROD-0004', 'Coca cola', 'Drinks', 3, 1.50, '2024-03-28', 'D:\\\\phone bg.jpg', 'ADMIN'),
(69, 2, 'PROD-0005', 'Fried Egg', 'Meals', 5, 10.00, '2024-03-28', 'D:\\\\\\\\download.jpg', 'ADMIN'),
(70, 3, 'PROD-0001', 'Burgers', 'Meals', 4, 4.00, '2024-03-28', 'D:\\\\Red-Camellias.jpg', 'abuo'),
(71, 3, 'PROD-0002', 'Spaghetti', 'Meals', 4, 8.00, '2024-03-28', 'D:\\\\\\\\images (1).jpg', 'abuo'),
(72, 3, 'PROD-0003', 'Ice Tea', 'Drinks', 4, 2.24, '2024-03-28', 'D:\\\\\\\\download (2).jpg', 'abuo'),
(73, 3, 'PROD-0005', 'Fried Egg', 'Meals', 4, 8.00, '2024-03-28', 'D:\\\\\\\\download.jpg', 'abuo'),
(74, 3, 'PROD-0004', 'Coca cola', 'Drinks', 4, 2.00, '2024-03-28', 'D:\\\\phone bg.jpg', 'abuo'),
(76, 4, 'PROD-0006', 'Pizza', 'Meals', 3, 30.00, '2024-03-28', 'D:\\\\images.jpg', 'abuo'),
(77, 4, 'PROD-0005', 'Fried Egg', 'Meals', 3, 6.00, '2024-03-28', 'D:\\\\download (1).jpg', 'abuo'),
(78, 5, 'PROD-0006', 'Pizza', 'Meals', 2, 20.00, '2024-03-28', 'D:\\\\images.jpg', 'admin'),
(79, 5, 'PROD-0005', 'Fried Egg', 'Meals', 3, 6.00, '2024-03-28', 'D:\\\\download (1).jpg', 'admin'),
(80, 5, 'PROD-0002', 'Spaghetti', 'Meals', 3, 6.00, '2024-03-28', 'D:\\\\\\\\images (1).jpg', 'admin'),
(81, 6, 'PROD-0004', 'Coca cola', 'Drinks', 3, 1.50, '2024-03-29', 'D:\\\\phone bg.jpg', 'admin'),
(82, 6, 'PROD-0001', 'Burgers', 'Meals', 4, 4.00, '2024-03-29', 'D:\\\\Red-Camellias.jpg', 'admin'),
(83, 6, 'PROD-0002', 'Spaghetti', 'Meals', 4, 8.00, '2024-03-29', 'D:\\\\\\\\images (1).jpg', 'admin'),
(84, 6, 'PROD-0006', 'Pizza', 'Meals', 3, 30.00, '2024-03-29', 'D:\\\\images.jpg', 'admin'),
(85, 6, 'PROD-0003', 'Ice Tea', 'Drinks', 4, 2.24, '2024-03-29', 'D:\\\\\\\\download (2).jpg', 'admin'),
(86, 7, 'PROD-0004', 'Coca cola', 'Drinks', 3, 1.50, '2024-03-29', 'D:\\\\download (18).jpg', 'admin'),
(87, 7, 'PROD-0005', 'Fried Egg', 'Meals', 5, 10.00, '2024-03-29', 'D:\\\\download (19).jpg', 'admin'),
(88, 7, 'PROD-0006', 'Pizza', 'Meals', 3, 30.00, '2024-03-29', 'D:\\\\download (9).jpg', 'admin'),
(89, 7, 'PROD-0008', 'Malta', 'Drinks', 4, 28.00, '2024-03-29', 'D:\\\\\\\\download (10).jpg', 'admin'),
(90, 8, 'PROD-0004', 'Coca cola', 'Drinks', 5, 2.50, '2024-03-29', 'D:\\\\download (18).jpg', 'admin'),
(91, 8, 'PROD-0005', 'Fried Egg', 'Meals', 4, 8.00, '2024-03-29', 'D:\\\\download (19).jpg', 'admin'),
(92, 8, 'PROD-0006', 'Pizza', 'Meals', 4, 40.00, '2024-03-29', 'D:\\\\download (9).jpg', 'admin'),
(93, 8, 'PROD-0003', 'Ice Tea', 'Drinks', 5, 2.80, '2024-03-29', 'D:\\\\download (17).jpg', 'admin'),
(94, 9, 'PROD-0008', 'Malta', 'Drinks', 3, 21.00, '2024-03-29', 'D:\\\\\\\\download (10).jpg', 'ADMIN'),
(95, 9, 'PROD-0007', 'Jollof Rice', 'Meals', 4, 20.00, '2024-03-29', 'D:\\\\\\\\download (5).jpg', 'ADMIN'),
(96, 9, 'PROD-0004', 'Coca cola', 'Drinks', 3, 1.50, '2024-03-29', 'D:\\\\download (18).jpg', 'ADMIN'),
(97, 9, 'PROD-0001', 'Burgers', 'Meals', 4, 4.00, '2024-03-29', 'D:\\\\download (13).jpg', 'ADMIN'),
(98, 9, 'PROD-0005', 'Fried Egg', 'Meals', 3, 6.00, '2024-03-29', 'D:\\\\download (19).jpg', 'ADMIN'),
(99, 9, 'PROD-0002', 'Spaghetti', 'Meals', 4, 8.00, '2024-03-29', 'D:\\\\download (15).jpg', 'ADMIN'),
(100, 9, 'PROD-0003', 'Ice Tea', 'Drinks', 3, 1.68, '2024-03-29', 'D:\\\\download (17).jpg', 'ADMIN'),
(101, 10, 'PROD-0010', 'Fufu and groundnutsoup', 'Meals', 2, 20.00, '2024-03-30', 'D:\\\\\\\\download (2).jpg', 'admin'),
(102, 10, 'PROD-0007', 'Jollof Rice', 'Meals', 3, 15.00, '2024-03-30', 'D:\\\\\\\\download (5).jpg', 'admin'),
(103, 10, 'PROD-0004', 'Coca cola', 'Drinks', 2, 1.00, '2024-03-30', 'D:\\\\download (18).jpg', 'admin'),
(104, 10, 'PROD-0005', 'Fried Egg', 'Meals', 3, 6.00, '2024-03-30', 'D:\\\\download (19).jpg', 'admin'),
(105, 10, 'PROD-0009', 'Banku and Okra stew', 'Meals', 2, 10.00, '2024-03-30', 'D:\\\\\\\\Red-Camellias.jpg', 'admin'),
(106, 11, 'PROD-0008', 'Malta', 'Drinks', 3, 21.00, '2024-03-30', 'D:\\\\\\\\download (10).jpg', 'admin'),
(107, 11, 'PROD-0004', 'Coca cola', 'Drinks', 3, 12.00, '2024-03-30', 'D:\\\\download (18).jpg', 'admin'),
(108, 11, 'PROD-0005', 'Fried Egg', 'Meals', 3, 6.00, '2024-03-30', 'D:\\\\download (19).jpg', 'admin'),
(109, 12, 'PROD-0001', 'Burgers', 'Meals', 2, 2.00, '2024-04-01', 'D:\\\\download (13).jpg', 'admin'),
(110, 12, 'PROD-0002', 'Spaghetti', 'Meals', 3, 6.00, '2024-04-01', 'D:\\\\download (15).jpg', 'admin'),
(111, 12, 'PROD-0003', 'Ice Tea', 'Drinks', 3, 4.50, '2024-04-01', 'D:\\\\download (17).jpg', 'admin'),
(112, 12, 'PROD-0004', 'Coca cola', 'Drinks', 3, 12.00, '2024-04-01', 'D:\\\\download (18).jpg', 'admin'),
(113, 13, 'PROD-0001', 'Burgers', 'Meals', 3, 3.00, '2024-04-03', 'D:\\\\download (13).jpg', 'admin'),
(114, 13, 'PROD-0002', 'Spaghetti', 'Meals', 2, 4.00, '2024-04-03', 'D:\\\\download (15).jpg', 'admin'),
(115, 13, 'PROD-0003', 'Ice Tea', 'Drinks', 3, 4.50, '2024-04-03', 'D:\\\\download (17).jpg', 'admin'),
(116, 13, 'PROD-0004', 'Coca cola', 'Drinks', 2, 8.00, '2024-04-03', 'D:\\\\download (18).jpg', 'admin'),
(117, 14, 'PROD-0001', 'Burgers', 'Meals', 3, 3.00, '2024-04-04', 'D:\\\\download (13).jpg', 'admin'),
(118, 14, 'PROD-0002', 'Spaghetti', 'Meals', 4, 8.00, '2024-04-04', 'D:\\\\download (15).jpg', 'admin'),
(119, 14, 'PROD-0003', 'Ice Tea', 'Drinks', 4, 6.00, '2024-04-04', 'D:\\\\download (17).jpg', 'admin'),
(120, 14, 'PROD-0004', 'Coca cola', 'Drinks', 4, 16.00, '2024-04-04', 'D:\\\\download (18).jpg', 'admin'),
(121, 14, 'PROD-0005', 'Fried Egg', 'Meals', 4, 8.00, '2024-04-04', 'D:\\\\download (19).jpg', 'admin'),
(122, 14, 'PROD-0006', 'Pizza', 'Meals', 4, 40.00, '2024-04-04', 'D:\\\\download (9).jpg', 'admin'),
(123, 15, 'PROD-0001', 'Burgers', 'Meals', 3, 3.00, '2024-04-04', 'D:\\\\download (13).jpg', 'admin'),
(124, 15, 'PROD-0002', 'Spaghetti', 'Meals', 2, 4.00, '2024-04-04', 'D:\\\\download (15).jpg', 'admin'),
(125, 15, 'PROD-0003', 'Ice Tea', 'Drinks', 4, 6.00, '2024-04-04', 'D:\\\\download (17).jpg', 'admin'),
(126, 16, 'PROD-0004', 'Coca cola', 'Drinks', 4, 16.00, '2024-04-05', 'D:\\\\download (18).jpg', 'admin'),
(127, 16, 'PROD-0006', 'Pizza', 'Meals', 3, 30.00, '2024-04-05', 'D:\\\\download (9).jpg', 'admin'),
(128, 16, 'PROD-0008', 'Malta', 'Drinks', 3, 21.00, '2024-04-05', 'D:\\\\\\\\download (10).jpg', 'admin'),
(129, 16, 'PROD-0007', 'Jollof Rice', 'Meals', 5, 25.00, '2024-04-05', 'D:\\\\\\\\download (5).jpg', 'admin'),
(130, 17, 'PROD-0001', 'Burgers', 'Meals', 3, 3.00, '2024-04-05', 'D:\\\\download (13).jpg', 'ADMIN'),
(131, 17, 'PROD-0004', 'Coca cola', 'Drinks', 3, 12.00, '2024-04-05', 'D:\\\\download (18).jpg', 'ADMIN'),
(132, 17, 'PROD-0005', 'Fried Egg', 'Meals', 3, 6.00, '2024-04-05', 'D:\\\\download (19).jpg', 'ADMIN'),
(133, 18, 'PROD-0006', 'Pizza', 'Meals', 2, 20.00, '2024-04-09', 'D:\\\\download (9).jpg', 'admin'),
(134, 18, 'PROD-0005', 'Fried Egg', 'Meals', 3, 6.00, '2024-04-09', 'D:\\\\download (19).jpg', 'admin'),
(135, 19, 'PROD-0006', 'Pizza', 'Meals', 3, 30.00, '2024-04-09', 'D:\\\\download (9).jpg', 'admin'),
(136, 19, 'PROD-0005', 'Fried Egg', 'Meals', 2, 4.00, '2024-04-09', 'D:\\\\download (19).jpg', 'admin'),
(137, 19, 'PROD-0004', 'Coca cola', 'Drinks', 3, 12.00, '2024-04-09', 'D:\\\\download (18).jpg', 'admin'),
(138, 20, 'PROD-0001', 'Burgers', 'Meals', 3, 3.00, '2024-04-13', 'D:\\\\download (13).jpg', 'admin'),
(139, 20, 'PROD-0002', 'Spaghetti', 'Meals', 2, 4.00, '2024-04-13', 'D:\\\\download (15).jpg', 'admin'),
(140, 20, 'PROD-0003', 'Ice Tea', 'Drinks', 4, 6.00, '2024-04-13', 'D:\\\\download (17).jpg', 'admin'),
(141, 20, 'PROD-0006', 'Pizza', 'Meals', 3, 30.00, '2024-04-13', 'D:\\\\download (9).jpg', 'admin'),
(142, 20, 'PROD-0005', 'Fried Egg', 'Meals', 6, 12.00, '2024-04-13', 'D:\\\\download (19).jpg', 'admin'),
(143, 20, 'PROD-0004', 'Coca cola', 'Drinks', 4, 16.00, '2024-04-13', 'D:\\\\download (18).jpg', 'admin'),
(144, 20, 'PROD-0005', 'Fried Egg', 'Meals', 9, 18.00, '2024-04-13', 'D:\\\\\\\\download (19).jpg', 'admin'),
(145, 21, 'PROD-0001', 'Burgers', 'Meals', 3, 3.00, '2024-04-19', 'D:\\\\download (13).jpg', 'admin'),
(146, 21, 'PROD-0002', 'Spaghetti', 'Meals', 3, 6.00, '2024-04-19', 'D:\\\\download (15).jpg', 'admin'),
(147, 21, 'PROD-0003', 'Ice Tea', 'Drinks', 3, 4.50, '2024-04-19', 'D:\\\\download (17).jpg', 'admin'),
(148, 21, 'PROD-0005', 'Fried Egg', 'Meals', 2, 4.00, '2024-04-19', 'D:\\\\\\\\download (19).jpg', 'admin'),
(149, 21, 'PROD-0006', 'Pizza', 'Meals', 3, 30.00, '2024-04-19', 'D:\\\\download (9).jpg', 'admin'),
(150, 22, 'PROD-0002', 'Spaghetti', 'Meals', 3, 6.00, '2024-04-19', 'D:\\\\download (15).jpg', 'admin'),
(151, 22, 'PROD-0003', 'Ice Tea', 'Drinks', 4, 6.00, '2024-04-19', 'D:\\\\download (17).jpg', 'admin'),
(152, 22, 'PROD-0006', 'Pizza', 'Meals', 3, 30.00, '2024-04-19', 'D:\\\\download (9).jpg', 'admin'),
(153, 22, 'PROD-0008', 'Malta', 'Drinks', 3, 21.00, '2024-04-19', 'D:\\\\\\\\download (10).jpg', 'admin'),
(154, 23, 'PROD-0001', 'Burgers', 'Meals', 3, 3.00, '2024-05-03', 'D:\\\\download (13).jpg', 'ADMIN'),
(155, 23, 'PROD-0002', 'Spaghetti', 'Meals', 3, 6.00, '2024-05-03', 'D:\\\\download (15).jpg', 'ADMIN'),
(156, 23, 'PROD-0003', 'Ice Tea', 'Drinks', 2, 3.00, '2024-05-03', 'D:\\\\download (17).jpg', 'ADMIN'),
(157, 23, 'PROD-0006', 'Pizza', 'Meals', 4, 40.00, '2024-05-03', 'D:\\\\download (9).jpg', 'ADMIN'),
(158, 24, 'PROD-0004', 'Coca cola', 'Drinks', 4, 16.00, '2024-05-03', 'D:\\\\download (18).jpg', 'admin'),
(159, 24, 'PROD-0005', 'Fried Egg', 'Meals', 3, 6.00, '2024-05-03', 'D:\\\\\\\\download (19).jpg', 'admin'),
(160, 24, 'PROD-0008', 'Malta', 'Drinks', 4, 28.00, '2024-05-03', 'D:\\\\\\\\download (10).jpg', 'admin'),
(161, 24, 'PROD-0006', 'Pizza', 'Meals', 4, 40.00, '2024-05-03', 'D:\\\\download (9).jpg', 'admin'),
(162, 25, 'PROD-0005', 'Fried Egg', 'Meals', 4, 8.00, '2024-05-03', 'D:\\\\\\\\download (19).jpg', 'admin'),
(163, 25, 'PROD-0006', 'Pizza', 'Meals', 4, 40.00, '2024-05-03', 'D:\\\\download (9).jpg', 'admin'),
(164, 25, 'PROD-0008', 'Malta', 'Drinks', 5, 35.00, '2024-05-03', 'D:\\\\\\\\download (10).jpg', 'admin'),
(165, 26, 'PROD-0004', 'Coca cola', 'Drinks', 4, 16.00, '2024-05-06', 'D:\\\\download (18).jpg', 'admin'),
(166, 26, 'PROD-0001', 'Burgers', 'Meals', 5, 5.00, '2024-05-06', 'D:\\\\download (13).jpg', 'admin'),
(167, 26, 'PROD-0002', 'Spaghetti', 'Meals', 4, 8.00, '2024-05-06', 'D:\\\\download (15).jpg', 'admin'),
(168, 27, 'PROD-0001', 'Burgers', 'Meals', 5, 5.00, '2024-05-06', 'D:\\\\download (13).jpg', 'admin'),
(169, 27, 'PROD-0003', 'Ice Tea', 'Drinks', 4, 6.00, '2024-05-06', 'D:\\\\download (17).jpg', 'admin'),
(170, 27, 'PROD-0002', 'Spaghetti', 'Meals', 5, 10.00, '2024-05-06', 'D:\\\\download (15).jpg', 'admin'),
(171, 28, 'PROD-0001', 'Burgers', 'Meals', 3, 3.00, '2024-05-06', 'D:\\\\download (13).jpg', 'admin'),
(172, 28, 'PROD-0005', 'Fried Egg', 'Meals', 5, 10.00, '2024-05-06', 'D:\\\\\\\\download (19).jpg', 'admin'),
(173, 28, 'PROD-0008', 'Malta', 'Drinks', 5, 35.00, '2024-05-06', 'D:\\\\\\\\download (10).jpg', 'admin'),
(174, 28, 'PROD-0010', 'Fufu and groundnutsoup', 'Meals', 7, 70.00, '2024-05-06', 'D:\\\\\\\\download (2).jpg', 'admin'),
(180, 29, 'PROD-0001', 'Burgers', 'Meals', 4, 4.00, '2024-06-10', 'D:\\\\download (13).jpg', 'admin'),
(181, 29, 'PROD-0002', 'Spaghetti', 'Meals', 3, 6.00, '2024-06-10', 'D:\\\\download (15).jpg', 'admin'),
(182, 29, 'PROD-0001', 'Burgers', 'Meals', 3, 3.00, '2024-06-10', 'D:\\\\download (13).jpg', 'admin'),
(183, 29, 'PROD-0002', 'Spaghetti', 'Meals', 4, 8.00, '2024-06-10', 'D:\\\\download (15).jpg', 'admin'),
(184, 29, 'PROD-0008', 'Malta', 'Drinks', 4, 28.00, '2024-06-10', 'D:\\\\\\\\download (10).jpg', 'admin'),
(185, 29, 'PROD-0010', 'Fufu and groundnutsoup', 'Meals', 3, 30.00, '2024-06-10', 'D:\\\\\\\\download (2).jpg', 'admin'),
(186, 30, 'PROD-0006', 'Pizza', 'Meals', 8, 80.00, '2024-06-13', 'D:\\\\download (9).jpg', 'ADMIN'),
(187, 30, 'PROD-0001', 'Burgers', 'Meals', 3, 3.00, '2024-06-13', 'D:\\\\download (13).jpg', 'ADMIN'),
(188, 30, 'PROD-0004', 'Coca cola', 'Drinks', 3, 12.00, '2024-06-13', 'D:\\\\download (18).jpg', 'ADMIN'),
(189, 30, 'PROD-0007', 'Jollof Rice', 'Meals', 3, 15.00, '2024-06-13', 'D:\\\\\\\\download (5).jpg', 'ADMIN'),
(190, 31, 'PROD-0001', 'Burgers', 'Meals', 2, 2.00, '2024-06-17', 'D:\\\\download (13).jpg', 'admin'),
(191, 31, 'PROD-0002', 'Spaghetti', 'Meals', 3, 6.00, '2024-06-17', 'D:\\\\download (15).jpg', 'admin'),
(192, 31, 'PROD-0006', 'Pizza', 'Meals', 3, 30.00, '2024-06-17', 'D:\\\\download (9).jpg', 'admin'),
(193, 32, 'PROD-0001', 'Burgers', 'Meals', 4, 4.00, '2024-07-02', 'D:\\\\download (13).jpg', 'ADMIN'),
(194, 32, 'PROD-0007', 'Jollof Rice', 'Meals', 4, 20.00, '2024-07-02', 'D:\\\\\\\\download (5).jpg', 'ADMIN'),
(195, 32, 'PROD-0006', 'Pizza', 'Meals', 2, 20.00, '2024-07-02', 'D:\\\\download (9).jpg', 'ADMIN'),
(196, 33, 'PROD-0001', 'Burgers', 'Meals', 3, 3.00, '2024-07-10', 'D:\\\\download (13).jpg', 'ADMIN'),
(197, 33, 'PROD-0005', 'Fried Egg', 'Meals', 3, 6.00, '2024-07-10', 'D:\\\\\\\\download (19).jpg', 'ADMIN'),
(198, 34, 'PROD-0002', 'Spaghetti', 'Meals', 3, 6.00, '2024-07-26', 'D:\\\\download (15).jpg', 'admin'),
(199, 34, 'PROD-0003', 'Ice Tea', 'Drinks', 2, 3.00, '2024-07-26', 'D:\\\\download (17).jpg', 'admin'),
(200, 35, 'PROD-0003', 'Ice Tea', 'Drinks', 2, 3.00, '2024-07-26', 'D:\\\\download (17).jpg', 'admin'),
(201, 35, 'PROD-0002', 'Spaghetti', 'Meals', 3, 6.00, '2024-07-26', 'D:\\\\download (15).jpg', 'admin'),
(202, 35, 'PROD-0001', 'Burgers', 'Meals', 3, 3.00, '2024-07-26', 'D:\\\\download (13).jpg', 'admin'),
(203, 36, 'PROD-0001', 'Burgers', 'Meals', 3, 3.00, '2024-07-29', 'D:\\\\download (13).jpg', 'ADMIN'),
(204, 36, 'PROD-0002', 'Spaghetti', 'Meals', 3, 6.00, '2024-07-29', 'D:\\\\download (15).jpg', 'ADMIN'),
(205, 36, 'PROD-0002', 'Spaghetti', 'Meals', 3, 6.00, '2024-07-29', 'D:\\\\\\\\download (15).jpg', 'ADMIN'),
(206, 37, 'PROD-0001', 'Burgers', 'Meals', 2, 2.00, '2024-07-31', 'D:\\\\download (13).jpg', 'admin'),
(207, 37, 'PROD-0002', 'Spaghetti', 'Meals', 3, 6.00, '2024-07-31', 'D:\\\\\\\\download (15).jpg', 'admin'),
(208, 37, 'PROD-0003', 'Ice Tea', 'Drinks', 2, 3.00, '2024-07-31', 'D:\\\\download (17).jpg', 'admin'),
(209, 37, 'PROD-0006', 'Pizza', 'Meals', 2, 20.00, '2024-07-31', 'D:\\\\download (9).jpg', 'admin'),
(210, 38, 'PROD-0001', 'Burgers', 'Meals', 3, 3.00, '2024-07-31', 'D:\\\\download (13).jpg', 'admin'),
(211, 38, 'PROD-0001', 'Burgers', 'Meals', 3, 3.00, '2024-10-27', 'D:\\\\download (13).jpg', 'ADMIN'),
(212, 38, 'PROD-0002', 'Spaghetti', 'Meals', 2, 4.00, '2024-10-27', 'D:\\\\\\\\download (15).jpg', 'ADMIN'),
(213, 38, 'PROD-0003', 'Ice Tea', 'Drinks', 4, 6.00, '2024-10-27', 'D:\\\\download (17).jpg', 'ADMIN'),
(214, 39, 'PROD-0004', 'Coca cola', 'Drinks', 3, 12.00, '2024-10-30', 'D:\\\\download (18).jpg', 'admin'),
(215, 39, 'PROD-0001', 'Burgers', 'Meals', 3, 3.00, '2024-10-30', 'D:\\\\download (13).jpg', 'admin'),
(216, 39, 'PROD-0002', 'Spaghetti', 'Meals', 2, 4.00, '2024-10-30', 'D:\\\\\\\\download (15).jpg', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `question` varchar(100) NOT NULL,
  `answer` varchar(100) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `username`, `password`, `question`, `answer`, `date`) VALUES
(1, 'admin', 'admin111', 'What is your favorite color?', 'yellow', '2024-03-14'),
(2, 'admin01', 'testing123', 'What is your favorite food?', 'fufu', '2024-03-14'),
(3, 'Abuo', 'abuobernard', 'What is your birth date?', '1999', '2024-03-14');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `prod_id` varchar(100) NOT NULL,
  `prodName` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `stock` int(11) NOT NULL,
  `price` double(10,2) NOT NULL,
  `status` varchar(100) NOT NULL,
  `image` varchar(200) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `prod_id`, `prodName`, `type`, `stock`, `price`, `status`, `image`, `date`) VALUES
(2, 'PROD-0001', 'Burgers', 'Meals', 838, 1.00, 'Available', 'D:\\download (13).jpg', '2024-03-16'),
(3, 'PROD-0002', 'Spaghetti', 'Meals', 71, 2.00, 'Available', 'D:\\\\download (15).jpg', '2024-03-16'),
(4, 'PROD-0003', 'Ice Tea', 'Drinks', 919, 1.50, 'Available', 'D:\\download (17).jpg', '2024-03-16'),
(5, 'PROD-0004', 'Coca cola', 'Drinks', 490, 4.00, 'Available', 'D:\\download (18).jpg', '2024-03-16'),
(6, 'PROD-0005', 'Fried Egg', 'Meals', 920, 2.00, 'Available', 'D:\\\\download (19).jpg', '2024-03-22'),
(7, 'PROD-0006', 'Pizza', 'Meals', 937, 11.00, 'Available', 'D:\\download (9).jpg', '2024-03-28'),
(8, 'PROD-0007', 'Jollof Rice', 'Meals', 981, 5.00, 'Available', 'D:\\\\download (5).jpg', '2024-03-29'),
(9, 'PROD-0008', 'Malta', 'Drinks', 1466, 7.00, 'Available', 'D:\\\\download (10).jpg', '2024-03-29'),
(10, 'PROD-0009', 'Banku and Okra stew', 'Meals', 532, 5.00, 'Available', 'D:\\\\Red-Camellias.jpg', '2024-03-30'),
(11, 'PROD-0010', 'Fufu and groundnutsoup', 'Meals', 522, 10.00, 'Available', 'D:\\\\download (2).jpg', '2024-03-30');

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

CREATE TABLE `receipt` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `total` double(10,2) NOT NULL,
  `date` date NOT NULL,
  `em_username` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `receipt`
--

INSERT INTO `receipt` (`id`, `customer_id`, `total`, `date`, `em_username`) VALUES
(25, 1, 8.00, '2024-03-28', 'ADMIN'),
(26, 2, 22.18, '2024-03-28', 'ADMIN'),
(27, 3, 24.24, '2024-03-28', 'abuo'),
(28, 4, 36.00, '2024-03-28', 'abuo'),
(29, 5, 32.00, '2024-03-28', 'admin'),
(30, 6, 45.74, '2024-03-29', 'admin'),
(31, 7, 69.50, '2024-03-29', 'admin'),
(32, 8, 53.30, '2024-03-29', 'admin'),
(33, 9, 62.18, '2024-03-29', 'ADMIN'),
(34, 10, 52.00, '2024-03-30', 'admin'),
(35, 11, 39.00, '2024-03-30', 'admin'),
(36, 12, 24.50, '2024-04-01', 'admin'),
(37, 13, 19.50, '2024-04-03', 'admin'),
(38, 14, 81.00, '2024-04-04', 'admin'),
(39, 15, 13.00, '2024-04-04', 'admin'),
(40, 16, 92.00, '2024-04-05', 'admin'),
(41, 17, 21.00, '2024-04-05', 'ADMIN'),
(42, 18, 26.00, '2024-04-09', 'admin'),
(43, 19, 46.00, '2024-04-09', 'admin'),
(44, 20, 89.00, '2024-04-13', 'admin'),
(45, 21, 47.50, '2024-04-19', 'admin'),
(46, 22, 63.00, '2024-04-19', 'admin'),
(47, 23, 52.00, '2024-05-03', 'ADMIN'),
(48, 24, 90.00, '2024-05-03', 'admin'),
(49, 25, 83.00, '2024-05-03', 'admin'),
(50, 26, 29.00, '2024-05-06', 'admin'),
(51, 27, 21.00, '2024-05-06', 'admin'),
(52, 28, 118.00, '2024-05-06', 'admin'),
(53, 29, 79.00, '2024-06-10', 'admin'),
(54, 30, 110.00, '2024-06-13', 'ADMIN'),
(55, 31, 38.00, '2024-06-17', 'admin'),
(56, 32, 44.00, '2024-07-02', 'ADMIN'),
(57, 33, 9.00, '2024-07-10', 'ADMIN'),
(58, 34, 9.00, '2024-07-26', 'admin'),
(59, 35, 12.00, '2024-07-26', 'admin'),
(60, 36, 15.00, '2024-07-29', 'ADMIN'),
(61, 37, 31.00, '2024-07-31', 'admin'),
(62, 38, 16.00, '2024-10-27', 'ADMIN'),
(63, 39, 19.00, '2024-10-30', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=217;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `receipt`
--
ALTER TABLE `receipt`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

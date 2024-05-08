-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2024 at 02:25 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mindcare`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `idc` bigint(20) NOT NULL,
  `namec` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `categoryexercise`
--

CREATE TABLE `categoryexercise` (
  `category_id` bigint(20) NOT NULL,
  `benefits` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categoryexercise`
--

INSERT INTO `categoryexercise` (`category_id`, `benefits`, `description`, `title`) VALUES
(1, 'Tracks meditation progress over time, allows users to identify patterns or trends in their practice, helps monitor the effectiveness of different meditation techniques, and facilitates setting and achieving meditation goals.', 'This category would store data about each meditation session, including date and time, duration, type of meditation (e.g., mindfulness, guided meditation, focused attention), and any notes the user takes about their experience.', 'Meditation Session'),
(2, 'Provides users with a library of techniques to explore and learn from, allows for personalized practice based on individual needs and preferences, and offers educational content to deepen users\' understanding of meditation.', 'This category could store information about different meditation techniques, including instructions, benefits, variations, and resources (e.g., links to guided meditations or articles).', 'Meditation Technique'),
(3, ' Helps users identify how meditation affects their mood, allows for exploring the connection between meditation practice and emotional well-being, and provides insights into how meditation can be used to manage specific emotions.', ' This category would allow users to record their mood before, during, and after each meditation session. Options could include mood descriptors (calm, anxious, happy, etc.) or a rating scale.', 'Mood Tracking'),
(4, ' Enhances motivation and focus by providing users with a clear direction for their practice, allows for tracking progress towards goals, and helps users personalize their meditation journey based on their desired outcomes.', 'This category would enable users to set personal meditation goals, such as increasing focus, reducing stress, or improving sleep quality. Goals could have target durations, frequencies, or specific techniques to practice.', 'Meditation Goal'),
(5, 'Provides users with a curated collection of valuable resources to supplement their practice, allows for exploring different learning styles and materials, and keeps users engaged with meditation through ongoing exploration.', 'This category could store links to external resources that support meditation practice, such as guided meditations, articles on meditation techniques, or meditation apps.', 'Meditation Resource');

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `parent_comment_id` bigint(20) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `email_token`
--

CREATE TABLE `email_token` (
  `id` int(11) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `emailtoken` varchar(255) DEFAULT NULL,
  `expires_at` datetime(6) DEFAULT NULL,
  `validated_at` datetime(6) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `email_token`
--

INSERT INTO `email_token` (`id`, `created_at`, `emailtoken`, `expires_at`, `validated_at`, `user_id`) VALUES
(1, '2024-05-07 18:45:06.000000', '208731', '2024-05-07 19:00:06.000000', NULL, 1),
(2, '2024-05-07 18:47:10.000000', '928297', '2024-05-07 19:02:10.000000', NULL, 2);

-- --------------------------------------------------------

--
-- Table structure for table `email_token_seq`
--

CREATE TABLE `email_token_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `email_token_seq`
--

INSERT INTO `email_token_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `id_event` bigint(20) NOT NULL,
  `number_of_tickets` int(11) NOT NULL,
  `additional_notes` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `statuss` enum('Confirmed','On_Hold','Canceled','Completed') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `exercice`
--

CREATE TABLE `exercice` (
  `exercise_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `difficulty_level` enum('Beginner','Intermediate','Advanced') DEFAULT NULL,
  `duration` int(11) NOT NULL,
  `stress_level_reduction` enum('LEVEL_1','LEVEL_2','LEVEL_3','LEVEL_4','LEVEL_5','LEVEL_6') DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `categorie_category_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `exercice`
--

INSERT INTO `exercice` (`exercise_id`, `description`, `difficulty_level`, `duration`, `stress_level_reduction`, `title`, `categorie_category_id`) VALUES
(3, 'Silently repeat phrases of kindness and well-being towards yourself and loved ones.', 'Intermediate', 15, 'LEVEL_5', ' Loving-kindness Meditation', 2),
(4, 'Systematically bring your attention to different body parts, noticing any sensations without judgment.', 'Advanced', 20, 'LEVEL_6', 'Body Scan Meditation', 4),
(5, 'Tense and relax different muscle groups in a systematic way, focusing on the sensation of relaxation.', 'Intermediate', 20, 'LEVEL_5', ' Progressive Muscle Relaxation', 4);

-- --------------------------------------------------------

--
-- Table structure for table `exercice_posts`
--

CREATE TABLE `exercice_posts` (
  `exercice_exercise_id` bigint(20) NOT NULL,
  `posts_id` bigint(20) NOT NULL,
  `exercices_exercise_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `exercice_posts`
--

INSERT INTO `exercice_posts` (`exercice_exercise_id`, `posts_id`, `exercices_exercise_id`) VALUES
(3, 2, 3),
(4, 1, 4),
(5, 2, 5);

-- --------------------------------------------------------

--
-- Table structure for table `exercise_media`
--

CREATE TABLE `exercise_media` (
  `media_id` bigint(20) NOT NULL,
  `media_url` varchar(255) DEFAULT NULL,
  `exercice_exercise_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `exercise_media`
--

INSERT INTO `exercise_media` (`media_id`, `media_url`, `exercice_exercise_id`) VALUES
(2, 'Loving-kindnessMeditation.mp4', 3),
(3, 'BodyScanMeditation.mp4', 4);

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `id` bigint(20) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date_posted` datetime(6) DEFAULT NULL,
  `dislikes` int(11) NOT NULL,
  `image` mediumblob DEFAULT NULL,
  `likes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`id`, `author`, `content`, `date_posted`, `dislikes`, `image`, `likes`) VALUES
(1, 'zae', 'aze', '2024-05-16 18:50:06.000000', 15, NULL, 30),
(2, 'tes', 'aer', '2024-05-23 18:51:04.000000', 5, NULL, 140);

-- --------------------------------------------------------

--
-- Table structure for table `reclamation`
--

CREATE TABLE `reclamation` (
  `id` bigint(20) NOT NULL,
  `categorie` enum('Missing_Functionalities','Technical_Problems','Security','Support_and_Assitance','Performances') DEFAULT NULL,
  `date_soumission` date DEFAULT NULL,
  `description_reclamation` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` enum('NotProcessed','Processed') DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `reponse_reclamation`
--

CREATE TABLE `reponse_reclamation` (
  `id` bigint(20) NOT NULL,
  `contenu` varchar(255) DEFAULT NULL,
  `date_reponse` datetime(6) DEFAULT NULL,
  `status_reclamation` varchar(255) DEFAULT NULL,
  `reclamation_id` bigint(20) DEFAULT NULL,
  `id_user` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ressource`
--

CREATE TABLE `ressource` (
  `idr` bigint(20) NOT NULL,
  `date_creation` date DEFAULT NULL,
  `descriptionr` varchar(255) DEFAULT NULL,
  `disliked` bit(1) NOT NULL,
  `dislikes` int(11) NOT NULL,
  `liked` bit(1) NOT NULL,
  `likes` int(11) NOT NULL,
  `titler` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `category_idc` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `id_ticket` bigint(20) NOT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `recipient_email` varchar(255) DEFAULT NULL,
  `event_id_event` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `token`
--

CREATE TABLE `token` (
  `id` int(11) NOT NULL,
  `expired` bit(1) NOT NULL,
  `revoked` bit(1) NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  `token_type` enum('BEARER') DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `token`
--

INSERT INTO `token` (`id`, `expired`, `revoked`, `token`, `token_type`, `user_id`) VALUES
(1, b'1', b'1', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5ZXNtaW5lLmd1ZXNtaUBlc3ByaXQudG4iLCJpYXQiOjE3MTUxMDM5MDcsImV4cCI6MTcxNTE5MDMwN30.KhwNmRaWFE1hhI3Aru5wpks3xmFkSR1ZbzzJTTEguIc', 'BEARER', 1),
(2, b'1', b'1', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjb250YWN0QGVzcHJpdC50biIsImlhdCI6MTcxNTEwNDAzMSwiZXhwIjoxNzE1MTkwNDMxfQ.5F1AY8XxpxHRSxdD9tXCCKGk5VEThrOXY-MZjg84kh0', 'BEARER', 2),
(3, b'0', b'0', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQGVzcHJpdC50biIsImlhdCI6MTcxNTEwNDExNCwiZXhwIjoxNzE1MTkwNTE0fQ.Rtrb-IwPoi5Tt_WW4WHmH2XXwBCaKhGE7qfMYTf7WKo', 'BEARER', 1),
(4, b'1', b'1', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBlc3ByaXQudG4iLCJpYXQiOjE3MTUxMDY2MTAsImV4cCI6MTcxNTE5MzAxMH0.QV4SD-p0eoHIVRXlhCwMi3c4cTnzuaOrMyqrHf8LAGc', 'BEARER', 2),
(52, b'0', b'0', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBlc3ByaXQudG4iLCJpYXQiOjE3MTUxMjQ3MTQsImV4cCI6MTcxNTIxMTExNH0.w0mRxlWAD9r4ncJKL46La8EN-eQCR6x1nhoHVFuRzRI', 'BEARER', 2);

-- --------------------------------------------------------

--
-- Table structure for table `token_seq`
--

CREATE TABLE `token_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `token_seq`
--

INSERT INTO `token_seq` (`next_val`) VALUES
(151);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `mfa_enabled` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('User','Student','Teacher','Admin') DEFAULT NULL,
  `secret` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `enabled`, `firstname`, `lastname`, `mfa_enabled`, `password`, `role`, `secret`) VALUES
(1, 'user@esprit.tn', b'0', 'yesminee', 'guesmi', b'0', '$2a$10$0KliLtqrxYb/i3aRSEStr.a8fx5irr.FZf4dm9v09o1uJmITVQDje', 'User', NULL),
(2, 'admin@esprit.tn', b'0', 'yesminei', 'kdist', b'0', '$2a$10$LrPM/qL2w3gnSNqiITHTAuxnGAqlmvuQLPSkTE/xbuWq028S6Eqeq', 'Admin', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`idc`);

--
-- Indexes for table `categoryexercise`
--
ALTER TABLE `categoryexercise`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhvh0e2ybgg16bpu229a5teje7` (`parent_comment_id`),
  ADD KEY `FKs1slvnkuemjsq2kj4h3vhx7i1` (`post_id`);

--
-- Indexes for table `email_token`
--
ALTER TABLE `email_token`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_30aqr5ls0f8imnfj8e91aywa2` (`emailtoken`),
  ADD KEY `FKr09ag0ercq2i63an8pcxmh2bm` (`user_id`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`id_event`);

--
-- Indexes for table `exercice`
--
ALTER TABLE `exercice`
  ADD PRIMARY KEY (`exercise_id`),
  ADD KEY `FKmwqndvr341ik1n9hj3c4446nr` (`categorie_category_id`);

--
-- Indexes for table `exercice_posts`
--
ALTER TABLE `exercice_posts`
  ADD PRIMARY KEY (`exercice_exercise_id`,`posts_id`),
  ADD KEY `FK2vq2bijyhw8iwnbj6xgdc4b7f` (`posts_id`);

--
-- Indexes for table `exercise_media`
--
ALTER TABLE `exercise_media`
  ADD PRIMARY KEY (`media_id`),
  ADD KEY `FKrhhb00x327378fyxh4wxpkqbc` (`exercice_exercise_id`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKiod4880pxfa5hl47euap9jta7` (`user_id`);

--
-- Indexes for table `reponse_reclamation`
--
ALTER TABLE `reponse_reclamation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKngpbdesmqy22v8pq0d8k9uj9v` (`reclamation_id`),
  ADD KEY `FKm0d5myslh9d85kt95bw8jg2eh` (`id_user`);

--
-- Indexes for table `ressource`
--
ALTER TABLE `ressource`
  ADD PRIMARY KEY (`idr`),
  ADD KEY `FKka6do3b3q5jpgy5ojjdl89atm` (`category_idc`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id_ticket`),
  ADD KEY `FKprlob3l0peaou5s63mwl5mvbd` (`event_id_event`);

--
-- Indexes for table `token`
--
ALTER TABLE `token`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe32ek7ixanakfqsdaokm4q9y2` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `idc` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `categoryexercise`
--
ALTER TABLE `categoryexercise`
  MODIFY `category_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `id_event` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `exercice`
--
ALTER TABLE `exercice`
  MODIFY `exercise_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `exercise_media`
--
ALTER TABLE `exercise_media`
  MODIFY `media_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=146;

--
-- AUTO_INCREMENT for table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reponse_reclamation`
--
ALTER TABLE `reponse_reclamation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ressource`
--
ALTER TABLE `ressource`
  MODIFY `idr` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id_ticket` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FKhvh0e2ybgg16bpu229a5teje7` FOREIGN KEY (`parent_comment_id`) REFERENCES `comment` (`id`),
  ADD CONSTRAINT `FKs1slvnkuemjsq2kj4h3vhx7i1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`);

--
-- Constraints for table `email_token`
--
ALTER TABLE `email_token`
  ADD CONSTRAINT `FKr09ag0ercq2i63an8pcxmh2bm` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `exercice`
--
ALTER TABLE `exercice`
  ADD CONSTRAINT `FKmwqndvr341ik1n9hj3c4446nr` FOREIGN KEY (`categorie_category_id`) REFERENCES `categoryexercise` (`category_id`);

--
-- Constraints for table `exercice_posts`
--
ALTER TABLE `exercice_posts`
  ADD CONSTRAINT `FK2vq2bijyhw8iwnbj6xgdc4b7f` FOREIGN KEY (`posts_id`) REFERENCES `post` (`id`),
  ADD CONSTRAINT `FKsxwih17akiv6qla9livxm2vy1` FOREIGN KEY (`exercice_exercise_id`) REFERENCES `exercice` (`exercise_id`);

--
-- Constraints for table `exercise_media`
--
ALTER TABLE `exercise_media`
  ADD CONSTRAINT `FKrhhb00x327378fyxh4wxpkqbc` FOREIGN KEY (`exercice_exercise_id`) REFERENCES `exercice` (`exercise_id`);

--
-- Constraints for table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `FKiod4880pxfa5hl47euap9jta7` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `reponse_reclamation`
--
ALTER TABLE `reponse_reclamation`
  ADD CONSTRAINT `FKm0d5myslh9d85kt95bw8jg2eh` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKngpbdesmqy22v8pq0d8k9uj9v` FOREIGN KEY (`reclamation_id`) REFERENCES `reclamation` (`id`);

--
-- Constraints for table `ressource`
--
ALTER TABLE `ressource`
  ADD CONSTRAINT `FKka6do3b3q5jpgy5ojjdl89atm` FOREIGN KEY (`category_idc`) REFERENCES `category` (`idc`);

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `FKprlob3l0peaou5s63mwl5mvbd` FOREIGN KEY (`event_id_event`) REFERENCES `event` (`id_event`);

--
-- Constraints for table `token`
--
ALTER TABLE `token`
  ADD CONSTRAINT `FKe32ek7ixanakfqsdaokm4q9y2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

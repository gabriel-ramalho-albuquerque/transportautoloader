-- transportation.location definition

CREATE TABLE `location` (
  `id` bigint NOT NULL,
  `borough` varchar(255) DEFAULT NULL,
  `service_zone` varchar(255) DEFAULT NULL,
  `zone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- transportation.trip_type definition

CREATE TABLE `trip_type` (
  `id` bigint NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO trip_type (id, type)
VALUES (1, 'yellow');

INSERT INTO trip_type (id, type)
VALUES (2, 'green');


-- transportation.seq definition

CREATE TABLE `seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO seq (next_val)
VALUES (1);


-- transportation.trip definition

CREATE TABLE `trip` (
  `id` bigint NOT NULL,
  `dropoff_datetime` date DEFAULT NULL,
  `dropoff_location_id` bigint NOT NULL,
  `passenger_count` int NOT NULL,
  `pickup_datetime` date DEFAULT NULL,
  `pickup_location_id` bigint NOT NULL,
  `rate_code_id` bigint NOT NULL,
  `store_and_fwd_flag` varchar(255) DEFAULT NULL,
  `trip_distance` varchar(255) DEFAULT NULL,
  `trip_type_id` bigint NOT NULL,
  `vendor_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK45mfehmkhyuk8evp7pj9bhs0b` (`dropoff_location_id`),
  KEY `FKo98jyh3oh9uyj51pcroyqg7hd` (`pickup_location_id`),
  KEY `FKsdsjy32366uyj51pcroyqg7sd` (`trip_type_id`),
  CONSTRAINT `FK45mfehmkhyuk8evp7pj9bhs0b` FOREIGN KEY (`dropoff_location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `FKo98jyh3oh9uyj51pcroyqg7hd` FOREIGN KEY (`pickup_location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `FKsdsjy32366uyj51pcroyqg7sd` FOREIGN KEY (`trip_type_id`) REFERENCES `trip_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
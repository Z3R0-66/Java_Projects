CREATE TABLE hotelmanagement.`cu_reservations` (
  `id` int(11) NOT NULL,
  `Guest_id` int(11) NOT NULL,
  `room_type` varchar(20) NOT NULL,
  `no_of_rooms` int(3) NOT NULL,
  `no_of_days` int(3) NOT NULL,
  `book_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `check_in` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `check_out` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `bill` double NOT NULL,
  `status` varchar(15) NOT NULL DEFAULT 'checked in'
);

--
-- Dumping data for table `cu_reservations`
--

INSERT INTO hotelmanagement.`cu_reservations` (`id`, `Guest_id`, `room_type`, `no_of_rooms`, `no_of_days`, `book_date`, `check_in`, `check_out`, `bill`, `status`) VALUES
(2, 5, 'Single Room', 2, 3, '2020-04-10 19:42:21', '2020-04-10 19:42:21', '2020-04-10 20:50:46', 18, 'checked out'),
(3, 6, 'Deluxe', 2, 3, '2020-04-10 19:57:03', '2020-04-10 19:57:03', '2020-04-10 19:57:03', 6, 'checked in'),
(4, 7, 'PentHouse', 2, 4, '2020-04-11 03:19:48', '2020-04-11 03:19:48', '2020-04-11 03:19:48', 64000, 'checked in'),
(5, 8, 'Deluxe', 3, 3, '2020-04-11 03:24:53', '2020-04-11 03:24:53', '2020-04-11 03:24:53', 45000, 'checked in'),
(6, 9, 'double', 2, 2, '2020-04-11 03:35:47', '2020-04-11 03:35:47', '2020-04-11 03:35:47', 12000, 'checked in');

-- --------------------------------------------------------

--
-- Table structure for table `guest_details`
--

CREATE TABLE hotelmanagement.`guest_details` (
  `id` int(11) NOT NULL,
  `title` varchar(30) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `address` text NOT NULL,
  `phone` int(12) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `guest_details`
--

INSERT INTO hotelmanagement.`guest_details` (`id`, `title`, `first_name`, `last_name`, `address`, `phone`, `email`) VALUES
(5, 'asd', 'adsf', 'sad', 'ads', 123, 'sad'),
(6, 'neon', 'sumair', 'tahir', 'karachi', 12123, 'xyz@gmail.com'),
(7, 'none', 'Faseeh', 'Tahir', 'jamshoro', 12736, 'abc@gmail.com'),
(8, 'none', 'test', 'test', 'test', 123, 'test@gmai.com'),
(9, 'raza', 'raza', 'mjh', 'ggh', 324432, 'nbn@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE hotelmanagement.`login` (
  `id` int(11) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO hotelmanagement.`login` (`id`, `password`) VALUES
(1, '1234'),
(2, '1001');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE hotelmanagement.`room` (
  `id` int(11) NOT NULL,
  `type` varchar(20) NOT NULL,
  `rate` int(10) NOT NULL,
  `no_of_rooms` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

INSERT INTO hotelmanagement.`room` (`id`, `type`, `rate`, `no_of_rooms`) VALUES
(1, 'Deluxe', 5000, 5),
(2, 'double', 3000, 13),
(3, 'Single ', 2000, 18),
(4, 'PentHouse', 8000, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cu_reservations`
--
ALTER TABLE hotelmanagement.`cu_reservations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `guest_details`
--
ALTER TABLE hotelmanagement.`guest_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE hotelmanagement.`login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `room`
--
ALTER TABLE hotelmanagement.`room`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cu_reservations`
--
ALTER TABLE hotelmanagement.`cu_reservations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `guest_details`
--
ALTER TABLE hotelmanagement.`guest_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE hotelmanagement.`login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE hotelmanagement.`room`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;
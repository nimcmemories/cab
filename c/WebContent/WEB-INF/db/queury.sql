--nitin

insert into cbhelpers(helperid,name,subentityid) values(100,'com.cab.helper.CityNameListHelper',3);
insert into cbevents values(100,0,100);

insert into cbhelpers values(101,'com.cab.helper.AreaNameListHelper',3);
insert into cbevents values(101,0,101);
 
insert into cbhelpers values(102,'com.cab.helper',3);
insert into cbevents values(102,1,102);	

--amit

insert into cbhelpers value(200,'com.cab.taxi.helper.AddDriverHelper',3);
insert into cbevents values(200,1,200);
INSERT INTO `taxi`.`partner_details` (`partner_type_id`, `partner_tittle`, `first_name`, `last_name`, `partner_mobile`, `partner_email`, `partner_password`) VALUES ('1', 'SamrtSense', 'Nitin', 'vavdiya', '99985556611', 'nitinvavdiya@gmail.com', 'nitin');

insert into cbhelpers value(201,'com.cab.taxi.helper.EditDriverHelper',3);
insert into cbevents values(201,1,201);

insert into cbhelpers value(202,'com.cab.taxi.helper.TaxiPtopHelper',3);
insert into cbevents values(202,1,202);

insert into cbhelpers value(203,'com.cab.taxi.helper.AddTaxiDetailsHelper',3);
insert into cbevents values(203,1,203);

insert into cbhelpers value(204,'com.cab.taxi.helper.AddBusDetailsHelper',3);
insert into cbevents values(204,1,204);

insert into cbhelpers value(205,'com.cab.taxi.helper.AddBikeDetailsHelper',3);
insert into cbevents values(205,1,205);

--nitin for p to p
--new table for airport details

DROP TABLE IF EXISTS `airport_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `airport_details` (
  `airport_id` int(11) NOT NULL AUTO_INCREMENT,
  `airport_name` varchar(100) NOT NULL,
  `city_master_id` int(11) NOT NULL,
  `is_enable` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`airport_id`),
  KEY `FK` (`city_master_id`),
  CONSTRAINT `fk_airport_details_1` FOREIGN KEY (`city_master_id`) REFERENCES `city_master` (`city_master_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

---new tabl
CREATE TABLE `taxi`.`package_details` (
  `package_details_id` INT NOT NULL AUTO_INCREMENT,
  `package_name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`package_details_id`));
  
  ---new table
  
  DROP TABLE IF EXISTS `package_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `package_transaction` (
  `package_transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `package_details_id` int(11) NOT NULL,
  `customer_registration_id` int(11) NOT NULL,
  `pickup_area_master_id` int(11) NOT NULL,
  `partner_details_id` int(11) NOT NULL,
  `taxi_details_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `pickup_time` time NOT NULL,
  `pickup_address` text NOT NULL,
  `note` text NOT NULL,
  `estimate_cost` double NOT NULL,
  `estimate_km` double NOT NULL,
  `estimate_time` time NOT NULL,
  PRIMARY KEY (`package_transaction_id`),
  KEY `FK1` (`package_details_id`),
  KEY `FK2` (`customer_registration_id`),
  KEY `FK3` (`pickup_area_master_id`),
  KEY `FK4` (`partner_details_id`),
  KEY `FK5` (`taxi_details_id`),
  CONSTRAINT `fk_package_transaction_1` FOREIGN KEY (`package_details_id`) REFERENCES `package_details` (`package_details_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_package_transaction_2` FOREIGN KEY (`customer_registration_id`) REFERENCES `customer_registration` (`customer_registration_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_package_transaction_3` FOREIGN KEY (`pickup_area_master_id`) REFERENCES `area_master` (`area_master_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_package_transaction_4` FOREIGN KEY (`partner_details_id`) REFERENCES `partner_details` (`partner_details_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_package_transaction_5` FOREIGN KEY (`taxi_details_id`) REFERENCES `taxi_details` (`taxi_details_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;




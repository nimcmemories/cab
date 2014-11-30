--no need for old query as amit submit new database

insert into cbhelpers (helperid,name,subentityid) values(104,'com.cab.partner.PartnerLoginHelper',3);
insert into cbevents(eventid,eventtype,helperid) values(104,0,104);

CREATE TABLE `taxi`.`cbresponse_details` (
  `cbresponse_details_id` INT NOT NULL AUTO_INCREMENT,
  `eventid` INT NOT NULL,
  `status` INT NULL,
  `url` VARCHAR(100) NULL,
  `msg` VARCHAR(100) NULL,
  PRIMARY KEY (`cbresponse_details_id`),
  INDEX `FK` (`eventid` ASC),
  CONSTRAINT `fk_cbresponse_details_1`
    FOREIGN KEY (`eventid`)
    REFERENCES `taxi`.`cbevents` (`eventid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

insert into cbhelpers (helperid,name,subentityid) values(206,'com.cab.customer.AirportListHelper',3);
insert into cbevents(eventid,eventtype,helperid) values(206,0,206);
--adding bike
insert into cbhelpers (helperid,name,subentityid) values(105,'com.cab.partner.BikeHelper',3);
insert into cbevents(eventid,eventtype,helperid) values(105,1,105);
insert into cbevents(eventid,eventtype,helperid) values(106,0,105);

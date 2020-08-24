/*
In MySQL, there is no equivalent of making SEQUENCE as in oracle.

So creating two tables with single column respectively which will 
be auto incremented by 1 and start with the given value. It will work like a sequence generator.
*/

CREATE TABLE IF NOT EXISTS SalesIdSeq (SalesId INTEGER PRIMARY KEY AUTO_INCREMENT) AUTO_INCREMENT = 1000;

CREATE TABLE IF NOT EXISTS MobileIdSeq (MobileId INTEGER PRIMARY KEY AUTO_INCREMENT) AUTO_INCREMENT = 1004;

/*
> The "AUTO_INCREMENT = 1000" sets the initial value of the sequence = 1000

> MobileIdSeq starts from 1004 because 3 values are inserted initially
*/

CREATE TABLE IF NOT EXISTS Stock (
	MobileId VARCHAR(6) PRIMARY KEY,
	Brand VARCHAR(12),
	MobileName VARCHAR(20) UNIQUE,
	QuantityOnHand INTEGER CHECK(QuantityOnHand >= 0),
	UnitPrice DECIMAL(9,2) CHECK(UnitPrice > 0)
);

CREATE TABLE IF NOT EXISTS Sales (
	SalesId VARCHAR(6) PRIMARY KEY, 
	SalesDate DATE,
	MobileId VARCHAR(6) REFERENCES Stock(MobileId),
	QuantitySold INTEGER CHECK(QuantitySold >= 0),
	SalesPricePerUnit DECIMAL(9,2) CHECK(SalesPricePerUnit > 0)
);

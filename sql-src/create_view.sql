CREATE VIEW SalesReport
	AS SELECT SalesId,
		SalesDate,
		Brand,
		MobileId,
		MobileName, 
		QuantitySold,
		UnitPrice,
		SalesPricePerUnit, 
		(SalesPricePerUnit - UnitPrice) AS ProfitPerUnit,
		((SalesPricePerUnit - UnitPrice) * QuantitySold) AS TotalProfit
	FROM Stock NATURAL JOIN Sales
	ORDER BY TotalProfit DESC,
			SalesID ASC;

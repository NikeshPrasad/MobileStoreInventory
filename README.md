# Mobile Store Inventory

This is a console based java project to manage a mobile store inventory and sales. We will use JDBC with MySQL database for various operations which includes:
* Adding, removing, updating and deleting mobiles from inventory.
* Record the details of the sales.
* Display a report of all sales.

## Tools:
* Java 11 (J2SE)
* MySQL CLI
* MySQL Connector
* Eclipse IDE

## SQL source files
The sql source files are included in sql-src directory and to be executed in this order:
1. create_table.sql
2. create_sequence.sql
3. create_view.sql
4. insert_values.sql

To execute the files from MySQL CLI change to the required database and issue command:
```
mysql> source /path/to/file.sql
```

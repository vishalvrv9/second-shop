## Second-Shop

Instructions to run application.


- The project is also hosted on github https://github.com/vishalvrv9/second-shop. Can be cloned from there as well.
- Import app into eclipse
- Load java-fx sdk and libraries into the build path
- Install mysql in your system and start a db instance
- In the utils.ConnectionUtil class look for the below constants
```
	private static final String DB_URL = "jdbc:mysql://localhost:3306/secondshop";
	private static final String USER = "";
	private static final String PASS = "";
```
- And change their values as per your database instance
- Use the second-shop.sql file in the root directory to generate the schema on mysql
- Add below as VM Arguments
```
	--module-path "Path to javafx sdk" --add-modules javafx.controls,javafx.fxml,javafx.swing
```
- Run the application.

package in.skyline.util;

 
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class JdbcUtil {
public static Connection jdbcConnection() throws IOException, SQLException {
	
	Properties props=new Properties();
	FileReader fs=new FileReader("src/in/skyline/properties/jdbc.properties");
	props.load(fs);
	
	String url=props.getProperty("url");
	String user=props.getProperty("user");
	String pasw=props.getProperty("password");
	
    MysqlConnectionPoolDataSource dataSource=new MysqlConnectionPoolDataSource();
    dataSource.setUrl(url);
    dataSource.setUser(user);
    dataSource.setPassword(pasw);
    
    Connection connection=dataSource.getConnection();
    createDB(connection);
    createTable(connection);
//    System.out.println("Created succesfully");
	return connection; 
	
}
 
private static void createDB(Connection connection) throws IOException, SQLException {
	 
	    Statement statement =connection.createStatement();
	    String query="Create Database if not exists atm";
	    //execute query 
	    statement.executeUpdate(query);

	    //use Atm database
	    query="use Atm";
	    statement.executeUpdate(query);
		  //create table signup and make email as unique and formno as primary key
		  query="create table if not exists signup(formno varchar(20), name varchar(20), father_name varchar(20), dob varchar(30), gender varchar(20),email varchar(30) unique not null, marital_status varchar(20), address varchar(40), city varchar(25), pincode varchar(20), state varchar(25),primary key(formno))";
		  statement.executeUpdate(query);

		  //create table signuptwo and make formmno as foreign key reference signup
		  query="create table if not exists signuptwo(formno varchar(20), religion varchar(20), category varchar(20), income varchar(20), education varchar(20), occupation varchar(20), pan varchar(20)  unique not null, aadhar varchar(20) unique not null, seniorcitizen varchar(20), existingaccount varchar(20), primary key(formno),  foreign key(formno) references signup(formno))";
		  statement.executeUpdate(query);

		  //create table signupthree and make cardnumber as primary key and foreign key as formno 
		  query="create table if not exists signupthree(formno varchar(20) , accountType varchar(40), cardnumber varchar(25), pin varchar(10), facility varchar(100), primary key(cardnumber),foreign key(formno) references signuptwo(formno) )";
		  statement.executeUpdate(query);

		  //create table login and cardnumber as primary key
		  query="create table if not exists login(formno varchar(20), cardnumber varchar(25), pin varchar(10), primary key(cardnumber),foreign key(cardnumber) references signupthree(cardnumber))";
		  statement.executeUpdate(query);

		  //create bank table
		  query="create table if not exists bank(cardnumber varchar(25), date Date, type varchar(20), amount varchar(20),foreign key(cardnumber) references login(cardnumber))";
		  statement.executeUpdate(query);
		    
 
	}

private static void createTable(Connection connection) throws IOException, SQLException {
    Statement statement =connection.createStatement();
    String query="Create Database if not exists atm";
    //execute query 
    statement.executeUpdate(query);

    //use bms database
    query="use Atm";
    statement.executeUpdate(query);
	  //create table signup and make email as unique and formno as primary key
	  query="create table if not exists signup(formno varchar(20), name varchar(20), father_name varchar(20), dob varchar(30), gender varchar(20),email varchar(30) unique not null, marital_status varchar(20), address varchar(40), city varchar(25), pincode varchar(20), state varchar(25),primary key(formno))";
	  statement.executeUpdate(query);

	  //create table signuptwo and make formmno as foreign key reference signup
	  query="create table if not exists signuptwo(formno varchar(20), religion varchar(20), category varchar(20), income varchar(20), education varchar(20), occupation varchar(20), pan varchar(20)  unique not null, aadhar varchar(20) unique not null, seniorcitizen varchar(20), existingaccount varchar(20), primary key(formno),  foreign key(formno) references signup(formno))";
	  statement.executeUpdate(query);

	  //create table signupthree and make cardnumber as primary key and foreign key as formno 
	  query="create table if not exists signupthree(formno varchar(20) , accountType varchar(40), cardnumber varchar(25), pin varchar(10), facility varchar(100), primary key(cardnumber),foreign key(formno) references signuptwo(formno) )";
	  statement.executeUpdate(query);

	  //create table login and cardnumber as primary key
	  query="create table if not exists login(formno varchar(20), cardnumber varchar(25), pin varchar(10), primary key(cardnumber),foreign key(cardnumber) references signupthree(cardnumber))";
	  statement.executeUpdate(query);

	  //create bank table
	  query="create table if not exists bank(cardnumber varchar(25), date Date, type varchar(20), amount varchar(20),foreign key(cardnumber) references login(cardnumber))";
	  statement.executeUpdate(query);
	    
	  System.out.println("Connection database and table created succesfully ");
}

public static void closeConnection(ResultSet rs, Statement stmt, Connection connection) throws SQLException {
	if(rs!=null) {
		rs.close();
	}
	if(stmt!=null) {
		stmt.close();
	}
	if(connection!=null) {
		connection.close();
	}
}

 
}



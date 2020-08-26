package pers.demo.information;
import java.sql.*;

public class user {
	public String username;
	public String password;

	protected String tableName = "userinformation";
	protected DatabaseMetaData metaData;
	protected Connection connect = null;
	
	public user() {
		
	}
	
	public user(String username, String password) {
		this.username = username;
		this.password = password;
		try {
			Class.forName("org.postgresql.Driver");
		    connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/User_Information","postgres", "123456");
		} catch (Exception error) {
			error.printStackTrace();
		    System.err.println(error.getClass().getName()+": "+error.getMessage());
		    System.exit(0);
		}
	    System.out.println("Opened database successfully");
	    boolean isTableExist = isTableExistence();
	    if (isTableExist) {
	    	System.out.println("table has been existed");
	    }else {
	    	System.out.println("table is not exist");
	    	createTable();
	    }
	    
	}

	protected boolean isTableExistence() {
		boolean flag = false;
		ResultSet result;
		try{
			metaData = connect.getMetaData();
			String type [] = {"TABLE"};
			result = metaData.getTables(null, null, tableName, type);
			flag = result.next();
			System.out.println("isTableExist: "+ flag);
		}catch(Exception error){
			error.printStackTrace();
			System.err.println(error.getClass().getName()+": "+error.getMessage());
		}
		return flag;
	}
	
	protected void createTable() {
		Statement statement = null;
        String sql = "CREATE TABLE USERINFORMATION(" +
                " ID SERIAL PRIMARY KEY  NOT NULL," +
                " USERNAME       TEXT    NOT NULL, " +
                " PASSWORD       TEXT    NOT NULL)";
        try {
        	statement = connect.createStatement();
			statement.executeUpdate(sql);
	        statement.close();
	        System.out.println("table is created");
		} catch (SQLException error) {
			// TODO Auto-generated catch block
			error.printStackTrace();
			System.err.println(error.getClass().getName()+": "+error.getMessage());
		}
	}
	
	public void insertDatas(String username, String password) {
		PreparedStatement statement = null;
    	try {
			connect.setAutoCommit(false);
			String sql = "INSERT INTO USERINFORMATION (USERNAME,PASSWORD) "
					+ "VALUES (?, ?);";
			System.out.println(sql);
			statement = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.executeUpdate();
			statement.close();
			connect.commit();
			System.out.println("insent completed!");
		} catch (SQLException error) {
			// TODO Auto-generated catch block
			error.printStackTrace();
			System.err.println(error.getClass().getName()+": "+error.getMessage());
		}
	}
	
	public void deleteDatas() {
		
	}
	
	public boolean selectDatas(String username) {
		boolean flag = false;
		Statement statement = null;
		ResultSet result;
		try {
			setUsername(username);
			System.out.println("username : " + this.username);
			statement = connect.createStatement();
			result = statement.executeQuery("select * from userinformation");
			while(result.next()) {
				String name = result.getString("username");
				System.out.println("name : " + name);
				if (equals(name)) {			
					flag = true;
					break;
				}
			}
		} catch (SQLException error) {
			// TODO Auto-generated catch block
			error.printStackTrace();
			System.err.println(error.getClass().getName()+": "+error.getMessage());
		}
		System.out.println("flag : " + flag);
		return flag;
	}
	
	public boolean selectDatas(String username, String password) {
		boolean flag = false;
		Statement statement = null;
		ResultSet result;
		try {
			setUsername(username);
			setPassword(password);
			System.out.println("username : " + this.username);
			statement = connect.createStatement();
			result = statement.executeQuery("select * from userinformation");
			while(result.next()) {
				String name = result.getString("username");
				String passwd = result.getString("password");
				System.out.println("name : " + name);
				System.out.println("passwd : " + passwd);
				if (equals(name, passwd)) {			
					flag = true;
					break;
				}
			}
		} catch (SQLException error) {
			// TODO Auto-generated catch block
			error.printStackTrace();
			System.err.println(error.getClass().getName()+": "+error.getMessage());
		}
		System.out.println("flag : " + flag);
		return flag;
	}	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean equals(String username) {
		if (username == null) {
			return false;			
		}
		if (username.equals(getUsername())) {
			return true;
		}
		return false;
	}
	
	public boolean equals(String username, String password) {
		if (username == null || password == null) {
			return false;			
		}
		if (username.equals(getUsername()) && password.equals(getPassword())) {
			return true;
		}
		return false;
	}

	public void disconnect() throws SQLException {
		System.out.println("postgresql is disconnected");
		connect.close();
	}
	
}

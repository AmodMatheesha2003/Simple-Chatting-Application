package chatme;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Model {
	private static Connection connection;
	private static ResultSet resultSet;
	private static ResultSet chatresultSet;
	private static ResultSet checkemail;
	private static ResultSet chatresultSet2;
	private static ResultSet addfriendresultSet;
	private static ResultSet requestresultSet;
	private static ResultSet findnameresultSet;
	private static ResultSet selectreciverresultSet;
	private static ResultSet setuserresultSet;
	private static int rowsAffected;

	private static String url="jdbc:mysql://localhost:3306/chatme";
	private static String username="root";
	private static String password="";
	
	static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed database connection.");
        }
    }
	
	public static boolean isInternetAvailable() {
        try {
            InetAddress.getByName("www.google.com");
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }
		
	
	public static ResultSet Logindata(String mobile,String password2) {
		 
	     String selectQuery = "SELECT * FROM user_detail WHERE mobile = ? and password = ?";
		 PreparedStatement selectStatement;
		try {
			selectStatement = connection.prepareStatement(selectQuery);
			 selectStatement.setString(1,mobile);
			 selectStatement.setString(2,password2);
			 resultSet = selectStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
	public static void senddata(String sender,String Receiver,String message ) {
		try {
		String insertquery = "insert into massagetabel(sname,rname,massage) values (?,?,?)";
        PreparedStatement insertstatement = connection.prepareStatement(insertquery);
        insertstatement.setString(1, sender);
        insertstatement.setString(2, Receiver);
        insertstatement.setString(3, message);
        insertstatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet showsenddata(String Receiver,String sender) {
		try {
			String selectquery = "SELECT massage,sname FROM massagetabel where rname= ? and sname=? or rname= ? and sname=?";
	        PreparedStatement selectstatement = connection.prepareStatement(selectquery);
	        selectstatement.setString(1, Receiver);
	        selectstatement.setString(2, sender);
	        selectstatement.setString(4, Receiver);
	        selectstatement.setString(3, sender);
	        chatresultSet = selectstatement.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
		return chatresultSet;
	}
	
	public static void insertuserdetail(String name, String passworduser, String emailu, String mobileu, byte[] imageBytes) {
	    try {
	        String insertQuery = "INSERT INTO user_detail (name, password, email, mobile, image) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
	        insertStatement.setString(1, name);
	        insertStatement.setString(2, passworduser);
	        insertStatement.setString(3, emailu);
	        insertStatement.setString(4, mobileu);
	        insertStatement.setBytes(5, imageBytes);	        
	        insertStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void insertuserdetail(String name, String passworduser, String emailu, String mobileu) {
	    try {
	        String insertQuery = "INSERT INTO user_detail (name, password, email, mobile ,status) VALUES (?, ?, ?, ?,?)";
	        PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
	        insertStatement.setString(1, name);
	        insertStatement.setString(2, passworduser);
	        insertStatement.setString(3, emailu);
	        insertStatement.setString(4, mobileu);	
	        insertStatement.setString(5, "offline");	
	        insertStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public static ResultSet checkemail(String phone,String temail) {
		try {
			String selectQuery = "SELECT * FROM user_detail WHERE mobile = ? and email = ?";
			 PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
			 selectStatement.setString(1,phone);
			 selectStatement.setString(2,temail);
			 checkemail = selectStatement.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
		return checkemail;
	}
	
	public static int forgetupdateaccount(String newPassword,String phone,String temail) {
		try {
			String updateQuery = "UPDATE user_detail SET password = ? WHERE mobile = ? AND email = ?";
	        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
	        updateStatement.setString(1, newPassword);
	        updateStatement.setString(2, phone);
	        updateStatement.setString(3, temail);
	        rowsAffected = updateStatement.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
		return rowsAffected;
	}
	
	public static ResultSet chatdata(String name22) {
		try {
			String selectQuery = "SELECT * FROM user_freinds WHERE (user = ? OR freind = ?) AND status = 'approve'";
	        PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, name22);
            selectStatement.setString(2, name22);
            chatresultSet2 = selectStatement.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return chatresultSet2;
	}
	
	public static ResultSet userprofiledata(String user, String friend) {
	    chatresultSet2 = null;
	    try {
	        String selectQuery = "SELECT * FROM user_freinds WHERE (user = ? AND freind = ?) OR (freind = ? AND user = ?)";
	        PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
	        selectStatement.setString(1, user);
	        selectStatement.setString(2, friend);
	        selectStatement.setString(3, user);
	        selectStatement.setString(4, friend);
	        chatresultSet2 = selectStatement.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return chatresultSet2;
	}
	
	public static ResultSet addfrienddata(String name2) {
		try {
			String selectQuery = "SELECT name FROM user_detail WHERE name != ? AND name NOT IN (SELECT user FROM user_freinds WHERE freind = ? UNION SELECT freind FROM user_freinds WHERE user = ?)";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, name2);
            selectStatement.setString(2, name2);
            selectStatement.setString(3, name2);
            addfriendresultSet = selectStatement.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return addfriendresultSet;
	}
	
	public static ResultSet requestdata(String name2) {
		try {
			String selectQuery = "SELECT user FROM user_freinds WHERE freind = ? AND status = 'to approve'";
	        PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, name2);
            requestresultSet = selectStatement.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return requestresultSet;
	}
	
	public static void approvefreinddata(String name2,String buttonText1) {
		try {
			String insertQuery = "UPDATE user_freinds SET status = 'approve' WHERE user = ? AND freind = ?";	               
			PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
	        insertStatement.setString(2, name2);
	        insertStatement.setString(1, buttonText1);
	        insertStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void diclinefreinddata(String name2,String buttonText1) {
		try {
			String insertQuery = "UPDATE user_freinds SET status = 'decline' WHERE user = ? AND freind = ?";	              
			PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
	        insertStatement.setString(2, name2);
	        insertStatement.setString(1, buttonText1);
	        insertStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet findnamedata(String mobile) {
		try {
			String selectQuery = "SELECT name FROM user_detail WHERE mobile = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, mobile);
            findnameresultSet = selectStatement.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return findnameresultSet;
	}
	
	public static ResultSet selectreciver(String mobile) {
		try {
			String selectQuery1 = "SELECT name FROM user_detail WHERE mobile = ?";
	        PreparedStatement selectStatement1 = connection.prepareStatement(selectQuery1);
	        selectStatement1.setString(1,mobile);
	        selectreciverresultSet = selectStatement1.executeQuery();
	        
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return selectreciverresultSet;
	}
	
	public static void toapprovedata(String name2,String buttonText) {
		try {
	    	String insertQuery = "INSERT INTO user_freinds (user,freind,status) VALUES (?,?,'to approve')";	              
			PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
	        insertStatement.setString(2, name2);
	        insertStatement.setString(1, buttonText);
	        insertStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public static ResultSet findimage(String Receiver) {
		try {
			String selectQuery1 = "SELECT * FROM user_detail WHERE name = ?";
	        PreparedStatement selectStatement1 = connection.prepareStatement(selectQuery1);
	        selectStatement1.setString(1,Receiver);
	        selectreciverresultSet = selectStatement1.executeQuery();
	        
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return selectreciverresultSet;
	}
	
	public static boolean deletefrofiledata(String mobile) {
	    boolean success = false;
	    try {
	        String deleteQuery = "DELETE FROM user_detail WHERE mobile = ?";
	        PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
	        deleteStatement.setString(1, mobile);
	        int rowsAffected = deleteStatement.executeUpdate();
	        if (rowsAffected > 0) {
	            success = true; 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return success;
	}
	
	public static void removefreind(int id) {
	    try {
	        String deleteQuery = "DELETE FROM user_freinds WHERE id = ?";
	        PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
	        deleteStatement.setInt(1, id);
	        deleteStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void updateprofile(String password1,String name3,String mobile ) {
		try {
			String updateQuery = "UPDATE user_detail SET password = ?, name = ? WHERE mobile = ?";
	        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
	        updateStatement.setString(1, password1);
	        updateStatement.setString(2, name3);
	        updateStatement.setString(3, mobile);
	        updateStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateprofile(String password1,String name3,String mobile,byte[] imageBytes2) {
		try {
			String updateQuery = "UPDATE user_detail SET password = ?, name = ?, image = ? WHERE mobile = ?";
	        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
	        updateStatement.setString(1, password1);
	        updateStatement.setString(2, name3);
	        updateStatement.setString(4, mobile);
	        updateStatement.setBytes(3, imageBytes2);
	        updateStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ResultSet setuserdata(String mobile) {
		try {
			String selectQuery = "SELECT * FROM user_detail WHERE  mobile = ?";
			 PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
			 selectStatement.setString(1,mobile);
			 setuserresultSet = selectStatement.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return setuserresultSet;
	}
	
	public static int countUser() {
	    int count = 0;
	    try {
	    	String selectQuery = "SELECT COUNT(*) FROM user_detail WHERE mobile != 'admin'";
	        PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
	        ResultSet resultSet = selectStatement.executeQuery();
	        if (resultSet.next()) {
	            count = resultSet.getInt(1); 
	        }
	        resultSet.close(); 
	        selectStatement.close(); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return count;
	}
	
	public static int countonline() {
	    int onlinecount = 0;
	    try {
	        String selectQuery = "SELECT COUNT(*) FROM user_detail where status = 'online'";
	        PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
	        ResultSet resultSet = selectStatement.executeQuery();
	        if (resultSet.next()) {
	        	onlinecount = resultSet.getInt(1); 
	        }
	        resultSet.close(); 
	        selectStatement.close(); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return onlinecount;
	}
	
	public static void setonlineoffline(String status,String mobile) {
		try {
			String updateQuery = "UPDATE user_detail SET status = ? WHERE mobile = ?";
	        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
	        updateStatement.setString(1, status);
	        updateStatement.setString(2, mobile);
	        updateStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static ResultSet getDataFromDatabaseadmin() {
		try {
			String selectQuery = "SELECT * FROM user_detail where mobile != 'admin'";
			 PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
			 setuserresultSet = selectStatement.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return setuserresultSet;
	}
	
	public static ResultSet searchadmin(String mobile) {
		try {
			String selectQuery = "SELECT * FROM user_detail where mobile != 'admin' and mobile = ?";
			 PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
			 selectStatement.setString(1, mobile);
			 setuserresultSet = selectStatement.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return setuserresultSet;
	}
}


	

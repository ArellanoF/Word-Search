package com.sopa.DAO.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sopa.DAO.DAOException;
import com.sopa.DAO.UserDAO;
import com.sopa.models.User;

public class SQLUserDAO implements UserDAO{
	
	final String INSERT= "INSERT INTO users(idUsername, username) VALUES (?, ?)";
	final String UPDATE= "UPDATE users SET idUsername = ?, username = ? WHERE idUsername = ?";
	final String DELETE= "DELETE FROM users WHERE idUsername = ?";
	final String DELETEALL= "DELETE FROM users";
	final String GETALL = "SELECT * FROM users";
	final String GETONE = "SELECT * FROM users WHERE idUsername = ?";
	
private Connection conn;
	
	public SQLUserDAO(Connection conn) {
		this.conn = conn;
	}

	private User convert(ResultSet rs) throws SQLException{
		int idUsername = rs.getInt("idUsername");
		String username = rs.getString("username");
		User user1 = new User(idUsername, username);
		user1.setIdUsername(rs.getInt("idUsername"));
		return user1;
	}
	
	
	public User get(int id) throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		User user = null;
		try {
			stat = conn.prepareStatement(GETONE);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			if(rs.next()) {
				user = convert(rs);
			}else {
				throw new DAOException("No se ha encontrado esa palabra");
			}
		}catch(SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException ex) {
					new DAOException("Error en SQL", ex);
				}
			}
			if(stat != null) {
				try{
					stat.close();
				}catch(SQLException ex) {
					new DAOException("Error en SQL",ex);
				}
			}
		}
		return user;
	}

	public List<User> getAll() throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<>();
		try {
			stat = conn.prepareStatement(GETALL);
			rs = stat.executeQuery();
			while(rs.next()) {
				users.add(convert(rs));
			}
		}catch(SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException ex) {
					new DAOException("Error en SQL", ex);
				}
			}
			if(stat != null) {
				try{
					stat.close();
				}catch(SQLException ex) {
					new DAOException("Error en SQL",ex);
				}
			}
		}
		return users;
	}

	public void save(User t) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(INSERT);
			stat.setInt(1, t.getIdUsername());
			stat.setString(2, t.getUsername());
			if(stat.executeUpdate() == 0) {
				throw new DAOException("Posible error en metodo Update!");
			};
		}catch(SQLException ex){
			throw new DAOException("Error en SQL", ex);
		}finally {
			if( stat != null) {
				try {
					stat.close();
				}catch(SQLException ex) {
					throw new DAOException("Error en SQL", ex);
				}
			}
		}
		
	}

	public void update(User t) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(UPDATE);
			stat.setInt(1, t.getIdUsername());
			stat.setString(2, t.getUsername());
			if(stat.executeUpdate() == 0) {
				throw new DAOException("Posible error en metodo Update!");
			};
		}catch(SQLException ex){
			throw new DAOException("Error en SQL", ex);
		}finally {
			if( stat != null) {
				try {
					stat.close();
				}catch(SQLException ex) {
					throw new DAOException("Error en SQL", ex);
				}
			}
		}
	}

	public void delete(User t) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(DELETE);
			if(stat.executeUpdate() == 0) {
				throw new DAOException("Posible error en metodo Delete!");
			};
		}catch(SQLException ex) {
			throw new DAOException("Error en SQL", ex);
		}finally {
			if( stat != null) {
				try {
					stat.close();
				}catch(SQLException ex) {
					throw new DAOException("Error en SQL", ex);
				}
			}
		}
		
	}

}

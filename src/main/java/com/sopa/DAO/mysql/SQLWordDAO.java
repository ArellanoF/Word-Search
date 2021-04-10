package com.sopa.DAO.mysql;

import java.util.ArrayList;
import java.util.List;

import com.sopa.DAO.DAOException;
import com.sopa.DAO.WordDAO;
import com.sopa.models.Word;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLWordDAO implements WordDAO {

	final String INSERT= "INSERT INTO word(word) VALUES (?)";
	final String UPDATE= "UPDATE word SET word = ? WHERE idWord = ?";
	final String DELETE= "DELETE FROM word WHERE idWord = ?";
	final String DELETEALL= "DELETE FROM word";
	final String GETALL = "SELECT * FROM word";
	final String GETONE = "SELECT * FROM word WHERE idWord = ?";
	
	private Connection conn;
	
	public SQLWordDAO(Connection conn) {
		this.conn = conn;
	}
	
	private Word convert(ResultSet rs) throws SQLException{
		String word = rs.getString("word");
		Word word1 = new Word(word);
		return word1;
	}
	
	public Word get(int id) throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		Word word = null;
		try {
			stat = conn.prepareStatement(GETONE);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			if(rs.next()) {
				word = convert(rs);
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
		return word;
	}

	public List<Word> getAll() throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<Word> words = new ArrayList<>();
		try {
			stat = conn.prepareStatement(GETALL);
			rs = stat.executeQuery();
			while(rs.next()) {
				words.add(convert(rs));
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
		return words;
	}

	public void save(Word t) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(INSERT);
			stat.setString(1, t.getWord());
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

	public void update(Word t) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(UPDATE);
			stat.setString(1, t.getWord());
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

	public void delete(Word t) throws DAOException {
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

	public void deleteAll() throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(DELETEALL);
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

	

	@Override
	public Word getLast() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}

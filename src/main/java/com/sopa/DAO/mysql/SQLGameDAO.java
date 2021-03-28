package com.sopa.DAO.mysql;

import java.util.ArrayList;
import java.util.List;

import com.sopa.DAO.DAOException;
import com.sopa.DAO.GameDAO;
import com.sopa.models.Game;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLGameDAO  implements GameDAO{
	
	final String INSERT= "INSERT INTO game(idGame, date, score, duration, username) VALUES (?, ?, ?, ?, ?)";
	final String UPDATE= "UPDATE word SET idGame = ?, date = ?, score = ?, duration = ?, username = ?,  WHERE idWord = ?";
	final String DELETE= "DELETE FROM game WHERE idGame = ?";
	final String GETALL = "SELECT * FROM game";
	final String GETONE = "SELECT * FROM game WHERE idGame = ?";
	
	private Connection conn;
	
	public SQLGameDAO(Connection conn) {
		this.conn = conn;
	}
	private Game convert(ResultSet rs) throws SQLException{
		int idGame = rs.getInt("idGame");
		Date date = rs.getDate("date");
		int duration = rs.getInt("duration");
		int score = rs.getInt("score");
		String username = rs.getString("username");
	
		Game game1 = new Game(idGame, date, duration, score, username);
		game1.setIdGame(rs.getInt("idGame"));
		return game1;
		}

	@Override
	public Game get(int id) throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		Game game = null;
		try {
			stat = conn.prepareStatement(GETONE);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			if(rs.next()) {
				game = convert(rs);
			} else {
				throw new DAOException("No se ha encontrado el Game");
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
		return game;
	}

	@Override
	public List<Game> getAll() throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<Game> games = new ArrayList<>();
		try {
			stat = conn.prepareStatement(GETALL);
			rs = stat.executeQuery();
			while(rs.next()) {
				games.add(convert(rs));
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
		return games;
	}

	@Override
	public void save(Game t) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(INSERT);
			stat.setInt(1, t.getIdGame());
			stat.setDate(2, new Date (t.getDate().getTime()));
			stat.setInt(3, t.getScore());
			stat.setInt(4, t.getDuration());
			stat.setString(5, t.getUsername());
			
			if(stat.executeUpdate() == 0) {
				throw new DAOException("Posible error en metodo Insert!");
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
	
	@Override
	public void update(Game t) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(UPDATE);
			stat.setInt(1, t.getIdGame());
			stat.setDate(2, new Date (t.getDate().getTime()));
			stat.setInt(3, t.getScore());
			stat.setString(4, t.getUsername());
			stat.setInt(5, t.getDuration());
			
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

	@Override
	public void delete(Game t) throws DAOException {
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

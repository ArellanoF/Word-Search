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
import java.sql.Statement;
import java.time.LocalDate;

import connection.connectionSQL;

public class SQLGameDAO  implements GameDAO{
	
	final String INSERT= "INSERT INTO game(idGame, date, score, users, duration) VALUES (?, ?, ?, ?, ?,)";
	final String UPDATE= "UPDATE word SET idGame = ?, date = ?, score = ?, users = ?, duration = ? WHERE idWord = ?";
	final String DELETE= "DELETE FROM game WHERE idGame = ?";
	final String GETALL = "SELECT * FROM game";
	final String GETONE = "SELECT * FROM game WHERE idGame = ?";
	
	private Connection conn;
	
	public SQLGameDAO(Connection conn) {
		this.conn = conn;
	}
	private Game convert(ResultSet rs) throws SQLException{
		int idGame = rs.getInt("idGame");
		LocalDate date = rs.getDate("date").toLocalDate();
		int score = rs.getInt("score");
		String username = rs.getString("username");
		int duration = rs.getInt("duration");
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Game t) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Game t) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Game t) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}

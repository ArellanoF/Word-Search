package com.sopa.DAO.mysql;

import java.util.ArrayList;
import java.util.List;

import com.sopa.DAO.DAOException;
import com.sopa.DAO.GameDAO;
import com.sopa.models.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLGameDAO  implements GameDAO{
	
	final String INSERT= "INSERT INTO game(gameDate, duration, score, username) VALUES (?, ?, ?, ?)";
	final String UPDATE= "UPDATE game SET gameDate = ?, score = ?, duration = ?, username = ?,  WHERE idGame = ?";
	final String DELETE= "DELETE FROM game WHERE idGame = ?";
	final String GETALL = "SELECT * FROM game ORDER BY score DESC, duration ASC LIMIT 10";
	final String GETONE = "SELECT * FROM game WHERE idGame = ?";
	
	
	private Connection conn;
	
	public SQLGameDAO(Connection conn) {
		this.conn = conn;
	}
	private Game convert(ResultSet rs) throws SQLException{
		String date = rs.getString("gameDate");
		int duration = rs.getInt("duration");
		int score = rs.getInt("score");
		String username = rs.getString("username");
		Game game1 = new Game(date, duration, score, username);
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

	public void save(Game t) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(INSERT);
			stat.setString(1, t.getGameDate());
			stat.setInt(2, t.getDuration());
			stat.setInt(3, t.getScore());
			stat.setString(4, t.getUsername());
			
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
			stat.setString(1, t.getGameDate());
			stat.setInt(2, t.getScore());
			stat.setString(3, t.getUsername());
			stat.setInt(4, t.getDuration());
			
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
	
	@Override
	public Game getLast() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() throws DAOException {
		// TODO Auto-generated method stub
		
	}

}

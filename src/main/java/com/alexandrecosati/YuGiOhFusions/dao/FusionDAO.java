package com.alexandrecosati.YuGiOhFusions.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alexandrecosati.YuGiOhFusions.db.MySQLConnection;
import com.alexandrecosati.YuGiOhFusions.entities.Fusion;

public class FusionDAO {
	
	CardDAO cardDAO = new CardDAO();
	
	public static final String GET_ONE = "SELECT monster, material_1, material_2 "
			+ "FROM fusions WHERE material_1 = ? AND material_2 = ? ";
	
	public static final String GET_ALL_BY_CARD = "SELECT monster, material_1, material_2 "
			+ "FROM fusions WHERE material_1 = ? "
			+ "UNION ALL "
			+ "SELECT monster, material_2, material_1 "
			+ "FROM fusions WHERE material_2 = ? ";
	
	public Integer findByIds(int id1, int id2) {
		Connection connection = null;	
		try {
            connection = MySQLConnection.getConnectionToDatabase();
            PreparedStatement statement = connection.prepareStatement(GET_ONE);
            statement.setInt(1, id1);
            statement.setInt(2, id2);            
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                return resultSet.getInt("monster");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}
	
	public List<Fusion> findFusions(Integer cardId, List<Integer> hand) {
		List<Fusion> fusions = new ArrayList<>();
		if (cardId == null || hand.size() <= 0) return fusions;
		
		Connection connection = null;	
		for (Integer secondCardId : hand) {
			//Removes Card from hand and tries fusion
			List<Integer> newHand = new ArrayList<>(hand);
			newHand.remove(secondCardId);
			
			// attempts fusion
			try {
				connection = MySQLConnection.getConnectionToDatabase();
	            PreparedStatement statement = connection.prepareStatement(GET_ONE);
	            statement.setInt(1, cardId);
	            statement.setInt(2, secondCardId);
	            ResultSet resultSet = statement.executeQuery();
	            
	            if (resultSet.next()) { // fusion success
	            	Integer newMonster = resultSet.getInt("monster");
	            	//Continues trying to fuse with other cards from hand
	            	fusions.add(new Fusion(cardDAO.findById(cardId), cardDAO.findById(secondCardId), cardDAO.findById(newMonster), findFusions(newMonster, newHand)));
	            }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return fusions;
		
	}	 
	
	public List<Fusion> findCardFusions(Integer cardId) {
		List<Fusion> fusions = new ArrayList<>();
		if (cardId == null) return fusions;
		
		Connection connection = null;	
		try {
			connection = MySQLConnection.getConnectionToDatabase();
            PreparedStatement statement = connection.prepareStatement(GET_ALL_BY_CARD);
            statement.setInt(1, cardId);
            statement.setInt(2, cardId);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) { // fusion success
            	Fusion current = new Fusion();
            	current.setFirstCard(cardDAO.findById(resultSet.getInt("material_1")));
            	current.setSecondCard(cardDAO.findById(resultSet.getInt("material_2")));
            	current.setMonster(cardDAO.findById(resultSet.getInt("monster")));
            	fusions.add(current);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fusions;
	}

}

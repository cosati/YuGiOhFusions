package com.alexandrecosati.YuGiOhFusions.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alexandrecosati.YuGiOhFusions.db.MySQLConnection;
import com.alexandrecosati.YuGiOhFusions.entities.Card;

public class CardDAO {

    private static final String GET_ONE = "SELECT id, name, card_type, monster_type, card_level, atk, def, cost " +
            "FROM cards WHERE id = ?";
    private static final String GET_BY_NAME = "SELECT id, name, card_type, monster_type, card_level, atk, def, cost " +
            "FROM cards WHERE LOWER(name) LIKE ? ORDER BY id";
    private static final String GET_ALL = "SELECT id, name, card_type, monster_type, card_level, atk, def, cost " +
            "FROM cards ORDER BY id";

    public Card findById(int id) {
        Connection connection = null;
        try {
            connection = MySQLConnection.getConnectionToDatabase();
            PreparedStatement statement = connection.prepareStatement(GET_ONE);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                return new Card(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("card_type"),
                        resultSet.getInt("monster_type"),
                        resultSet.getInt("card_level"),
                        resultSet.getInt("atk"),
                        resultSet.getInt("def"),
                        resultSet.getInt("cost"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Card> findCardsByname(String name) {
        Connection connection = null;
        List<Card> result = new ArrayList<>();
        try {
            connection = MySQLConnection.getConnectionToDatabase();
            PreparedStatement statement = connection.prepareStatement(GET_BY_NAME);
            statement.setString(1, "%" +  name.toLowerCase() + "%");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                result.add(new Card(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("card_type"),
                        resultSet.getInt("monster_type"),
                        resultSet.getInt("card_level"),
                        resultSet.getInt("atk"),
                        resultSet.getInt("def"),
                        resultSet.getInt("cost")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Card> findAllCards() {
        Connection connection = null;
        List<Card> result = new ArrayList<>();
        try {
            connection = MySQLConnection.getConnectionToDatabase();
            PreparedStatement statement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                result.add(new Card(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("card_type"),
                        resultSet.getInt("monster_type"),
                        resultSet.getInt("card_level"),
                        resultSet.getInt("atk"),
                        resultSet.getInt("def"),
                        resultSet.getInt("cost")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}

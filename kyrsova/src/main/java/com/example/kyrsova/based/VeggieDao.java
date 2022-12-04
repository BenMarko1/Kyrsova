package com.example.kyrsova.based;

import com.example.kyrsova.Vegetable.Vegetable;

import javax.xml.namespace.QName;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeggieDao implements Dao<Vegetable> {
    private static final String GET_ALL_VEGETABLE = "select * from vegetable";
    private static final String GET_VEGGIE = "select * from vegetable where id = ?";

    @Override
    public Optional<Vegetable> getById(int id) {
        Vegetable vegetable = null;
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_VEGGIE);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                vegetable = new Vegetable(rs.getString("name"),
                        rs.getDouble("proteins"),
                        rs.getDouble("carbohydrates"),
                        rs.getDouble("fats"),
                        rs.getDouble("calory"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Optional<Vegetable> vegetable1 = Optional.ofNullable(vegetable);
        return vegetable1;
    }

    @Override
    public List<Vegetable> getAll() {
        List<Vegetable> list = new ArrayList<>();
        try {
            Connection connection = DatabaseManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_VEGETABLE);
            if(rs.next()){
                list.add( new Vegetable(rs.getString("name"),
                        rs.getDouble("proteins"),
                        rs.getDouble("carbohydrates"),
                        rs.getDouble("fats"),
                        rs.getDouble("calory")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean save(Vegetable vegetable) {
        return false;
    }

    @Override
    public boolean update(Vegetable vegetable) {
        return false;
    }

    @Override
    public boolean delete(long name) {
        return false;
    }
}

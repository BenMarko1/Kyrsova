package com.example.kyrsova.based;

import com.example.kyrsova.Salad.BasicSalad;
import com.example.kyrsova.Vegetable.Vegetable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SaladDao implements Dao{
    private static final String GET_SALADS = "select * from basic_salads where id = ?";
    private static final String GET_ALL_BASIC_SALAD = "select * from basic_salads";
    private static final String GET_VEGETABLE = "select vegetable_id from vegetable_salad where basic_salad_id  = ?";


    @Override
    public Optional getById(int id) {
        BasicSalad salad = null;
        List<Integer> list = getVegetable(id);
        List<Vegetable> vegetableList = getVegetables(list);
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_SALADS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                salad = new BasicSalad(vegetableList,
                        rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Optional<BasicSalad> salad1 = Optional.ofNullable(salad);
        return salad1;
    }

    private List<Vegetable> getVegetables(List<Integer> list) {
        List<Vegetable> vegetableList = new ArrayList<>();
        VeggieDao veggieDao = new VeggieDao();
        for (Integer i: list){
            vegetableList.add(veggieDao.getById(i).get());
        }
        return vegetableList;
    }

    @Override
    public List<BasicSalad> getAll() {
        List<BasicSalad> list = new ArrayList<>();
        List<Integer> listInt;

        try {
            Connection connection = DatabaseManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_BASIC_SALAD);
            while (rs.next()){
                int id = rs.getInt("id");
                listInt = getVegetable(id);
                List<Vegetable> vegetables = getVegetables(listInt);
                list.add( new BasicSalad(vegetables,
                        rs.getString("name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean save(Object o) {
        return false;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }


    public List<Integer> getVegetable(int saladId){
        List<Integer> list = new ArrayList<>();
        try {
            Connection connection = DatabaseManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_VEGETABLE);
            ps.setInt(1, saladId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


}

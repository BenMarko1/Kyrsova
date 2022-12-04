package com.example.kyrsova.based;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    /**
     * getting an object by id from the database
     * @param id object's id
     * @return an empty optional, if nothing is found.
     * If something is found - an object of the class that is implemented by the DAO
     */
    Optional<T> getById(int id);

    /**
     * getting all objects from the class that is implemented by the DAO
     * @return list of this objects
     */
    List<T> getAll();
    /**
     * Saving object's information in database
     * @param t the class that is implemented by the DAO
     * @return boolean
     */
    boolean save(T t);
    /**
     * Updating object's information in database
     * @param t the class that is implemented by the DAO
     * @return boolean
     */
    boolean update(T t);
    /**
     * Deleting object from database
     * @param id object's id
     * @return boolean
     */
    boolean delete(long id);
}

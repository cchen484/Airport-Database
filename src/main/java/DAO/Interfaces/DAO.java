package DAO.Interfaces;

import java.util.List;
import java.util.Optional;

/**
 * INTERFACE NAME: DAO
 * BEHAVIOR: Outline methods for database access object
 *
 * @param <T>
 */
public interface DAO<T> {
    T get(int id);
    List<T> getAll();
    void insert(T t);
    void update(T t);
    void delete(int id);

}

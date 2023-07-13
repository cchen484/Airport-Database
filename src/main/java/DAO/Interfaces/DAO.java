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
    T get(long id);
    List<T> getAll();
    void insert();
    void update(T t);
    void delete(T t);

}

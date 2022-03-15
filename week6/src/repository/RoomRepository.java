package repository;

import entity.Room;

import java.util.Set;

/**
 * Репозиторий комнат.
 */
public interface RoomRepository {
    Room save(Room room);
    void delete(Room room);
    Room getBy(String id);
    Set<Room> getAll();
}

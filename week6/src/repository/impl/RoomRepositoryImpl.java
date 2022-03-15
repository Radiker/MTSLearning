package repository.impl;

import entity.Room;
import repository.RoomRepository;

import java.util.HashSet;
import java.util.Set;

public class RoomRepositoryImpl implements RoomRepository {
    private static final Set<Room> rooms = new HashSet<>();

    // реализовать конструктор
    public RoomRepositoryImpl() {

    }

    @Override
    public Room save(Room room) {
        // этот метод создает новую комнату (добавляет в поле rooms), если такого id нет и
        // обновляет, если комната с таким идентификатором существует
        if(getBy(room.getId()) == null)
            rooms.add(room);
        for (Room r: rooms) {
            if(r.getId().equals(room.getId())){
                r.setRoomNumber(room.getRoomNumber());
                r.setFloor(room.getFloor());
                r.setType(room.getType());
                r.setDescription(room.getDescription());
                r.setPrice(room.getPrice());
                r.setBookings(room.getBookings());
            }
        }
        return room;
    }

    @Override
    public void delete(Room room) {
        // удаляет комнату из поля rooms, если такой комнаты нет -- ничего не происходит
        if(getBy(room.getId()) != null)
            rooms.remove(room);
    }

    @Override
    public Room getBy(String id) {
        // возвращает комнату по идентификатору, если такой комнаты нет -- вернуть null
        for (Room room: rooms) {
            if(room.getId().equals(id))
                return room;
        }
        return null;
    }

    @Override
    public Set<Room> getAll() {
        return rooms;
    }
}

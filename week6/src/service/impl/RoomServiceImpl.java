package service.impl;

import entity.*;
import repository.RoomRepository;
import repository.impl.RoomRepositoryImpl;
import service.*;
import service.exceptions.*;

import java.util.*;

public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    // реализовать конструктор
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoomServiceImpl() {
        this.roomRepository = new RoomRepositoryImpl();
    }

    @Override
    public Room getBy(String id) throws RoomNotFoundException {
        // нужно с помощью roomRepository вернуть комнату по идентификатору, в случае
        // если комната не найдена -- выбросить RoomNotFoundException
        Room room = roomRepository.getBy(id);
        if(room == null)
            throw new RoomNotFoundException();
        return room;
    }

    @Override
    public Room createRoom(Room room) throws RequiredFieldMissedException {
        // здесь нужно с помощью roomRepository создать комнату и присвоить ей идентификатор
        // с помощью UUID.randomUUID().toString()
        // а также перед этим проверить, что заполнены поля roomNumber, floor, type, price --
        // иначе выкинуть исключение RequiredFieldMissedException
        // поле bookings не заполнять
        if(room.getRoomNumber() == null || room.getFloor() == null ||
                room.getType() == null || room.getPrice() == null)
            throw new RequiredFieldMissedException();
        room.setId(UUID.randomUUID().toString());
        this.roomRepository.save(room);
        return room;
    }

    @Override
    public Room updateRoom(String id, Room room) {
        // здесь нужно проверить, что комната с таким id существует
        // обновить данные комнаты с помощью roomRepository
        if(roomRepository.getBy(id) != null)
            roomRepository.save(room);
        return room;
    }

    @Override
    public void deleteRoom(Room room) {
        // удалить переданную комнату с помощью roomRepository вместе со всеми прикрепленными к ней
        // бронированиями
        roomRepository.delete(room);
    }

    @Override
    public Map<RoomType, List<Room>> getRoomsGroupByType() {
        // получить комнаты, сгрупированные по типу, то есть должна получиться мапа вида
        // {LUXE: [Room1, Room2, Room3], ECONOM: [Room5, Room6], ... }
        Map<RoomType, List<Room>> map = new HashMap<RoomType, List<Room>>();
        for(RoomType roomType : RoomType.values()){
            List<Room> rooms = new ArrayList<Room>();
            for(Room room : roomRepository.getAll()){
                if(room.getType() == roomType)
                    rooms.add(room);
            }
            map.put(roomType, rooms);
        }
        return map;
    }
}
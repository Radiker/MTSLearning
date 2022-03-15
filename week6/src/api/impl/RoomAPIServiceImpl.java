package api.impl;

import api.RoomAPIService;
import entity.Room;
import entity.RoomType;
import service.impl.BookingServiceImpl;
import service.impl.RoomServiceImpl;

import java.util.List;
import java.util.Map;

public class RoomAPIServiceImpl implements RoomAPIService {
    RoomServiceImpl roomService = new RoomServiceImpl();

    @Override
    public Room createRoom(Room room) {
        return roomService.createRoom(room);
    }

    @Override
    public Room updateRoom(String id, Room room) {
        return roomService.updateRoom(id, room);
    }

    @Override
    public Room getRoom(String id) {
        return roomService.getBy(id);
    }

    @Override
    public Map<RoomType, List<Room>> getRoomsGroupedByType() {
        return roomService.getRoomsGroupByType();
    }

    @Override
    public void deleteRoom(String id) {
        Room room = roomService.getBy(id);
        roomService.deleteRoom(room);
    }
}

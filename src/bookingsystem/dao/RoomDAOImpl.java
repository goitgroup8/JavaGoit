package bookingsystem.dao;

import bookingsystem.model.Room;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RoomDAOImpl extends AbstractDAOImpl<Room> implements RoomDAO {
    public Room findRoomByIdWithHotelCheck(long hotelId, long roomId) {
        List<Room> rooms = getRoomsByHotelId(hotelId);
        Optional<Room> op = rooms.stream().filter(r -> r.getId() == roomId).findFirst();
        return op.orElse(null);
    }

    public List<Room> getRoomsByHotelId(long id) {
        List<Room> result = getAll().stream().filter(r -> r.getHotel().getId() == id).collect(Collectors.toList());
        return result;
    }
}

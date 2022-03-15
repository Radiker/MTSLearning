package repository.impl;

import entity.Booking;
import entity.Room;
import repository.BookingRepository;

import java.util.HashSet;
import java.util.Set;

public class BookingRepositoryImpl implements BookingRepository {
    private static final Set<Booking> bookings = new HashSet<>();

    // реализовать конструктор
    public BookingRepositoryImpl() {

    }

    @Override
    public Booking save(Booking booking) {
        // аналогично RoomRepository, создает новое бронирование, если такого id нет и
        // обновляет, если бронирование с таким идентификатором существует
        if(getBy(booking.getId()) == null)
            bookings.add(booking);
        for (Booking b: bookings) {
            if(b.getId().equals(booking.getId())){
                b.setCheckIn(booking.getCheckIn());
                b.setCheckOut(booking.getCheckOut());
                b.setGuest(booking.getGuest());
                b.setRoom(booking.getRoom());
            }
        }
        return booking;
    }

    @Override
    public void delete(Booking booking) {
        // удаляет бронирование из поля bookings, если такого нет -- ничего не происходит
        if(getBy(booking.getId()) != null)
            bookings.remove(booking);
    }

    @Override
    public Booking getBy(String id) {
        // возвращает бронирование по идентификатору, если такого нет -- вернуть null
        for (Booking booking: bookings) {
            if(booking.getId().equals(id))
                return booking;
        }
        return null;
    }

    @Override
    public Set<Booking> getAll() {
        // возвращает все бронирования
        return bookings;
    }
}
package service.impl;

import entity.*;
import repository.BookingRepository;
import repository.impl.BookingRepositoryImpl;
import service.*;
import service.exceptions.*;

import java.util.HashSet;
import java.util.Set;

public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final RoomService roomService;

    // реализовать конструктор
    public BookingServiceImpl(BookingRepository bookingRepository, RoomService roomService) {
        this.bookingRepository = bookingRepository;
        this.roomService = roomService;
    }

    public BookingServiceImpl() {
        this.bookingRepository = new BookingRepositoryImpl();
        this.roomService = new RoomServiceImpl();
    }

    @Override
    public Booking getBy(String id) throws BookingNotFoundException {
        // получить бронирование по идентификатору, если не найдено -- выкинуть
        // BookingNotFoundException (его нужно создать)
        Booking booking = bookingRepository.getBy(id);
        if(booking == null)
            throw new BookingNotFoundException();
        return booking;
    }

    @Override
    public Booking createBooking(Booking booking) throws RequiredFieldMissedException, RoomNotFoundException{
        // здесь нужно с помощью bookingRepository создать бронирование
        // проверить, что checkIn, checkOut, guest и room != null -- иначе выкинуть
        // RequiredFieldMissedException
        // проверить, что переданная комната существует -- иначе выкинуть RoomNotFoundException
        // обновить комнату, переданную в запросе на создание бронирования, добавив это самое
        // бронирование в поле bookings комнаты
        if(booking.getCheckIn() == null || booking.getCheckOut() == null ||
                booking.getGuest() == null || booking.getRoom() == null)
            throw new RequiredFieldMissedException();
        if(roomService.getBy(booking.getRoom().getId()) == null)
            throw new RoomNotFoundException();
        Set<Booking> bookings = new HashSet<Booking>();
        bookings.add(booking);
        booking.getRoom().setBookings(bookings);
        return booking;
    }

    @Override
    public Booking updateBooking(String id, Booking booking) throws RequiredFieldMissedException, BookingNotFoundException, RoomNotFoundException{
        // проверить, что заполнено поле id -- иначе выкинуть RequiredFieldMissedException
        if(id == null)
            throw new RequiredFieldMissedException();
        // проверить, что такое бронирование существует -- иначе выкинуть BookingNotFoundException
        if(bookingRepository.getBy(id) == null)
            throw new BookingNotFoundException();
        // обновить с помощью bookingRepository данные бронирования
        bookingRepository.save(booking);
        // если переданное поле room не равно null, проверить, что комната с таким id существует --
        // иначе выкинуть RoomNotFoundException
        if(booking.getRoom() == null || roomService.getBy(booking.getRoom().getId()) == null)
            throw new RoomNotFoundException();

        // обновить данные комнат, удалив бронирование из прежней комнаты и поместив его в новую
        Set<Booking> bookings = new HashSet<Booking>();
        for(Booking b : booking.getRoom().getBookings())
            if(!b.getId().equals(id))
                bookings.add(b);
            else {
                Set<Booking> bs = b.getRoom().getBookings();
                bs.remove(b);
            }
        booking.getRoom().setBookings(bookings);
        return booking;
    }

    @Override
    public void deleteBooking(Booking booking) {
        // удалить бронирование с помощью bookingRepository
        // удалить бронирование из комнаты в которой оно было
        Set<Booking> bookings = booking.getRoom().getBookings();
        bookings.remove(booking);
        booking.getRoom().setBookings(bookings);
        bookingRepository.delete(booking);
    }
}

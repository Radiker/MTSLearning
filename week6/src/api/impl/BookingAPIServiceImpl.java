package api.impl;

import api.BookingAPIService;
import entity.Booking;
import service.impl.BookingServiceImpl;

public class BookingAPIServiceImpl implements BookingAPIService {
    BookingServiceImpl bookingService = new BookingServiceImpl();

    @Override
    public Booking createBooking(Booking booking) {
        return bookingService.createBooking(booking);
    }

    @Override
    public Booking updateBooking(String id, Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    @Override
    public Booking getBooking(String id) {
        return bookingService.getBy(id);
    }

    @Override
    public void deleteBooking(String id) {
        Booking booking = bookingService.getBy(id);
        bookingService.deleteBooking(booking);
    }
}

package service;

import entity.Booking;

/**
 * Сервис бронирований.
 */
public interface BookingService {
    /**
     * Получить бронирование по идентификатору.
     *
     * @param id идентификатор
     * @throws BookingNotFoundException если бронирование с таким id не найдено
     * @return бронирование
     */
    Booking getBy(String id);

    /**
     * Создать бронирование.
     *
     * @param booking бронирование
     * @return созданное бронирование с присвоенным идентификатором
     */
    Booking createBooking(Booking booking);

    /**
     * Обновить бронирование.
     *
     * @param обновленное бронирование
     * @throws BookingNotFoundException если бронирование с таким id не найдено
     * @return обновленное бронирование
     */
    Booking updateBooking(String id, Booking booking);

    /**
     * Удалить бронирование.
     *
     * @param booking бронирование
     */
    void deleteBooking(Booking booking);
}
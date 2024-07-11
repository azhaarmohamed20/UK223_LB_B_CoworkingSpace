package service;

import model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BookingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id){
        return bookingRepository.findById(id);
    }

    public Booking createBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking bookingDetails){
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setUserId(bookingDetails.getUserId());
        booking.setWorkspaceId(bookingDetails.getWorkspaceId());
        booking.setBookingDate(bookingDetails.getBookingDate());
        booking.setBookingStatus(bookingDetails.getBookingStatus());
        return bookingRepository.save(booking);
    }

    public Optional<Booking> deleteBooking(Long id){
        Optional<Booking> booking = bookingRepository.findById(id);
        if(booking.isPresent()){
            bookingRepository.deleteById(id);
        }
        return booking;
    }
}

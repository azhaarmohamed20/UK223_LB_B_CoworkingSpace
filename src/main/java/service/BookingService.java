package service;

import model.Booking;
import model.User;
import model.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import repository.BookingRepository;
import repository.UserRepository;
import repository.WorkspaceRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private BookingRepository bookingRepository;
    private final WorkspaceRepository workspaceRepository;
    private final UserRepository userRepository;

    public BookingService(BookingRepository bookingRepository, WorkspaceRepository workspaceRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.workspaceRepository = workspaceRepository;
        this.userRepository = userRepository;
    }

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id){
        return bookingRepository.findById(id);
    }

    public Booking createBooking(Booking booking) {
        booking.setBookingDate(LocalDateTime.now());

        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        booking.setUser(currentUser);

        // Hier nehmen wir an, dass die Workspace-ID im Booking-Objekt gesetzt ist
        Long workspaceId = booking.getWorkspace().getId();
        Workspace workspace = workspaceRepository.findById(workspaceId)
                .orElseThrow(() -> new RuntimeException("Workspace not found"));
        booking.setWorkspace(workspace);

        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking bookingDetails){
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setUser(bookingDetails.getUser());
        booking.setWorkspace(bookingDetails.getWorkspace());
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

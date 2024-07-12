package controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.BookingService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/booking")
@Tag(name = "Booking", description = "Booking management APIs")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/admin")
    @Operation(summary = "Get all bookings", description = "Get all bookings in the system")
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/admin/{id}")
    @Operation(summary = "Get a single bookings", description = "Get all single booking in the system")
    public Optional<Booking> getBookingByID(@PathVariable Long id){
        return bookingService.getBookingById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new booking", description = "Creates a new booking in the system")
    public Booking createBooking(@RequestBody Booking booking){
        return bookingService.createBooking(booking);
    }

    @PutMapping("/admin/{id}")
    @Operation(summary = "Update a booking", description = "Updates a booking in the system")
    public Booking updateBooking(@PathVariable Long id,@RequestBody Booking bookingDetails){
        return bookingService.updateBooking(id, bookingDetails);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a booking", description = "Deletes a booking in the system")
    public Optional<Booking> deleteBooking(@PathVariable Long id){
        return bookingService.deleteBooking(id);
    }
}

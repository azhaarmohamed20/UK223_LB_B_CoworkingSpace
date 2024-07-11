package model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Setter
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User userId;

    @OneToOne
    @JoinColumn(name = "workingspace_id")
    private Workingspace workingspaceId;

    private LocalDateTime bookingDate;

    private String bookingStatus;



}

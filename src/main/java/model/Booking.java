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
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "workspace_id",  nullable = false)
    private Workspace workspace;

    private LocalDateTime bookingDate;

    private String bookingStatus;


    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    public Workspace getWorkspace() {
        return this.workspace;
    }
}

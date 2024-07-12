package model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
@Entity
@Table(name = "workspace")
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String location;

    private boolean availability;
}

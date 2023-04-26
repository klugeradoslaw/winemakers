package pl.klugeradoslaw.winemakers.wine;

import jakarta.persistence.*;
import pl.klugeradoslaw.winemakers.step.Step;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // yyyy-MM-dd
    private LocalDate dateOfStart;
    private String shortDescription;
    private String longDescription;
    @Enumerated(EnumType.STRING)
    private WineStatus status;
    @OneToMany
    @JoinColumn(name = "wine_id")
    private List<Step> steps = new ArrayList<>();

}

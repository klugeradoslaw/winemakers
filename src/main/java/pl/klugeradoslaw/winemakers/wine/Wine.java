package pl.klugeradoslaw.winemakers.wine;

import jakarta.persistence.*;
import pl.klugeradoslaw.winemakers.step.Step;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //data????
    private Date dateOfStart;
    private String shortDescription;
    private String longDescription;
    @Enumerated(EnumType.STRING)
    private WineStatus status;
    @OneToMany
    @JoinColumn(name = "wine_id")
    private List<Step> steps = new ArrayList<>();

}

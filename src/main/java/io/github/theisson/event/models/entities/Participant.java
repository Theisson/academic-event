package io.github.theisson.event.models.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "participants")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
        name = "participant_activity",
        joinColumns = @JoinColumn(name = "participant_id"),
        inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private Set<Activity> activities = new HashSet<>();

    protected Participant() {}

    public Participant(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Set<Activity> getActivities() {
        return Collections.unmodifiableSet(activities);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participant)) return false;
        Participant participant = (Participant) o;
        return id != null && id.equals(participant.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

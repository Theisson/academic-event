package io.github.theisson.event.models.entities;

import java.time.Instant;
import jakarta.persistence.*;

@Entity
@Table(name = "time_blocks")
public class TimeBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Instant startTime;

    @Column(nullable = false)
    private Instant endTime;

    @ManyToOne
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;

    protected TimeBlock() {}

    public TimeBlock(Instant startTime, Instant endTime, Activity activity) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.activity = activity;
    }

    public Integer getId() {
        return id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public Activity getActivity() {
        return activity;
    }
}

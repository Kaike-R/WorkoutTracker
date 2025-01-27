package br.com.kaikedev.workouttracker.Entities;

import br.com.kaikedev.workouttracker.Entities.Users;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "workouts") // Define explicitamente o nome da tabela
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Mais comum para bancos SQL
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column
    private LocalDateTime appointment;

    @Column(nullable = false, name = "CREATED_AT")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "UPDATED_AT")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ElementCollection
    @CollectionTable(name = "workout_exercises", joinColumns = @JoinColumn(name = "workout_id"))
    @Column(name = "exercise") // Nome da coluna no banco
    private List<String> exercises;

//    @ElementCollection
//    @CollectionTable(name = "workout_comments", joinColumns = @JoinColumn(name = "workout_id"))
//    @Column(name = "comment") // Nome da coluna no banco
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comments> comments;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public Workout(String title, String description, LocalDateTime appointment, List<String> exercises, Users user) {
        this.title = title;
        this.description = description;
        this.appointment = appointment;
        this.exercises = exercises;
        this.user = user;
    }
}

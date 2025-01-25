package br.com.kaikedev.workouttracker.Repositories;


import br.com.kaikedev.workouttracker.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    public Users findByEmail(String email);
}

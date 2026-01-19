package in.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.voting.models.Poll;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {

}

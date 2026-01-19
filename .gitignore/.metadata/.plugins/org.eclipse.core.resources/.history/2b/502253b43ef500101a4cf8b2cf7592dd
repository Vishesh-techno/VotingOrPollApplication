package in.voting.services;

import java.util.List;

import org.springframework.stereotype.Service;

import in.voting.models.Poll;
import in.voting.repository.PollRepository;

@Service
public class PollService {

	private PollRepository pollRepository;
	
	public PollService(PollRepository pollRepository) {
		this.pollRepository = pollRepository;
	}


	public Poll createPoll(Poll poll) {
		return pollRepository.save(poll);
	}
	
	public List<Poll> getAllPolls() {
		return pollRepository.findAll();
	}

}

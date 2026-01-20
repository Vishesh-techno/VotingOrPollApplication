package in.voting.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.voting.models.OptionVote;
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


	public Optional<Poll> getPollById(Long id) {
		return pollRepository.findById(id);
	}


	public void vote(Long pollId, int optionIndex) {
//		Get poll from DB
		Poll poll = pollRepository.findById(pollId)
				.orElseThrow(() -> new RuntimeException("Poll not found"));
//		Get all Options
		List<OptionVote> options = poll.getOptions();
		
//		if index vote is not valid, throw error
		if(optionIndex < 0 || optionIndex >= options.size()) {
			throw new IllegalArgumentException("Invalid Option");
		}
		
//		Get selected options
		OptionVote selectedOption = options.get(optionIndex);
		
//		Incremented value for selected Options
		selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);
		
//		save incremented option in DataBase
		pollRepository.save(poll);
		
	}

}

package org.u5w2d5.travel;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.u5w2d5.response.CreateResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class TravelService {
	private final TravelRepository travelRepository;

	public Travel travelFromRequest (TravelRequest travelRequest) {
		Travel travel = new Travel();
		BeanUtils.copyProperties(travelRequest, travel);
		return travel;
	}

	public TravelResponse travelResponseFromEntity (Travel travel) {
		TravelResponse travelResponse = new TravelResponse();
		BeanUtils.copyProperties(travel, travelResponse);
		return travelResponse;
	}

	public List<TravelResponse> travelResponsesListFromEntitiesList (@NotNull List<Travel> travels) {
		return travels.stream().map(this::travelResponseFromEntity).toList();
	}

	public List<TravelResponse> findAll () {
		return this.travelResponsesListFromEntitiesList(this.travelRepository.findAll());
	}

	public Travel findById (Long id) {
		return this.travelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Travel not found"));
	}

	public TravelDetailResponse findDetailById (Long id) {
		if (!this.travelRepository.existsById(id))
			throw new EntityNotFoundException("Travel not found");

		TravelDetailResponse travelDetailResponse = new TravelDetailResponse();
		BeanUtils.copyProperties(this.findById(id), travelDetailResponse);
		return travelDetailResponse;
	}

	public TravelDetailResponse update (Long id, @Valid @NotNull TravelRequest travelRequest) {
		Travel travel = this.findById(id);
		BeanUtils.copyProperties(travelRequest, travel);
		this.travelRepository.save(travel);
		return this.findDetailById(id);
	}

	public TravelDetailResponse updateState (Long id, @Valid @NotNull TravelState state) {
		Travel travel = this.findById(id);
		travel.setState(state);
		this.travelRepository.save(travel);
		return this.findDetailById(id);
	}

	public CreateResponse save (@Valid @NotNull TravelRequest travelRequest) {
		Travel travel = this.travelFromRequest(travelRequest);
		this.travelRepository.save(travel);
		return new CreateResponse(travel.getId());
	}

	public void deleteById (Long id) {
		this.travelRepository.deleteById(id);
	}
}

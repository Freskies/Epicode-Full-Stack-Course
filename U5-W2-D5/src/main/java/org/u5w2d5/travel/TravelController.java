package org.u5w2d5.travel;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.u5w2d5.response.CreateResponse;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping ("/api/travels")
@RequiredArgsConstructor
public class TravelController {
	private final TravelService travelService;

	@GetMapping
	@ResponseStatus (HttpStatus.OK)
	public List<TravelResponse> findAll () {
		return this.travelService.findAll();
	}

	@GetMapping ("/{id}")
	@ResponseStatus (HttpStatus.OK)
	public TravelDetailResponse findById (@PathVariable Long id) {
		return this.travelService.findDetailById(id);
	}

	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public CreateResponse save (@RequestBody TravelRequest travelRequest) {
		return this.travelService.save(travelRequest);
	}

	@PutMapping ("/{id}")
	@ResponseStatus (HttpStatus.OK)
	public TravelDetailResponse update (@PathVariable Long id, @RequestBody TravelRequest travelRequest) {
		return this.travelService.update(id, travelRequest);
	}

	@DeleteMapping ("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id) {
		this.travelService.deleteById(id);
	}

	@PatchMapping ("/{id}")
	@ResponseStatus (HttpStatus.OK)
	public TravelDetailResponse updateState (@PathVariable Long id, @RequestBody String state) {
		Pattern pattern = Pattern.compile("\"state\":\\s*\"(.*?)\"");
		TravelState travelState = TravelState.valueOf(
			pattern.matcher(state).results().findFirst().orElseThrow().group(1)
		);
		return this.travelService.updateState(id, travelState);
	}
}

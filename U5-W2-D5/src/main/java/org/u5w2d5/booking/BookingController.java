package org.u5w2d5.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.u5w2d5.response.CreateResponse;

import java.util.List;

@RestController
@RequestMapping ("/api/bookings")
@RequiredArgsConstructor
public class BookingController {
	private final BookingService bookingService;

	@GetMapping
	@ResponseStatus (HttpStatus.OK)
	public List<BookingResponse> findAll () {
		return this.bookingService.findAll();
	}

	@GetMapping ("/{id}")
	@ResponseStatus (HttpStatus.OK)
	public BookingResponse findById (@PathVariable Long id) {
		return this.bookingService.findBookingResponseById(id);
	}

	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public CreateResponse save (@RequestBody BookingRequest bookingRequest) {
		return this.bookingService.save(bookingRequest);
	}

	@PutMapping ("/{id}")
	@ResponseStatus (HttpStatus.OK)
	public BookingResponse update (@PathVariable Long id, @RequestBody BookingRequest bookingRequest) {
		return this.bookingService.update(id, bookingRequest);
	}

	@DeleteMapping ("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id) {
		this.bookingService.deleteById(id);
	}
}

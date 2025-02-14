package org.u5w2d5.booking;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.u5w2d5.employee.EmployeeRepository;
import org.u5w2d5.response.CreateResponse;
import org.u5w2d5.travel.TravelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class BookingService {
	private final BookingRepository bookingRepository;
	private final EmployeeRepository employeeRepository;
	private final TravelRepository travelRepository;

	public Booking bookingFromRequest (@NotNull BookingRequest bookingRequest) {
		Booking booking = new Booking();
		booking.setRequestedAt(bookingRequest.requestedAt());
		booking.setNotes(bookingRequest.notes());
		booking.setEmployee(this.employeeRepository.findById(bookingRequest.employeeId()).orElseThrow());
		booking.setTravel(this.travelRepository.findById(bookingRequest.travelId()).orElseThrow());
		return booking;
	}

	public BookingResponse bookingResponseFromEntity (Booking booking) {
		BookingResponse bookingResponse = new BookingResponse();
		BeanUtils.copyProperties(booking, bookingResponse);
		return bookingResponse;
	}

	public List<BookingResponse> bookingResponsesListFromEntitiesList (@NotNull List<Booking> bookings) {
		return bookings.stream().map(this::bookingResponseFromEntity).toList();
	}

	public List<BookingResponse> findAll () {
		return this.bookingResponsesListFromEntitiesList(this.bookingRepository.findAll());
	}

	public Booking findById (Long id) {
		return this.bookingRepository.findById(id).orElseThrow();
	}

	public BookingResponse findBookingResponseById (Long id) {
		return this.bookingResponseFromEntity(this.findById(id));
	}

	public BookingResponse update (Long id, BookingRequest bookingRequest) {
		Booking booking = this.findById(id);
		BeanUtils.copyProperties(this.bookingFromRequest(bookingRequest), booking);
		this.bookingRepository.save(booking);
		return this.bookingResponseFromEntity(booking);
	}

	public CreateResponse save (BookingRequest bookingRequest) {
		Booking booking = this.bookingFromRequest(bookingRequest);
		this.bookingRepository.save(booking);
		return new CreateResponse(booking.getId());
	}

	public void deleteById (Long id) {
		this.bookingRepository.deleteById(id);
	}
}

package org.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.auth.AppUser;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {
	private long id;
	private String title;
	private String description;
	private String location;
	private LocalDate date;
	private int maxParticipants;
	private AppUser organizer;
	private List<AppUser> participants;
}

package org.events;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
	List<Event> findAllByOrganizerId (Long id);
}

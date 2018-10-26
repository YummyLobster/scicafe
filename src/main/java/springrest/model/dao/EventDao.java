package springrest.model.dao;

import java.util.List;

import springrest.model.Event;

public interface EventDao {

    Event getEvent( Long id );

    List<Event> getEvents();

    Event saveEvent( Event event );
    
}
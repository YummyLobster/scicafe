package springrest.api.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springrest.api.error.RestException;
import springrest.model.Event;
import springrest.model.User;
import springrest.model.dao.EventDao;
import springrest.model.dao.UserDao;

@RestController
public class EventController {

    @Autowired
    private EventDao eventDao;
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
    public Event getEvent( @PathVariable Long id )
    {
        return eventDao.getEvent( id );
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> getEvents()
    {
        return eventDao.getEvents();
    }
    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public Event addEvent( @RequestBody Event event )
    {
        if( event.getTitle() == null || event.getDescription() == null || event.getEnd_date() == null || event.getStart_date() == null ||
        		event.getLocation() == null  )
            throw new RestException( 400, "Missing attributes." );

        return eventDao.saveEvent( event );
    }
    @RequestMapping(value = "/events/{id}/approval", method = RequestMethod.POST)
    public Event approveEvent(@RequestBody Event event,
    								@PathVariable Long id){

    	
    	Event eventApprove = eventDao.getEvent(id); 
    	eventApprove.setStatus(event.getStatus());
    	
    	return eventDao.saveEvent(eventApprove);

    }
    @RequestMapping(value = "/events/{id}/attendee", method = RequestMethod.POST)
    public Event addAttendee(@RequestBody User users,
    								@PathVariable Long id){
    	User user = userDao.getUser(users.getId());
    	Event event=eventDao.getEvent(id);
		
		if(event==null)
			throw new RestException(400, "No such Event found");
		if(user==null)
			throw new RestException(400, "No such User found");
		
		event.getEvents_attendance().add(user);
		
		return eventDao.saveEvent(event);

    }
    @RequestMapping(value = "/events/{id}/attendee", method = RequestMethod.GET)
	public Set<User> getEventAttendee(@PathVariable Long id) {
		
		Event event=eventDao.getEvent(id);
		
		if(event==null)
			throw new RestException(400, "No such Event found");
		
		return event.getEvents_attendance();

	}
}
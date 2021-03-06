package springrest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springrest.api.error.RestException;
import springrest.model.User;
import springrest.model.dao.UserDao;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser( @PathVariable Long id )
    {
        return userDao.getUser( id );
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers()
    {
        return userDao.getUsers();
    }
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User addUser( @RequestBody User user )
    {
        if( user.getUsername() == null || user.getPassword() == null || user.getEmail() == null || user.getFirstName() == null ||
        		user.getLastName() == null || user.getPosition() == null || user.getOrgOrMajor() == null )
            throw new RestException( 400, "Missing username and/or password or other message." );

        return userDao.saveUser( user );
    }

}
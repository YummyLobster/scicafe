package springrest.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springrest.model.Organization;
import springrest.model.Role;
import springrest.model.User;

@RestController
public class TestController {

    @RequestMapping("/test")
    public User test()
    {
        Role role = new Role();
        role.setId( 1L );
        role.setName( "Admin" );
        
        Organization org = new Organization();
        org.setId( 1L );
        org.setName( "CSULA" );
        
        User user = new User();
        user.setId( 1L );
        user.setUsername( "cysun" );
        user.getRoles().add( role );
//        user.getOrg().add( org );

        return user;
    }

}
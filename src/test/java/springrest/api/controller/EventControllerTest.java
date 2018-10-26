package springrest.api.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:springrest-servlet.xml",
    "classpath:applicationContext.xml" })
class EventControllerTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext wac;

    
    private MockMvc mockMvc;
   

    @BeforeClass
    void setup()
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup( wac ).build();
     
    }
    @Test
    void getEvent() throws Exception
    {
        this.mockMvc.perform( get( "/events/1" ) )
            .andExpect( status().isOk() )
            .andExpect( jsonPath( "title" ).value( "Welcome Week" ) );
    }

    @Test
    void getEvents() throws Exception
    {
        this.mockMvc.perform( get( "/events" ) )
            .andExpect( status().isOk() )
            .andExpect( jsonPath( "$[0].title" ).value("Welcome Week") );
    }

    @Test
    void getEvents2() throws Exception
    {
        this.mockMvc.perform( get( "/events" ) )
            .andExpect( status().isOk() )
            .andExpect( jsonPath( "$.length()" )
                .value( Matchers.greaterThanOrEqualTo( 2 ) ) );
    }
    
    @Test
    void addEventFail() throws Exception
    {
    	this.mockMvc.perform( post( "/events" ).contentType( "application/json" )
                .content( "{\"title\":\"Midterm Week\", \"location\": \"Library\"}" ) )
             .andExpect( status().is4xxClientError() );
    }
    @Test
    @Rollback(false)
    void addEventPass() throws Exception
    {
    	this.mockMvc.perform( post( "/events" ).contentType( "application/json" )
                .content( "{\"title\":\"Midterm Week\", \"location\": \"Library\", \"description\": \"Lets have some free pizza\","
                		+ " \"start_date\": \"1534766400000\", \"end_date\": \"1535371200000\"}" ) )
             .andExpect( status().is2xxSuccessful() );
    }
    
    @Test
    void approveEventFail() throws Exception
    {
    	this.mockMvc
        .perform( post( "/events/1/approval" ).contentType( "application/json" )
            .content( "{\"status\": \"cs5220\"}" ) )
        .andExpect( status().is5xxServerError());
    }
    @Test
    @Rollback(false)
    void approveEventPass() throws Exception
    {
    	this.mockMvc
        .perform( post( "/events/1/approval" ).contentType( "application/json" )
            .content( "{\"status\": \"POSTED\"}" ) )
        .andExpect( status().is2xxSuccessful() );
    }
    @Test
    void addEventAttendeeFail() throws Exception
    {
    	this.mockMvc
        .perform( post( "/events/1/attendee" ).contentType( "application/json" )
            .content( "{\"id\": \"100\"}" ) )
        .andExpect( status().is4xxClientError());
    }
    @Test
    @Rollback(false)
    void addEventAttendeePass() throws Exception
    {
    	this.mockMvc
        .perform( post( "/events/1/attendee" ).contentType( "application/json" )
            .content( "{\"id\": \"1\"}" ) )
        .andExpect( status().is2xxSuccessful() );
    }
    
    @Test
    void getEventAttendee2() throws Exception
    {
        this.mockMvc.perform( get( "/events/1/attendee" ) )
            .andExpect( status().isOk() )
            .andExpect( jsonPath( "$.length()" )
                .value( Matchers.greaterThanOrEqualTo( 2 ) ) );
    }

}
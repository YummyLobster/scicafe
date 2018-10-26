package springrest.api.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
class ProgramControllerTest extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeClass
    void setup()
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup( wac ).build();

    }
    @Test
    void getProgram() throws Exception
    {
        this.mockMvc.perform( get( "/programs/1" ) )
            .andExpect( status().isOk() )
            .andExpect( jsonPath( "name" ).value( "FYrE@ECST" ) );
    }
    @Test
    void getPrograms() throws Exception
    {
        this.mockMvc.perform( get( "/programs" ) )
            .andExpect( status().isOk() )
            .andExpect( jsonPath( "$[0].name" ).value( "FYrE@ECST" ) );
    }
    @Test
    void getPrograms2() throws Exception
    {
        this.mockMvc.perform( get( "/programs" ) )
            .andExpect( status().isOk() )
            .andExpect( jsonPath( "$.length()" )
                .value( Matchers.greaterThanOrEqualTo( 2 ) ) );
    }

    @Test
    void addProgramFail() throws Exception
    {
        this.mockMvc
            .perform( post( "/programs" ).contentType( "application/json" )
                .content( "{\"name\": \"cs5220\", \"fullName\": \"webProgramming\"}" ) )
            .andExpect( status().is4xxClientError());


    }
    @Test
    @Rollback(false)
    void addProgramPass() throws Exception
    {
        this.mockMvc
            .perform( post( "/programs" ).contentType( "application/json" )
               .content( "{\"name\": \"cs5220\", \"fullName\": \"webProgramming\", \"description\":\"2018 Fall java spring web design\"}" ) )
            .andExpect( status().is2xxSuccessful() );
    }
    @Test
    void editProgramFail() throws Exception
    {
    	this.mockMvc
        .perform( post( "/programs/2/edit" ).contentType( "application/json" )
            .content( "{\"name\": \"cs5220\", \"fullName\": \"webProgramming\"}" ) )
        .andExpect( status().is4xxClientError());


    }
    
    @Test
    @Rollback(false)
    void editProgramPass() throws Exception
    {
    	this.mockMvc
        .perform( post( "/programs/2/edit" ).contentType( "application/json" )
           .content( "{\"name\": \"cs5220\", \"fullName\": \"webProgramming\", \"description\":\"2018 Fall java spring web design\"}" ) )
        .andExpect( status().is2xxSuccessful() );
    }
    
    @Test
    @Rollback(false)
    void deleteProgram() throws Exception
    {
    	this.mockMvc.perform( delete( "/programs/3/delete"))
    	.andExpect( status().is2xxSuccessful() );
    }
}

package springrest.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springrest.api.error.RestException;
import springrest.model.Program;
import springrest.model.dao.ProgramDao;

@RestController
public class ProgramController {

    @Autowired
    private ProgramDao programDao;

    @RequestMapping(value = "/programs/{id}", method = RequestMethod.GET)
    public Program getProgram( @PathVariable Long id )
    {
        return programDao.getProgram( id );
    }

    @RequestMapping(value = "/programs", method = RequestMethod.GET)
    public List<Program> getPrograms()
    {
        return programDao.getPrograms();
    }

    @RequestMapping(value = "/programs", method = RequestMethod.POST)
    public Program addProgram( @RequestBody Program program )
    {
        if( program.getName() == null ||program.getFullName() == null ||program.getDescription() == null   )
            throw new RestException( 400, "Missing attributes." );

        return programDao.saveProgram( program );
    }
    
    @RequestMapping(value = "/programs/{id}/edit", method = RequestMethod.POST)
    public Program editProgram(@RequestBody Program program,
    								@PathVariable Long id){
    	if( program.getName() == null ||program.getFullName() == null ||program.getDescription() == null   )
            throw new RestException( 400, "Missing attributes." );
    	
        Program programEdit = programDao.getProgram(id); 
    	programEdit.setName(program.getName());
    	programEdit.setFullName(program.getFullName());
    	programEdit.setDescription(program.getDescription());
    	
    	return programDao.saveProgram(programEdit);

    }
}
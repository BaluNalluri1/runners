package dev.balu.runnerz.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

//    @GetMapping("/hello")
//    String home(){
//        return "Hello Runners";
//    }


    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository= runRepository;
    }



    @GetMapping("")
    List<Run> findAll(){
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()){
           // throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            throw new RunNotFoundException();
        }
        return run.get();
    }

    //create
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(Run run){
        runRepository.create(run);
    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody Run run, @PathVariable Integer id){
         runRepository.update(run, id);
    }


    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        runRepository.delete(id);
    }
}

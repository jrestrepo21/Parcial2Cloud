package co.com.poli.movieservice.controller;

import co.com.poli.movieservice.helpers.ErrorMessage;
import co.com.poli.movieservice.helpers.Response;
import co.com.poli.movieservice.helpers.ResponseBuild;
import co.com.poli.movieservice.persistence.entity.Movie;
import co.com.poli.movieservice.service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ResponseBuild builder;

    @GetMapping("/{id}")
    public Response findByID(@PathVariable("id") Long id){
        return builder.success(movieService.findById(id));
    }

    @GetMapping
    public Response findAll(){
        return builder.success(movieService.findAll());
    }

    @PostMapping
    public Response save(@Valid @RequestBody Movie movie, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(this.formatMessage(result));
        }
        movieService.save(movie);
        return builder.success(movie);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        Movie movie = (Movie) findByID(id).getData();
        if(movie==null){
            return builder.failed("Not found");
        }
        return builder.success(movie);
    }
    private String formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(error -> {
                    Map<String, String> err = new HashMap<>();
                    err.put(error.getField(), error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .error(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return json;
    }

}

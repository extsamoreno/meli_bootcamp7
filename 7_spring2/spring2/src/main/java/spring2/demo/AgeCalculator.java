package spring2.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("")
public class AgeCalculator {
    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<String> getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        try{
            var date = LocalDate.of(year,month,day);
            return new ResponseEntity<>(Integer.toString(Period.between(date, LocalDate.now()).getYears()), HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

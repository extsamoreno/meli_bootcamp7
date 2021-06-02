package com.example.ages;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.time.Period;
import java.time.LocalDate;
@RestController


public class AgeController{

    @GetMapping("year/{year}/month/{month}/day/{day}/age")
    public ResponseEntity<String> getAge(@PathVariable String year, @PathVariable String month, @PathVariable String day){

        String date = this.formatDate(year, month, day);

        int age = Period.between(LocalDate.parse(date),LocalDate.now()).getYears();

        return new ResponseEntity<>(String.valueOf(age), HttpStatus.OK);
    }

    private String formatDate(String year, String month, String day){

        if(day.length() < 2){
            while(day.length() < 2){
                day = "0"+day;
            }
        }
        if(month.length() < 2){
            while(month.length() < 2){
                month = "0"+month;
            }
        }
        if(year.length() < 4){
            while(year.length() < 4){
                year = year+"0";
            }
        }

        return year+"-"+month+"-"+day;

    }

}

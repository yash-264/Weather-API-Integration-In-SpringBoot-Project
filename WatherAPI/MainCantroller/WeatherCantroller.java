package yash.example.WatherAPI.MainCantroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yash.example.WatherAPI.Entity.WeatherEntity;
import yash.example.WatherAPI.Services.WeatherServices;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("weather")
public class WeatherCantroller {

    @Autowired
    private WeatherServices weatherServices;


    @GetMapping("/{city}")
    public ResponseEntity<?> getWeather(@PathVariable String city){

        WeatherEntity weatherResponse = weatherServices.getWeatherAPI(city);

        List<String> weatherList=new ArrayList<>();


        String greetings="";

        if (weatherResponse != null){

//         greetings=", Weather feels like "+ weatherResponse.getCurrent().getWeatherCode();

            weatherList.add(" Weather Code : "+ weatherResponse.getCurrent().getWeatherCode());
            weatherList.add(" Weather feels like : "+ weatherResponse.getCurrent().getFeelslike()+ "c");
            weatherList.add(" Weather Observation Time : "+ weatherResponse.getCurrent().getObservationTime());
            weatherList.add(" Weather Description : "+ weatherResponse.getCurrent().getWeatherDescriptions());
            weatherList.add(" Weather Temperature Is :  "+ weatherResponse.getCurrent().getTemperature()+"c");
            weatherList.add(" Local Time Is : " + LocalDateTime.now());

        }


//        return new ResponseEntity<>(weatherList,HttpStatus.OK);



        return new ResponseEntity<>("Hii \n "+"  User, \n"+ String.join("\n",weatherList) , HttpStatus.OK);

    }

}







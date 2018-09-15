package telran.hotcities.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.hotcities.gateway.ExternalWeatherGateway;
import telran.hotcities.model.HottestCity;

@Service
public class WeatherService {
	
	private ExternalWeatherGateway gateway;
	
	public WeatherService(@Autowired ExternalWeatherGateway gateway) {
		this.gateway = gateway;
	}
	
	public HottestCity getHottestCity(String [] cities) {
		return new HottestCity("Berlin", "25");
	}
	

}

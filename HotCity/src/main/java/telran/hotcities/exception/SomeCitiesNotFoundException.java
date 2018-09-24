package telran.hotcities.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class SomeCitiesNotFoundException extends Exception {
	public SomeCitiesNotFoundException(String msg) {
		super(msg);
	}
	

}

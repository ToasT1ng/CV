package info.toast1ng.cv.controller.util;

import com.google.gson.Gson;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public final class MakeReturn {
    public static <T> ResponseEntity<String> makeHttpStatusOk(T object) {
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(new Gson().toJson(object), httpHeaders, HttpStatus.OK);
    }
}

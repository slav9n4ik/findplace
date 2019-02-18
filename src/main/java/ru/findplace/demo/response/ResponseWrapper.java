package ru.findplace.demo.response;

import lombok.Getter;
import lombok.Setter;
import ru.findplace.demo.utils.ConcurrentSimpleDateFormat;

import java.util.Date;

@Getter
@Setter
public class ResponseWrapper {

    private int code;
    private String phraseText;
    private Object data;
    private String date;

    public ResponseWrapper(Response response, Object date) {
        this.code = response.getCode();
        this.phraseText = response.getReasonPhrase();
        this.data = data;
        this.date = ConcurrentSimpleDateFormat.format(new Date());
    }
}

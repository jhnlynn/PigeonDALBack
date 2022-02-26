package pigeon.backend.pigeondalback.utils;

import java.io.*;

public class JsonResult<E> implements Serializable {
    // Status Code
    private Integer state;
    // Status Message
    private String message;
    // Data
    private E data;

    public JsonResult() {
        super();
    }

    public JsonResult(Integer state) {
       super();
       this.state = state;
    }

    // Call when there's an error
    public JsonResult(Throwable e) {
       super();
       this.message = e.getMessage();
    }

    public JsonResult(Integer State, E data) {
       super();
       this.state = state;
       this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

}

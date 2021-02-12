package co.com.meli.quasarfire.dto;

public class Response {

    private String message;
    private Position position;

    public Response() {
        super();
    }

    public Response(String message, Position position) {
        this.message = message;
        this.position = position;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}

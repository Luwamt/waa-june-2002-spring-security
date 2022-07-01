package spring_security_lab6.exception.custome;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
//@NoArgsConstructor
public class ApiValidationError extends ApiSubError{

    private String object;
    private String field;
    @JsonProperty("rejected_value")
    private Object rejectedValue;
    private String message;

//    public ApiValidationError(HttpStatus status, Throwable ex, String object, String message) {
//        super(status, ex);
//        this.object = object;
//        this.message = message;
//    }

    ApiValidationError(String object, String message) {
        //this();
        this.object = object;
        this.message = message;
    }
}

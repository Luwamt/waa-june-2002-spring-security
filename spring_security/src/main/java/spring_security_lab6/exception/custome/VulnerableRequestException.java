package spring_security_lab6.exception.custome;

import lombok.Getter;

@Getter
public class VulnerableRequestException extends RuntimeException{

    public VulnerableRequestException(String message){
        super(message);
    }
}

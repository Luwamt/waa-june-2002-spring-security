package spring_security_lab6.aspect;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class UserOffensiveCount {

    private final Integer count;
    private final LocalDateTime lastRequest;
    private Integer DURATION_TO_WAIT = 15;

    public long timeToWait(){
        Duration duration = Duration.between(lastRequest,LocalDateTime.now());
        if(duration.toMinutes()<15){
            return DURATION_TO_WAIT-duration.toMinutes();
        }
        return 0;
    }
}

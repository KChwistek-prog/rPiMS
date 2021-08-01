package com.raspberrypi.fermzilla.rpims.pidomain;

import lombok.Data;
import org.springframework.stereotype.Controller;

@Data
@Controller
public class PiInfo {
    private int temperature;

    public int getTemperature() {
        return 25;
    }
}

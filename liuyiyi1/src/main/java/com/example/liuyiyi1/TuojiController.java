package com.example.liuyiyi1;

import com.example.liuyiyi1.util.ServoMotor;
import com.example.liuyiyi1.util.WebsocketClient;
import com.example.liuyiyi1.util.Wheel;
import com.pi4j.gpio.extension.pca.PCA9685GpioProvider;
import com.pi4j.gpio.extension.pca.PCA9685Pin;
import com.pi4j.io.gpio.*;
import com.pi4j.util.CommandArgumentParser;
import com.pi4j.wiringpi.SoftPwm;
import jnr.ffi.annotations.In;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.DecimalFormat;

@RestController
@RequestMapping("/Tuoji")
public class TuojiController {

    /*    @Resource(name = "userService")
        private WebsocketClient userService;*/
    @Resource(name = "servoMotor")
    private ServoMotor servoMotor;

    /* GpioController gpio = GpioFactory.getInstance();
    static GpioPinPwmOutput pwm;
    static int speed = 20;
    @RequestMapping("Tuoji")
    public void tuoji() throws InterruptedException {

        Pin pin = CommandArgumentParser.getPin(RaspiPin.class, RaspiPin.GPIO_23);
        pwm = gpio.provisionPwmOutputPin(pin);
        pwm.setPwmRange(100);

        if (speed <= 80) {
            speed += 20;
        }
        pwm.setPwm(speed);
    }*/

    @RequestMapping("Tuojiddd")
    public void ppp() throws InterruptedException {
        System.out.println("开始初始化引脚");
        GpioController gpio;
        Wheel left;
        gpio = GpioFactory.getInstance();
        //控制左侧的两个轮子
        left = new Wheel(gpio, RaspiPin.GPIO_22, RaspiPin.GPIO_24, RaspiPin.GPIO_23);
        left.forward();
        //控制右侧的两个轮子，不需要在输入pwm引脚，否则会报错，因为实例化了两个同一引脚的对象
        //right = new Wheel(gpio, RaspiPin.GPIO_24, RaspiPin.GPIO_25);
    }

    @RequestMapping("Tuoji")
    public void Tuoji(String poi) throws InterruptedException {

        String[] split = poi.split(",");
        String pois = split[0];
        int poiVal = Integer.parseInt(split[1]);
        poiVal = Integer.parseInt(new java.text.DecimalFormat("0").format(poiVal * 11.11 + 550));
        if(poiVal<550){
            poiVal = 550;
        }
        if(poiVal>2550){
            poiVal = 2550;
        }
        System.out.println("引脚为：" + pois);
        System.out.println("旋转角度为：" + split[1]);
        servoMotor.gpioSetPwm(pois, poiVal);


    }


}

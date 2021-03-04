package com.example.liuyiyi1.util;

import com.pi4j.gpio.extension.pca.PCA9685GpioProvider;
import com.pi4j.gpio.extension.pca.PCA9685Pin;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * 舵机控制基类，主要初始化一些参数
 * @author huyong
 *
 */
@Service("servoMotor")
public class ServoMotor {
	static PCA9685GpioProvider gpioProvider;
	GpioController gpio = null;
	public ServoMotor() {
		if (gpio == null) {
			gpio = GpioFactory.getInstance();
		}
		BigDecimal frequency = new BigDecimal("48.828");
		BigDecimal frequencyCorrectionFactor = new BigDecimal("1.0578");
		I2CBus bus;
		try {
			bus = I2CFactory.getInstance(I2CBus.BUS_1);
			gpioProvider = new PCA9685GpioProvider(bus, 0x40, frequency,
					frequencyCorrectionFactor);
			gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_00, "Pulse 00");
			gpioProvider.setAlwaysOff(PCA9685Pin.PWM_00);
			gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_01, "Pulse 01");
			gpioProvider.setAlwaysOff(PCA9685Pin.PWM_01);
			gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_02, "Pulse 02");
			gpioProvider.setAlwaysOff(PCA9685Pin.PWM_02);
			gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_03, "Pulse 03");
			gpioProvider.setAlwaysOff(PCA9685Pin.PWM_03);
			gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_04, "Pulse 04");
			gpioProvider.setAlwaysOff(PCA9685Pin.PWM_04);
			gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_05, "Pulse 05");
			gpioProvider.setAlwaysOff(PCA9685Pin.PWM_05);
			gpioProvider.setPwm(PCA9685Pin.PWM_00, 1550);
			gpioProvider.setPwm(PCA9685Pin.PWM_02, 1550);
			gpioProvider.setPwm(PCA9685Pin.PWM_03, 1550);
			gpioProvider.setPwm(PCA9685Pin.PWM_04, 1550);
			gpioProvider.setPwm(PCA9685Pin.PWM_05, 1550);

		} catch (UnsupportedBusNumberException | IOException e) {
			e.printStackTrace();
		}
	}
	public GpioController getGpioController(){
		return gpio;
	}

	public void gpioSetPwm(String pin, int duration){
		switch(pin){
			case "00" :
				gpioProvider.setPwm(PCA9685Pin.PWM_00, duration);
				break;
			case "01" :
				gpioProvider.setPwm(PCA9685Pin.PWM_01, duration);
				break;
			case "02" :
				gpioProvider.setPwm(PCA9685Pin.PWM_02, duration);
				break;
			case "03" :
				gpioProvider.setPwm(PCA9685Pin.PWM_03, duration);
				break;
			case "04" :
				gpioProvider.setPwm(PCA9685Pin.PWM_04, duration);
				break;
			case "05" :
				gpioProvider.setPwm(PCA9685Pin.PWM_05, duration);
				break;

			default :
				System.out.println("还没有开发此引脚");

		}
	}

}

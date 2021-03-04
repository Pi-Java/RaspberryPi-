package com.example.liuyiyi1;

import com.pi4j.io.gpio.*;

public class LEDBlink {
    //获取全局Gpio 引脚控制器对象
    public static final GpioController gpio = GpioFactory.getInstance();

    public static void main(String [] rags) throws InterruptedException
    {

        //定义编号为0的引脚为数字输出引脚，初始化为低电平
        GpioPinDigitalOutput Led1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "" , PinState.LOW);
        GpioPinDigitalOutput Led2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "" , PinState.LOW);
        GpioPinDigitalOutput Led3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "" , PinState.LOW);

        while(true)
        {

            Led1.high();
            Led2.low();
            Led3.low();
            Thread.sleep(1000);
            Led1.low();
            Led2.high();
            Led3.low();
            Thread.sleep(1000);
            Led1.low();
            Led2.low();
            Led3.high();
            Thread.sleep(1000);

        }

    }
}

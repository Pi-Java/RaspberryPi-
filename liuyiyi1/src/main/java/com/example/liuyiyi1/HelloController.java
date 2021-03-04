/*
package com.example.liuyiyi1;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.trigger.GpioSyncStateTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.io.IOException;

@RestController
@RequestMapping("/hello")
public class HelloController {
    public boolean tt  = true;
    public boolean pp  = true;

    public static final GpioController gpio = GpioFactory.getInstance();
    GpioPinDigitalOutput Led1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "" , PinState.LOW);
    GpioPinDigitalOutput Led2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "" , PinState.LOW);
    GpioPinDigitalOutput Led3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "" , PinState.LOW);
    GpioPinDigitalOutput Led25 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, "" , PinState.LOW);
    GpioPinDigitalOutput Led27 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "" , PinState.LOW);
    GpioPinDigitalOutput Led28 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "" , PinState.LOW);
    GpioPinDigitalOutput Led29 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "" , PinState.LOW);
    @RequestMapping("hello")
    public void hello() throws InterruptedException {
        //定义编号为0的引脚为数字输出引脚，初始化为低电平
        System.out.printf("开始初始化引脚");
        while(true)
        {
            System.out.printf("开始一轮");
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
            System.out.printf("一轮结束");
        }

        //获取全局Gpio 引脚控制器对象

        */
/*final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
        pin.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);  // 程序关闭时设置端口的状态
        pin.setMode(PinMode.DIGITAL_OUTPUT);
        pin.setState(PinState.HIGH); //设置为高电平。

        pin.low();
        pin.high();
        pin.toggle();//切换状态
        pin.pulse(1000);  //脉冲法将pin设置为高 时间1秒
        pin.pulse(1000,true); //打开端口1秒，然后关闭


        //读取状态
        PinState state = pin.getState();
        boolean ishigh=pin.isHigh();



        //GPIO_01设置为输出，并设置为高电平。
        final GpioPinDigitalOutput pin01 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, PinState.HIGH);


//监听引脚变化
        final GpioPinDigitalInput pin2 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_01);
        pin.addListener(new GpioPinListenerDigital(){
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event){
                PinState state = event.getState();
                int value = state.getValue();
                if(value==1){
                    System.out.printf("prepare connect to mobile"); //生成二维码
                    try {
                        //device.startBind();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        *//*
*/
/*
        设置同步触发器
        GpioPinDigitalOutput led;
        button.addTrigger(new GpioSyncStateTrigger(led));*//*
*/
/*
        //关闭触发器
        //gpio.shutdown();
*//*


    }
    @RequestMapping("ppp")
    public void ppp() throws InterruptedException {


        while (true){
            Led25.high();
            Led27.low();
            Led28.low();
            Led29.low();
            Thread.sleep(2);
            Led25.low();
            Led27.high();
            Led28.low();
            Led29.low();
            Thread.sleep(2);
            Led25.low();
            Led27.low();
            Led28.high();
            Led29.low();
            Thread.sleep(2);
            Led25.low();
            Led27.low();
            Led28.low();
            Led29.high();
            Thread.sleep(2);

        }
    }

    @RequestMapping("/TEDOpen")
    public void TEDOpen() throws InterruptedException {
        System.out.print("LED开");
        tt  = true;
        while(tt)
        {
            System.out.print("开始一轮");
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
            System.out.print("一轮结束");
        }


    }
    @RequestMapping("/TEDCL")
    public void TEDCL() throws InterruptedException {
        tt  = false;
        System.out.print("收到了关闭LED");
        Led1.low();
        Led2.low();
        Led3.low();
    }
    @RequestMapping("/djOPen")
    public void djOPen() throws InterruptedException {
        System.out.print("打开电机");
        pp = true;
        while (pp){
            Led25.high();
            Led27.low();
            Led28.low();
            Led29.low();
            Thread.sleep(2);
            Led25.low();
            Led27.high();
            Led28.low();
            Led29.low();
            Thread.sleep(2);
            Led25.low();
            Led27.low();
            Led28.high();
            Led29.low();
            Thread.sleep(2);
            Led25.low();
            Led27.low();
            Led28.low();
            Led29.high();
            Thread.sleep(2);

        }
    }
    @RequestMapping("/djCl")
    public void djCl() throws InterruptedException {
        System.out.print("关闭电机");
        pp = false;
        Led25.low();
        Led27.low();
        Led28.low();
        Led29.low();
    }



}
*/

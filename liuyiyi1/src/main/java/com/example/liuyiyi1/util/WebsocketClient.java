package com.example.liuyiyi1.util;

import org.springframework.stereotype.Service;

import java.lang.System;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.net.UnknownHostException;

@Service("userService")
public class WebsocketClient {

    Socket socket;

    {
        try {
            socket = new Socket(InetAddress.getLocalHost().getHostName(), 12345);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String WebsocketClient (String args) {
        //System.out.println("Hello World!");
        // TODO Auto-generated method stub

        try {
            InetAddress addr = InetAddress.getLocalHost();
            String host = addr.getHostName();
            //String ip=addr.getHostAddress().toString(); //获取本机ip
            //log.info("调用远程接口:host=>"+ip+",port=>"+12345);

            // 初始化套接字，设置访问服务的主机和进程端口号，HOST是访问python进程的主机名称，可以是IP地址或者域名，PORT是python进程绑定的端口号
            Socket socket = new Socket(host, 12345);

            // 获取输出流对象
            OutputStream os = socket.getOutputStream();
            PrintStream out = new PrintStream(os);
            // 发送内容
            out.print(args);
            // 告诉服务进程，内容发送完毕，可以开始处理
            out.print("over");

            // 获取服务进程的输入流
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
            String tmp = null;
            StringBuilder sb = new StringBuilder();
            // 读取内容
            while ((tmp = br.readLine()) != null)
                sb.append(tmp).append('\n');
            System.out.print(sb);
            // 解析结果
            //JSONArray res = JSON.parseArray(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            System.out.print("远程接口调用结束.");
        }
        return "";
    }

}

package com.example.liuyiyi1.util;

import org.python.util.PythonInterpreter;

public class JavaRunPython {
    public static void main(String[] args) {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("a='hello world'; ");
        interpreter.exec("print a;");
    }
}

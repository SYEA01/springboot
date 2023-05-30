package com.example.springboot;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskApp {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask tsak = new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer task run...");
            }
        };
        timer.schedule(tsak,0,2000);
    }
}

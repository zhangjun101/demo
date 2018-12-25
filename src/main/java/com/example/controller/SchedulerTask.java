package com.example.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
	
	private int count=0;

//	@Scheduled(fixedDelay = 10000)
//    private void process1(){
//        System.out.println("this is scheduler task runing1  "+(count++));
//    }
//	
//	@Scheduled(fixedDelay = 10000)
//    private void process2(){
//        System.out.println("this is scheduler task runing2  "+(count++));
//    }
}

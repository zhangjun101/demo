package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping("/mail")
    public String sendSimpleMail() {
    	//建立邮件消息
		SimpleMailMessage mainMessage = new SimpleMailMessage();
		//发送者
		mainMessage.setFrom("15828411534@163.com");
		//接收者
		mainMessage.setTo("892601712@qq.com");
		//发送的标题
		mainMessage.setSubject("嗨喽");
		//发送的内容
		mainMessage.setText("邮箱发送测试");
		mailSender.send(mainMessage);
		return "邮箱发送";
    }
}

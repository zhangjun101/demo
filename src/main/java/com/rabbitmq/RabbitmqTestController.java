package com.rabbitmq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.time.LocalDateTime;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/rabbitmq")
@Api(value="RabbitmqTestController|rabbitmq测试控制器")
public class RabbitmqTestController {

    @Autowired
    private RabbitMqSender sender;
    

    /**
     * rabbitmq测试生产者接口
     * @param message
     */
    @GetMapping("/sendTest")
    @ResponseBody
    @ApiOperation(value="rabbitmq发送测试接口 ",httpMethod ="GET",notes = "rabbitmq发送接口发布说明")
	@ApiImplicitParams({
	@ApiImplicitParam(paramType="query", name = "message", value = "message", required = false, dataType = "string"),
	@ApiImplicitParam(paramType="query", name = "rootkey", value = "rootkey", required = false, dataType = "string"),
	@ApiImplicitParam(paramType="query", name = "change", value = "change", required = false, dataType = "string")

	})
    public String send(String change,String rootkey,String message) {
		sender.sendRabbitmq(change,rootkey,message);
		return "success";
    }

}

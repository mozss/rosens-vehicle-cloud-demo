package controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alerts")
public class AlertController {
	
	// 接收车辆异常报警（模拟熔断场景）
	@PostMapping("/emergency")
	public String handleEmergency(@RequestBody String message) {
		// 随机抛出异常测试熔断
		if (Math.random() > 0.5) {
			throw new RuntimeException("服务繁忙，请重试！");
		}
		return "处理报警成功：" + message;
	}
}

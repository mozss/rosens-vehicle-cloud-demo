package controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	
	@Value("${speed.limit:120}")  // 读取动态配置
	private int speedLimit;
	
	// 上报车辆状态（车联网核心接口）
	@PostMapping("/{id}/status")
	public String updateStatus(@PathVariable String id, @RequestBody String status) {
		return "Vehicle " + id + " status updated: " + status;
	}
	
	// 校验车速是否超限
	@GetMapping("/{id}/speed-check")
	public String checkSpeed(@PathVariable String id, @RequestParam int speed) {
		return speed > speedLimit ? "超速警告！当前车速：" + speed : "车速正常";
	}
}

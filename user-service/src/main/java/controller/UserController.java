package controller;



import com.example.userservice.client.VehicleServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private VehicleServiceClient vehicleServiceClient;
	
	// 查询车辆状态（车联网场景）
	@GetMapping("/{userId}/vehicle-speed")
	public String getVehicleSpeed(@PathVariable String userId, @RequestParam int speed) {
		return vehicleServiceClient.checkSpeed(userId, speed);
	}
}

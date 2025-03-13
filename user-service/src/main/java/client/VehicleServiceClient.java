package client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vehicle-service")
public interface VehicleServiceClient {
	@GetMapping("/vehicles/{id}/speed-check")
	String checkSpeed(@PathVariable String id, @RequestParam int speed);
}

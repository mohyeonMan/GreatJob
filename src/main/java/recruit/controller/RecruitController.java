package recruit.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import recruit.service.RecruitService;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "recruit")
public class RecruitController {
	private Map<String, RecruitService> recruitService;

}

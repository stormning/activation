package com.slyak.activation.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slyak.activation.ex.ActivationException;
import com.slyak.activation.model.ActivationRequest;
import com.slyak.activation.service.ActivationService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ActivationService activationService;
	
	@RequestMapping
	public String index() {
		return "admin.index";
	}
	
	@RequestMapping("/record")
	public String record(@PageableDefaults(sort="id",sortDir=Direction.DESC) Pageable pageable,ModelMap modelMap) {
		modelMap.put("page", activationService.findAll(pageable));
		return "alone:admin.record";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/requestActivation")
	@ResponseBody
	public Map<String, String> requestActivation(ActivationRequest request) {
		Map<String,String> result = new HashMap<String, String>();
		try {
			String verifyCode = activationService.activate(request);
			result.put("success", "1");
			result.put("verifyCode", verifyCode);
		} catch (ActivationException e) {
			result.put("success", "0");
			result.put("errorCode", String.valueOf(e.getCode()));
		}
		return result;
	}

}

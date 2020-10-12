package teleapi.controller;




import teleapi.Exception.TeleAPIExceptionHandler;
import teleapi.bean.ErrorObject;
import teleapi.service.IProductService;
import teleapi.util.ProductUtil;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;


@RestController
public class MyController
{

	@Autowired
	private IProductService productService;


	@GetMapping("/product")
	@ResponseBody
	public ResponseEntity listProducts(@RequestParam Map<String, String> searchParams)
	{

		try
		{
			return ResponseEntity.ok(productService.findAll(searchParams));
		}
		catch (Exception e)
		{
			throw new TeleAPIExceptionHandler(e.getMessage());
			/*return new ResponseEntity<Object>(ProductUtil.generateErrorObject(e), HttpStatus.INTERNAL_SERVER_ERROR);*/
			/*return new ResponseEntity<>(
					e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);*/
			//return new Response<ErrorObject>(ProductUtil.generateErrorObject(e), HttpStatus.INTERNAL_SERVER_ERROR);
			//return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

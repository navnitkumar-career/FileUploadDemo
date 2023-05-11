package com.file.controller;


import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.payload.FileResponce;
import com.file.servies.FileServies;

@RestController
@RequestMapping("/file")
public class Controller{
	
	@Autowired
	private FileServies fileServies;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/uploade")
	public  ResponseEntity<FileResponce > uploadfile(@RequestParam ("image") MultipartFile image ) throws IOException {
	 String uploadImage = this.fileServies.uploadImage(path, image);

	 return new ResponseEntity<>(new FileResponce(uploadImage,"Image  is successfully uploaded !!"),HttpStatus.OK);
	
	}
	
	@RequestMapping(value =  "/images/{imageName}",produces = "MediaType.IMAGE_JPEG_VALUE", method = RequestMethod.GET)
	public void downloadImage(@PathVariable ("imageName")  String imageName ,HttpServletResponse httpServletResponse )throws IOException {
		 InputStream resource = this.fileServies.getResource(path, imageName);
		 httpServletResponse.setContentType(MediaType.IMAGE_JPEG_VALUE);
		 StreamUtils.copy(resource, httpServletResponse.getOutputStream()) ;
	}
	 

}

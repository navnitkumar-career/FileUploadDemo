package com.file.Impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file.servies.FileServies;

@Service

public class FileserviesImpl implements FileServies {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		
		//file name
		String name=file.getOriginalFilename();
		
		//full parth
		String filePath=path + File.separator+name;
		
		//create folder if not created
		File f=new File(path);
		if (!f.exists()) {
			f.mkdir();
		}
		
		//file copy
		Files.copy(file.getInputStream(),Paths.get(filePath));
		
		return name;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullpath=path+File.separator+fileName;
		InputStream is=new FileInputStream(fullpath);
		return is;
	}

}

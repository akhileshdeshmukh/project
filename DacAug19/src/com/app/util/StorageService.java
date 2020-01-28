package com.app.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class StorageService {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	String uploadpath = "/home/akash/Akash/MyWork/MyProjects/pizza-springBoot/pizza/src/main/webapp/images";

	public final Path rootLocation = Paths.get(uploadpath);

	public void store(MultipartFile file) {
		System.out.println("Root Location : " + rootLocation);
		try {

			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("FAIL!" + e);
		}
	}

}

package com.app.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.util.GetNetworkAddress;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/test")
public class TestController 
{
	
	/*
	 * @Autowired private GetNetworkAddress ip;
	 * 
	 * public TestController() { System.out.println("inside controller"); }
	 * 
	 * @GetMapping public ResponseEntity<?> getIp() { try {
	 * System.out.println("Ip: " + GetNetworkAddress.GetAddress("ip"));
	 * System.out.println("Mac: " + GetNetworkAddress.GetAddress("mac")); //String
	 * ip1= ip.GetAddress("ip"); String ip=GetNetworkAddress.GetAddress("ip");
	 * String mac=GetNetworkAddress.GetAddress("mac");
	 * 
	 * return new ResponseEntity<String>(mac, OK); } catch (Exception e) {
	 * e.printStackTrace(); return new ResponseEntity<Exception>(e, NOT_FOUND); } }
	 */
}



//http://localhost:8080/DacAug19/test


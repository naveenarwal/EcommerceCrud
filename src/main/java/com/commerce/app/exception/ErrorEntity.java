package com.commerce.app.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorEntity {

	private String message;
	
	private String code;
	
	private String date;
	
	private String status;
}

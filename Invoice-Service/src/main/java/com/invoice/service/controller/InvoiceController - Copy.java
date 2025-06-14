package com.invoice.service.controller;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.service.dto.InvoiceRequest;
import com.invoice.service.exception.CustomException;

@RestController
public class InvoiceController {

	@PostMapping("/invoice")
	public ResponseEntity<String> sendResponse(@RequestBody InvoiceRequest invoiceNumber) {

		if (invoiceNumber != null && invoiceNumber.invoiceNumber().matches("^[0-9]+$")) {
			int invoice = generateRandom(invoiceNumber.invoiceNumber());
			return ResponseEntity.ok("Invoice Number Generated - " + invoice);
		} else {
			throw new CustomException("Invoice number must contain only digits.");
		}

	}

	private int generateRandom(String invoiceNumber) {

		Random random = new Random();

		return random.nextInt(1000);

	}

}

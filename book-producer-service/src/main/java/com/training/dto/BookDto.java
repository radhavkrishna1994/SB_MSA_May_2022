package com.training.dto;

import com.training.model.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {

	private Long isbn;
	private String title;
	private Double price;
	private Long stock;
}

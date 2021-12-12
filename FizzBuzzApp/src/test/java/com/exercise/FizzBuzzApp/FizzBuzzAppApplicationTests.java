package com.exercise.FizzBuzzApp;

import com.exercise.FizzBuzzApp.model.FizzBuzzModel;
import com.exercise.FizzBuzzApp.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FizzBuzzAppApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FizzBuzzService fizzBuzzService;

	@Test
	public void shouldReturnStatusOk() throws Exception {
		List<String> result = new ArrayList<>();
		result.add("Buzz");
		String json = "[\"5\"]";
		when(fizzBuzzService.getFizzBuzzByNumber("5")).thenReturn(new FizzBuzzModel("5",result));
		this.mockMvc.perform(post("/api/fizzBuzz").contentType(
				MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnResultBuzz() throws Exception {
		List<String> result = new ArrayList<>();
		result.add("Buzz");
		String json = "[\"5\"]";
		when(fizzBuzzService.getFizzBuzzByNumber("5")).thenReturn(new FizzBuzzModel("5",result));
		this.mockMvc.perform(post("/api/fizzBuzz").contentType(
				MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk())
		.andExpect(content().json("[{\"input\":\"5\",\"result\":[\"Buzz\"]}]"));
	}

	@Test
	public void shouldReturnResultFizz() throws Exception {
		List<String> result = new ArrayList<>();
		result.add("Fizz");
		String json = "[\"9\"]";
		when(fizzBuzzService.getFizzBuzzByNumber("9")).thenReturn(new FizzBuzzModel("9",result));
		this.mockMvc.perform(post("/api/fizzBuzz").contentType(
						MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk())
				.andExpect(content().json("[{\"input\":\"9\",\"result\":[\"Fizz\"]}]"));
	}

	@Test
	public void shouldReturnResultFizzBuzz() throws Exception {
		List<String> result = new ArrayList<>();
		result.add("FizzBuzz");
		String json = "[\"45\"]";
		when(fizzBuzzService.getFizzBuzzByNumber("45")).thenReturn(new FizzBuzzModel("45",result));
		this.mockMvc.perform(post("/api/fizzBuzz").contentType(
						MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk())
				.andExpect(content().json("[{\"input\":\"45\",\"result\":[\"FizzBuzz\"]}]"));
	}

}

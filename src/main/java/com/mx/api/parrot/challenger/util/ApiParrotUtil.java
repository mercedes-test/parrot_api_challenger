package com.mx.api.parrot.challenger.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ApiParrotUtil {

	private ApiParrotUtil() {
	}

	public static HttpEntity headers() {
		final HttpHeaders headers = getHttpHeaders();
		return new HttpEntity<>(headers);
	}

	public static HttpHeaders getHttpHeaders() {
		final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	public static String buildUrl(String title, String url) {
		return UriComponentsBuilder.fromHttpUrl(url).queryParam("q", title).toUriString();
	}


	public static Date formatDate(String inDate) {
		DateTimeFormatter formatterRequest = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatterQuery = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateStr = LocalDate.parse(inDate, formatterRequest).format(formatterQuery);
		Date dateQuery= null;
		try {
			dateQuery = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateQuery;
	}
}

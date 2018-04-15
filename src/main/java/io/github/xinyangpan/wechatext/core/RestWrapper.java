package io.github.xinyangpan.wechatext.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestWrapper {
	private static final Logger log = LoggerFactory.getLogger(RestWrapper.class);

	private RestTemplate restTemplate;
	private ObjectMapper objectMapper;

	public <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) {
		String responseString = restTemplate.getForObject(url, String.class, uriVariables);
		log.info("responseString is {}", responseString);
		try {
			return objectMapper.readValue(responseString, responseType);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

}

package cnes.reader.rest.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author ygor.satiro
 * Client para recuperar CNES CSV via URL configurável (HTTP GET)
 */
@Service
public class RestCnesClient {	
	
	private static final Logger LOGGER = Logger.getLogger(RestCnesClient.class.getName());
	
	@Value("${url.cnes.info.csv}")
	private String url;
	
	public byte[] downloadCSV() throws Exception {

		HttpClientBuilder clientBuilder = HttpClients.custom();
		HttpClient httpClient = clientBuilder.build();

		try {
			HttpGet get = new HttpGet(url);			
			HttpResponse response = httpClient.execute(get);
			if(verificaStatusNok(response)) {
				throw new Exception("Error while retrieving CNES information");
			}
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();            
			response.getEntity().writeTo(baos);
			
			return baos.toByteArray();
		} catch (IOException e) {
			LOGGER.error("Error while retrieving/reading CNES information", e);
			throw e;
		}
	}
	private boolean verificaStatusNok(HttpResponse response) {		
		return response.getStatusLine().getStatusCode() != 200 ? Boolean.TRUE : Boolean.FALSE;
	}
}

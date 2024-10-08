package id.co.ogya.rest.simple.response;

import lombok.Data;

@Data
public class SimpleRestResponse<T extends BaseOutputSchema> extends BaseResponse{
	private T outputSchema;

	public SimpleRestResponse() {
	}
	
	public SimpleRestResponse(BaseResponse baseResponse, T outputSchema) {
		this.setResponse(baseResponse);
		this.outputSchema = outputSchema;
	}

	public SimpleRestResponse(BaseResponse baseResponse, T outputSchema,
			Integer httpStatusCode) {
		this.setResponse(baseResponse);
		this.outputSchema = outputSchema;
		this.httpStatusCode = httpStatusCode;
	}
}

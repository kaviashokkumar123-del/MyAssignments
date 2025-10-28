package week3.day2;

public class APIClient {
	public void sendRequest(String endpoint) {
		System.out.println("The sendRequest with the endpoint as :" + endpoint);
	}

	public void sendRequest(String endpoint, String requestBody, boolean requestStatus) {
		System.out.println("The sendRequest with the endpoint as :" + endpoint + " and request body as " + requestBody
				+ " with the status as " + true);
	}

	public static void main(String[] args) {
		APIClient ap = new APIClient();
		ap.sendRequest("EndPointRequestValue");
		ap.sendRequest("EndPointRequestValue", "RequestBodyValue", true);

	}

}

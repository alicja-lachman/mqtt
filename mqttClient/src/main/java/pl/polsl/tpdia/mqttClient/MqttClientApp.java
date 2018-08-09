package pl.polsl.tpdia.mqttClient;

import org.eclipse.paho.client.mqttv3.MqttClient;

/**
 * Hello world!
 *
 */
public class MqttClientApp {
	public static void main(String[] args) {
		System.out.println("Hello World client!");
		try {
			MqttClient client = new MqttClient("tcp://test.mosquitto.org:1883", MqttClient.generateClientId());
			client.setCallback(new SimpleMqttCallback());
			client.connect();
			client.subscribe("tpdia_test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

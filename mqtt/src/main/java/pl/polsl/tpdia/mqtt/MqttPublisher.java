package pl.polsl.tpdia.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;


public class MqttPublisher {
	public static void main(String[] args) {
		System.out.println("Hello World publisher!");
		MqttClient client;
		try {
			client = new MqttClient("tcp://test.mosquitto.org:1883", MqttClient.generateClientId());
			client.connect();

			while (true) {
				MqttMessage message = new MqttMessage();
				message.setPayload("Hello world from Java".getBytes());
				System.out.println("Publishing message!");
				client.publish("tpdia_test", message);
				Thread.sleep(1000);
			}
//			client.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

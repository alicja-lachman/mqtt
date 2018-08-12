package pl.polsl.tpdia.mqtt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

public class MqttPublisher {
	public static void main(String[] args) {
		System.out.println("Hello World publisher!");
		MqttClient client;
		try {
			client = new MqttClient("tcp://test.mosquitto.org:1883", MqttClient.generateClientId());
			client.connect();
			Random generator = new Random();
			while (true) {

				MqttMessage message = new MqttMessage();
				JSONObject object = new JSONObject();
				Date date = new Date();
				SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				object.put("date", sfd.format(date));
				object.put("value", generator.nextDouble() * 100);
				message.setPayload(object.toString().getBytes());
				System.out.println("Publishing message!");
				client.publish("tpdia_test", message);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

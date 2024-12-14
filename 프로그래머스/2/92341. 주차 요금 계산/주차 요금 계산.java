import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] fees, String[] records) {
		Map<String, Car> parkingInfo = new HashMap<>();

		for (String record : records) {
			String[] recordInfo = record.split(" ");
			String time = recordInfo[0];
			String carId = recordInfo[1];
			String action = recordInfo[2];

			if (!parkingInfo.containsKey(carId)) {
				parkingInfo.put(carId, new Car(carId));
			}

			Car car = parkingInfo.get(carId);
			if (action.equals("IN")) {
				car.in(time);
			} else {
				car.out(time);
			}
		}

		Parking parking = new Parking(fees);

		return parkingInfo.keySet().stream().sorted().mapToInt(carId -> {
			Car car = parkingInfo.get(carId);
			if (car.isParking) {
				car.out(parking.CLOSING_TIME);
			}
			return parking.calculateFee(car.parkingMinute);
		}).toArray();
	}
}


class Car {
	public String id;
	public int parkingMinute;
	public boolean isParking;
	private int parkingStartMinute;

	Car(String id) {
		this.id = id;
	}

	public void in(String time) {
		parkingStartMinute = timeToMinute(time);
		isParking = true;
	}

	public void out(String time) {
		parkingMinute += timeToMinute(time) - parkingStartMinute;
		isParking = false;
	}

	private int timeToMinute(String timeStr) {
		String[] time = timeStr.split(":");
		return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
	}
}

class Parking {
	final String CLOSING_TIME = "23:59";

	private final int defaultMinute;
	private final int defaultFee;
	private final int unitMinute;
	private final int unitFee;

	Parking(int[] fees) {
		defaultMinute = fees[0];
		defaultFee = fees[1];
		unitMinute = fees[2];
		unitFee = fees[3];
	}

	public int calculateFee(int parkingMinute) {
		int overParkingMinute = parkingMinute - defaultMinute;
		if (overParkingMinute <= 0) return defaultFee;
		return defaultFee + calculateOverFee(overParkingMinute);
	}

	private int calculateOverFee(int overParkingMinute) {
		int overFee = (overParkingMinute / unitMinute) * unitFee;
		if (overParkingMinute % unitMinute != 0) {
			overFee += this.unitFee;
		}
		return overFee;
	}
}

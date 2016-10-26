package amazon;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map.Entry;

public class AmazonCarMaxRental {

	public static void main(String[] args) {
		
		CarRental<String> carRental1 = new CarRental<String>("car1", 1, 5);
		CarRental<String> carRental2 = new CarRental<String>("car2", 5, 6);
		CarRental<String> carRental3 = new CarRental<String>("car3", 6, 9);
		CarRental<String> carRental4 = new CarRental<String>("car4", 4, 5);
		
		ArrayList<CarRental<String>> list = new ArrayList<>();
		list.add(carRental1);
		list.add(carRental2);
		list.add(carRental3);
		list.add(carRental4);
		
		process( list);
		
	}
	
	private static void process(ArrayList<CarRental<String>> list){
		
		TreeMap<Integer, Integer> mapTotal = new TreeMap<>();
		
		for (CarRental<String> carRental: list){
			
			int index = carRental.start;
			
			while(index<=carRental.fin){
				
				if (mapTotal.containsKey(index)  )
					mapTotal.put(index, mapTotal.get(index)+1);
				else	
					mapTotal.put(index, 1);
				
				index++;
			}
			
		}
			
		Entry<Integer, Integer> entryMax= mapTotal.firstEntry();
		
		for (Entry<Integer, Integer> entryMap: mapTotal.entrySet()){
			
			int value=entryMap.getValue();
			int keyFirst =  entryMax.getValue();
			
			if (value > keyFirst)
				entryMax = entryMap;
			
		}
		
		 System.out.println(entryMax);
		
	}
	
	static class CarRental <T>{
		
		T car;
		int start;
		int fin;
		
		public CarRental (T car, int start, int fin){
			this.car = car;
			this.start = start;
			this.fin = fin;
		}
		
		public int getDistance(){
			return fin-start;
		}
		
	}

}

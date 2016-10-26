package amazon;

public class AmazonMostSolidPrice {
	
	Data [] bucketsData = new Data[10];
	int number = 1;

	public static void main(String[] args) {
		
		AmazonMostSolidPrice amazonMostSolidPrice = new AmazonMostSolidPrice();
		
		amazonMostSolidPrice.addData(10.01d, 100);
		amazonMostSolidPrice.addData(11.01d, 200);
		amazonMostSolidPrice.addData(10.01d, 210);
		
		amazonMostSolidPrice.dump();

	}
	
	void dump() {
     System.out.println();
     for (int i = 0; i < number; i++) {
        System.out.print(i + ":");
        Data list = bucketsData[i];
        while (list != null) {
           System.out.print("  (" + list.price + "," + list.quantity + ")");
           list = list.next;
        }
        System.out.println();
     }
  }
	
	
	public class Data {
		
		double price;
		int quantity;
		Data next = null;
		
		Data(double priceRec, int qty){
			price = priceRec;
			quantity = qty;			
		}
		
		public boolean equals(Object object){
			
			if (object instanceof Data){
				
				return price == ( ((Data) object).price);
				
			}
			
			return false;		
			
		}
		
	}
	
	private  void addData(double priceRec, int qty){
		
		Data newData = new Data(priceRec, qty);
		int indexData = 0;
		Data data = bucketsData[indexData];
		
		if (data!=null){
			
			while (data !=null ){
				
				if(newData.equals(data)){
					
					newData.quantity = newData.quantity + data.quantity;					
					data.quantity = newData.quantity;					
					return;
				}
					
				else
					data = data.next;
			}
			
			newData.next= bucketsData[indexData] ;
			bucketsData[indexData] = newData;
			
		}else{
			
			bucketsData[indexData] = newData;
			
		}
		
	}

}

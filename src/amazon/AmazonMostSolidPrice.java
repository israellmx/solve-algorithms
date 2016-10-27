package amazon;


/**
 Amazon Interview Question for Software Engineers
 At regular interval, we are receiving data (Price,Quantity). 
 We need to find Most Sold Price(MSP). 
 Need to design the solution to print the current MSP
  with total Qty of that price, every time a set of price
   and its quantity sold is provided as input.


Time       Price   Qty    MSP(Total Qty)
11:01AM   $10.01   100     $10.01(100)
11:03AM   $11.01   200     $11.01(200)
11:04AM   $12.81   150     $11.01(200)
11:06AM   $10.01   210     $10.01(310)
11:07AM   $10.01   180     $10.01(490)
11:08AM   $12.81   400     $12.81(550)
11:09AM   $11.01   200     $12.81(550)
  *
  */
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

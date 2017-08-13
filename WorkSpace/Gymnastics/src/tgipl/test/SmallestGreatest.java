package tgipl.test;

public class SmallestGreatest {
	
	public static void main(String[] args) {
		int number=72111;
		System.out.println(smallest_number(number));
	}
	
	public static int smallest_number(int number)
    {
        final int MAX_INT=1000000000;
        int[] sumAndCount = getSumAndCount(number);
        int[] productAndCount = getProductAndCount(number);
        int i=-1;
        for(i=number+1;i<MAX_INT;i++)
        {
        	int[] newSumAndCount = getSumAndCount(i);
        	
        	if(newSumAndCount[0]==sumAndCount[0] && newSumAndCount[1]<=sumAndCount[1])
        	{
        		int[] newProductAndCount = getProductAndCount(i);
        		{
        			if(newProductAndCount[0]==productAndCount[0] && newProductAndCount[1]<=productAndCount[1])
        			{
        				return i;
        			}
        		}
        	}
        }
        
        return i;
    }

	private static int[] getProductAndCount(int number) {
		int product=0;
		int count=1;
		int[] product_count=new int[2];
		product=getProductOfDigits(number);
		while(product/10>=1)
		{
			product=getProductOfDigits(product);
			count++;
		}
		product_count[0]=product;
		product_count[1]=count;
		return product_count;
	}

	private static int[] getSumAndCount(int number) {
		int sum=0;
		int count=1;
		int[] sum_count=new int[2];
		sum=getSumOfDigits(number);
		while(sum/10>=1)
		{
			sum=getSumOfDigits(sum);
			count++;
		}
		sum_count[0]=sum;
		sum_count[1]=count;
		return sum_count;
	}

	private static int getSumOfDigits(int number) {
		int sum=0;
		while(number>0)
		{
			sum=sum+(number%10);
			number=number/10;
		}
			
		return sum;
	}
	
	private static int getProductOfDigits(int number) {
		int product=1;
		while(number>0)
		{
			product=product*(number%10);
			number=number/10;
		}
			
		return product;
	}

}

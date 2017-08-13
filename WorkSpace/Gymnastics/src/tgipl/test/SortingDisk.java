package tgipl.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SortingDisk {
	
	public static void main(String[] args) {
		int[] order = {5,2,1,3,4}; //4,1,0,2,3
		System.out.println(get_order(order));
	}

	public static int get_order(int[] order)
    {
		transformInputToMatchIndexes(order);
		
		List<Integer> dList = new ArrayList<Integer>();
		List<Integer> backedList = new ArrayList<Integer>(); 
		for(int a : order)
		{
			backedList.add(a);
		}
		System.out.println(backedList);
		
		for(int a : order)
		{
			dList.add(a);
		}
		Collections.sort(dList);
		Collections.reverse(dList);
		System.out.println(dList);
		int count_steps=0;
		while(dList.size()>1)
		{
			int max=dList.get(0);
			int nextMax = dList.get(1);
			int indexOfMax=indexOf(max, backedList);
			int indexofNextMax=indexOf(nextMax, backedList);
			if(indexofNextMax>indexOfMax)
			{
				backedList.remove(indexofNextMax);
				backedList.add(0,nextMax);
				count_steps++;
			}
			System.out.println(backedList);
			dList.remove(0);
		}
		
        return count_steps;
    }
	
	private static void transformInputToMatchIndexes(int[] order) {
		//reduce 1 from each number 
		for(int i=0;i<order.length;i++)
		{
			order[i]=order[i]-1;
		}
		
	}

	private static int indexOf(int number, List<Integer> backedList)
	{
		return backedList.indexOf(number);
	}
}
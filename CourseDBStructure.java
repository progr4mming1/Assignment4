package CourseDatabaseManager;

import java.io.IOException;
import java.util.*;

public class CourseDBStructure implements CourseDBStructureInterface {
    protected int size;
    protected LinkedList<CourseDBElement> hTb[];

    
    @SuppressWarnings("unchecked")
    public CourseDBStructure(int size) {
    	
    	size = (int)(size/1.5);
    	
    	size = primeNumberBruteForce(size);
    	
        this.size = size;
        hTb = new LinkedList[size];
    }
    
    @SuppressWarnings("unchecked")
    public CourseDBStructure(String testing, int size) {
        this.size = size;
        hTb = new LinkedList[size];
    }
    
    @Override
    public void add(CourseDBElement element) {
        int index = element.hashCode() % size;
        if(hTb[index] == null) {
            hTb[index] = new LinkedList<CourseDBElement>();
        }
        hTb[index].add(element);
    }
    
    @Override
    public CourseDBElement get(int crn) throws IOException {
        String str = crn + "";
        int index = str.hashCode() % size;
        if(hTb[index] == null) {
            throw new IOException();
        }
        else {
            for(int i = 0; i < size; i++) {
                CourseDBElement temp = hTb[index].get(i);
                if(temp.getCRN() == crn) {
                    return temp;
                }
            }
            return null;
        }
    }
    
    @Override
    public int getTableSize() {
        return size;
    }

	public LinkedList<CourseDBElement>[] showAll() {
		return hTb;
		

		    }

	public static int primeNumberBruteForce(int n) {
		  
	    for (int i = n; i <= n+1000; i++) {
	        if (isPrimeBruteForce(i)) 
	       return i;
	        
	    }
	    return n;
	}
	
	public static boolean isPrimeBruteForce(int number) {
	    for (int i = 2; i < number; i++) {
	        if (number % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}

	
	
}
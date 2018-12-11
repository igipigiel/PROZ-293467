package rows.model;

public class RowModel { 
	   public static int findColumn(double x) 
	    {
	    	double width = 600/7 ; 
	    	int i ; 
	    	for (i = 0; i < 8 ; i++)
	    	{
	    		if ( x < i*width ) return i-1 ; 
	    			
	    	}
	    	return i-1 ; 
	    }
	   
	   public static int findRow(int column, int takenSpaces) throws Exception
	   {
		   	int row = 6 - takenSpaces; 
	     	if (row <= 0) throw new Exception() ; 
	     	return row ; 
	   }

}

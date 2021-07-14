package programmingTest2;

	import java.io.File;
	import java.util.Scanner;
	import java.util.Vector;

	public class MakerModel implements Comparable<MakerModel>{
	    protected String maker;  
	    protected String model;  

	    public MakerModel(String line) throws Exception {

	        String[] details = line.split(" ");
	        if(details.length != 2)
	            throw new Exception();

	        maker = details[0];
	        model = details[1];

	        if(maker.length() <= 3 || model.isEmpty())
	            throw new Exception();

	    }
	    public static Vector<MakerModel> fromFile(String fileName) throws Exception {
	        Vector<MakerModel> vector = new Vector<>();
	        Scanner scanner = new Scanner(new File(fileName));
	        while(scanner.hasNextLine()) {
	            try {
	                vector.add(new MakerModel(scanner.nextLine()));
	            } catch(Exception ex) {

	            }
	        }

	        scanner.close();

	        return vector;
	    }

	    @Override
	    public int compareTo(MakerModel object) {
	        int difference = maker.compareToIgnoreCase(object.maker);
	        if(difference == 0)
	            difference = model.compareToIgnoreCase(object.model);

	        return difference;
	    }	    
	    
	    @Override
	    public boolean equals(Object o) {
	        if(o instanceof MakerModel) {
	            MakerModel m = (MakerModel) o;
	            return maker.equalsIgnoreCase(m.maker) && model.equalsIgnoreCase(m.model);
	        }

	        return false;
	    }
	    
	    public String toString() {
	        return maker+":\t"+model;
	    }

	    @Override
	    public int hashCode() {
	        return maker.toLowerCase().hashCode() * 13 + model.toLowerCase().hashCode();
	    }



	}





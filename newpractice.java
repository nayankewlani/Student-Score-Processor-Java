import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
class details{
	private String name;
	private Double score;

	public details(String name,Double Score){
		this.name=name;
		this.score=Score;
		}
	public String toString(){
	return name +"," +score;
}
}
public class newpractice{
	public static void main(String[] args)throws IOException{
	try{
		FileInputStream inputstream=new FileInputStream("akash.txt");
		Scanner scnr=new Scanner(inputstream);
		ArrayList<String>StudentsNames=new ArrayList<>();
		ArrayList<ArrayList<Integer>>StudentScores=new ArrayList<>();
	
		while(scnr.hasNextLine())
		{
		String line=scnr.nextLine();
		String[] parts=line.split(",");
		StudentsNames.add(parts[0]);
		
		int score1=Integer.parseInt(parts[1].trim());
		int score2=Integer.parseInt(parts[2].trim());
		
		ArrayList<Integer>scores=new ArrayList<>();
		scores.add(score1);
		scores.add(score2);
		StudentScores.add(scores);
		}
		ArrayList<Double>Averages=new ArrayList<>();
		
		for(ArrayList<Integer>forstudentscores:StudentScores)
		{
		Double sum=0.00;
			for(int score:forstudentscores)
			{
			sum+=score;
			}
		Double Average=sum/forstudentscores.size();
		Averages.add(Average);
		}

		PrintWriter writer=new PrintWriter(new FileOutputStream("nayannew.csv"));
		writer.println("Names,AverageScores");
		for(int count=0;count<StudentsNames.size();count++)
		{
		details s=new details(StudentsNames.get(count),Averages.get(count));
		writer.println(s);
		}
		writer.close();
		scnr.close();
		System.out.println("program successfully executed");
	}catch(IOException e){
			e.printStackTrace();
		}
	}
}
		

		
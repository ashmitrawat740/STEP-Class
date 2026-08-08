import java.util.Scanner;
public class q2_csvstudentrecord {
    public static void parsestudentrecord(String csvline) {
        String data[] = csvLine.split(",");
        if(data.length < 3){
            System.out.println("Invalide Record");
        }
        String name = data[0];
        String rollNo = data[1];
        String department  = data[2];
        System.out.println("Name:" + name+ "| Roll No:" +rollNo+ "| Department:" + department);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Strung csvLine = sc.nextLine();
        parsestudentrecord(csvline);
    }
}
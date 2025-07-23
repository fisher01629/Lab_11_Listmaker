import java.util.Scanner;
import java.util.ArrayList;


public class Listmaker {
    public static final Scanner in = new Scanner(System.in);
    public static ArrayList<String> myArrList = new ArrayList<>();
    public static void main(String[] args){
        boolean done = false;
        String choice = "";
        do {
            display();
            choice = SafeInput.getRegExString(in, "Choose A,D,I,P or Q", "[AaDdIiPpQq]");
            if(choice.equalsIgnoreCase("A")){
                add();
            }else if(choice.equalsIgnoreCase("D")){
                delete();
            }else if(choice.equalsIgnoreCase("I")){
                insert();
            }else if(choice.equalsIgnoreCase("P")){
                print();
            }else{
                done = quit();
            }


        }while(!done);


    }
    private static void display(){
        System.out.println("A-Add an item/D-Delete an item/I-Insert an item/P-Print the list/Q-Quit");
        for(int i = 0; i<myArrList.size();i++){
            System.out.println("Index " + i + ": " + myArrList.get(i));
        }
    }
    private static void add(){
        String getString = SafeInput.getNonZeroLenString(in,"What string would you like to add? ");
        myArrList.add(getString);
    }
    private static void delete(){
        if(myArrList.isEmpty()){
            System.out.println("The list is empty");
            return;
        }
        int getIndex = SafeInput.getRangedInt(in,"Enter the index of the string you want to delete: ", 0, myArrList.size()-1);
        myArrList.remove(getIndex);
    }
    private static void insert(){
        String getString = SafeInput.getNonZeroLenString(in,"What string would you like to insert? ");
        if(myArrList.isEmpty()){
            myArrList.add(getString);
            System.out.println("The list is empty so spot 1 is the only spot you could insert. ");
            return;
        }
        int getIndex = SafeInput.getRangedInt(in,"Enter the index of the string you want to insert in: ", 0, myArrList.size()-1);
        myArrList.add(getIndex, getString );
    }
    private static void print(){
        System.out.println();
        System.out.println(myArrList);
        System.out.println();
        if(myArrList.isEmpty()){
            System.out.println("The list is empty");
        }
    }
    private static boolean quit(){
        boolean done = false;
        boolean quit = SafeInput.getYNConfirm(in, "Are you sure you want to quit? ");
        if(quit == true){
            System.out.print("Please type query if you want to quit: ");
            String response = in.nextLine();
            if(response.equals("query")){
                done = true;
            }
            else{
                System.out.println("You typed " + response + " so it will continue");
            }
        }
        return done;
    }


}

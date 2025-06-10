class TrainStop{
    private int ID;
    private String Name;
    public TrainStop next;
    public TrainStop prv;

    public TrainStop(int ID,String Name) {
        this.ID=ID;
        this.Name=Name;
        this.next=null;
        this.prv=null;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return Name;
    }

}


class TrainRout{
    private TrainStop head;
    //private TrainStop tail;

    public TrainRout(){
        head=null;
       // tail=null;
    }

    public boolean isEmpty(){
        return (head==null);
    }



    public int getSize(){
        int size=0;
        TrainStop current=head;

        while (current!=null) {
            size++;
            current=current.next;
        }

        return size;
    }



    public void AddStop(int ID , String Name, int Position){
        TrainStop newStop =new TrainStop(ID, Name);
        if(isEmpty()){
            head=newStop;
            //tail=newStop;
            return;
        }

        int size=getSize();
        if(size==1){
            head.next=newStop;
            head.prv=newStop;
            newStop.prv=head;
            return;
        }

        
        else if(size<Position){
            TrainStop lastStop=head.prv;
            newStop.next=null;
            newStop.prv=lastStop;
            lastStop.next=newStop;
            head.prv=newStop;
            return;
        }
        else if(size>Position){
            int currentPosition=0;
            TrainStop current=head;

            while (currentPosition<Position) {
                currentPosition++;
                current=current.next;  
            }

            newStop.next=current.next;
            newStop.prv=current;
            current.next=newStop;
            current.next.prv=newStop;

        }

        
        
    } 

    public void RemoveStop(int ID){

        if (isEmpty()) {
            System.out.println("Route is empty. Nothing to remove.");
            return;
        }

        TrainStop currStop=head;
        int size=getSize();

        while (currStop!=null) {
            if(currStop.getID()==ID){
                //only head in route
                if (currStop == head && size==1) {
                    head=null;
                    return;

                }

                else if (currStop == head) {
                    currStop.next.prv=head.prv;
                    head.prv=null;
                    head.next=null;
                    head=currStop.next;
                    return;
                    
                }
                else if (currStop==head.prv) {
                    head.prv=currStop.prv;
                    currStop.prv.next=null;
                    currStop.prv=null;
                    return;

                    
                }

                else {
                    currStop.prv.next = currStop.next;
                    currStop.next.prv = currStop.prv;
                    return;
                }

            }
            currStop=currStop.next; 
            
        }

    }

    public void FindStop(int ID){
        TrainStop current=head;
        int Position=0;

        while(current!=null){
            Position++;
            if(current.getID()==ID){
                System.out.println("ID: "+current.getID()+
                ", Name: "+current.getName()+", Poition= "+
                Position);
                return;
            }
            current=current.next;

            

        }
        System.out.println("Not Found");


    }
    public void DisplayRoute() {
        if (isEmpty()) {
            System.out.println("The train route is empty.");
            return;
        }

        TrainStop current = head;
        System.out.println("Train Route (Start to End):");

        while (current != null) {
            System.out.println("ID: " + current.getID() + ", Name: " + current.getName());
            current = current.next;
        }
    }


}

public class TrainRouteManager {
    public static void main(String[] args) {

        TrainRout route = new TrainRout();

        System.out.println("\n--- Test: AddStop (3 stops) ---");
        route.AddStop(1, "Jaffna", 0);   // Add first
        route.AddStop(2, "Vavuniya", 1); // Add to end
        route.AddStop(3, "Colombo", 2);  // Add to end
        System.out.println("working DisplayRoute");
        route.DisplayRoute(); // Expected: Jaffna, Vavuniya, Colombo

        System.out.println("\n--- Test: AddStop at middle ---");
        route.AddStop(4, "Anuradhapura", 1);
        System.out.println("working DisplayRoute");
        route.DisplayRoute(); // Expected: Jaffna, Anuradhapura, Vavuniya, Colombo

        System.out.println("working Findstop");
        System.out.println("\n--- Test: FindStop ---");
        route.FindStop(3); // Expected: ID: 3, Name: Colombo, Position= 4
        route.FindStop(5); // Expected: Not Found

        System.out.println("\n--- Test: RemoveStop (middle) ---");
        route.RemoveStop(2); // Remove Vavuniya
        route.DisplayRoute(); // Expected: Jaffna, Anuradhapura, Colombo

        System.out.println("\n--- Test: RemoveStop (head) ---");
        route.RemoveStop(1); // Remove Jaffna
        route.DisplayRoute(); // Expected: Anuradhapura, Colombo

        System.out.println("\n--- Test: RemoveStop (tail) ---");
        route.RemoveStop(3); // Remove Colombo
        route.DisplayRoute(); // Expected: Anuradhapura

        System.out.println("\n--- Test: RemoveStop (only one left) ---");
        route.RemoveStop(4); // Remove Anuradhapura
        route.DisplayRoute(); // Expected: The train route is empty

        System.out.println("\n--- Test: AddStop & ReverseRoute ---");
        route.AddStop(10, "Jaffna", 0);
        route.AddStop(20, "Kilinochchi", 1);
        route.AddStop(30, "Mannar", 2);
        route.DisplayRoute(); // Expected: Jaffna, Kilinochchi, Mannar

        //route.ReverseRoute();
        route.DisplayRoute(); // Expected: Mannar, Kilinochchi, Jaffna
    }
}

        
    
    


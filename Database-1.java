
import java.util.*;

public class Database {

    private HashMap<Integer, Member> memberTable;

    public Database() {
        memberTable = new HashMap<Integer, Member>();
    }

    //accepts member objects and adds to hash table
    public void Add(Member member) {
        memberTable.put(member.getIdNumber(), member);
    }

    //accepts member IdNumber and returns member object
    public Member Find(int idNumber) {
        return memberTable.get(idNumber);
    }
    
    //alphabetically sorts members by last name
    private void Quicksort(Member[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = Partition(arr, low, high);
            Quicksort(arr, low, partitionIndex - 1);
            Quicksort(arr, partitionIndex + 1, high);
        }
    }

    //partitions array using the last element as pivot
    private int Partition(Member[] arr, int low, int high) {
    	//chooses pivot based on last name
        String pivot = arr[high].getLastName();
        //right position of pivot 
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].getLastName().compareToIgnoreCase(pivot) < 0) {
                i++;
                Member temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Member temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    //calls Quicksort method 
    //returns formatted String
    public String NamesString() {
        Collection<Member> memberCollection = memberTable.values();
        Member[] memberArray = memberCollection.toArray(new Member[memberCollection.size()]);
        Quicksort(memberArray, 0, memberArray.length - 1);
        StringBuilder sb = new StringBuilder();
        for (Member member : memberArray) {
            sb.append(member.getLastName());
            sb.append(", ");
            sb.append(member.getFirstName());
            sb.append("\n");
        }
        return sb.toString();
    }
}

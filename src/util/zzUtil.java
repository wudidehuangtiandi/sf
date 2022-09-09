package util;

import java.util.ArrayList;

public class zzUtil {
    public static void main(String[] args) {
        String[] m = {"addAtHead","addAtTail","addAtTail","get","get","addAtTail","addAtIndex","addAtHead","addAtHead","addAtTail","addAtTail","addAtTail","addAtTail","get","addAtHead","addAtHead","addAtIndex","addAtIndex","addAtHead","addAtTail","deleteAtIndex","addAtHead","addAtHead","addAtIndex","addAtTail","get","addAtIndex","addAtTail","addAtHead","addAtHead","addAtIndex","addAtTail","addAtHead","addAtHead","get","deleteAtIndex","addAtTail","addAtTail","addAtHead","addAtTail","get","deleteAtIndex","addAtTail","addAtHead","addAtTail","deleteAtIndex","addAtTail","deleteAtIndex","addAtIndex","deleteAtIndex","addAtTail","addAtHead","addAtIndex","addAtHead","addAtHead","get","addAtHead","get","addAtHead","deleteAtIndex","get","addAtHead","addAtTail","get","addAtHead","get","addAtTail","get","addAtTail","addAtHead","addAtIndex","addAtIndex","addAtHead","addAtHead","deleteAtIndex","get","addAtHead","addAtIndex","addAtTail","get","addAtIndex","get","addAtIndex","get","addAtIndex","addAtIndex","addAtHead","addAtHead","addAtTail","addAtIndex","get","addAtHead","addAtTail","addAtTail","addAtHead","get","addAtTail","addAtHead","addAtTail","get","addAtIndex"};

        String p = "[84],[2],[39],[3],[1],[42],[1-80],[14],[1],[53],[98],[19],[12],[2],[16],[33],[4-17],[6-8],[37],[43],[11],[80],[31],[13-23],[17],[4],[10-0],[21],[73],[22],[24-37],[14],[97],[8],[6],[17],[50],[28],[76],[79],[18],[30],[5],[9],[83],[3],[40],[26],[20-90],[30],[40],[56],[15-23],[51],[21],[26],[83],[30],[12],[8],[4],[20],[45],[10],[56],[18],[33],[2],[70],[57],[31-24],[16-92],[40],[23],[26],[1],[92],[3-78],[42],[18],[39-9],[13],[33-17],[51],[18-95],[18-33],[80],[21],[7],[17-46],[33],[60],[26],[4],[9],[45],[38],[95],[78],[54],[42-86]";

        String[] ps = p.split(",");

        ArrayList<String> pp = new ArrayList<>();

        for (String s : ps) {
            pp.add(s.substring(s.indexOf("[")+1,s.indexOf("]")));
        }

        for (int i = 0; i < m.length; i++) {
            if(m[i].contains("addAtHead")){
                System.out.println("myLinkedList.addAtHead("+pp.get(i)+");");
            }
            if(m[i].contains("addAtTail")){
                System.out.println("myLinkedList.addAtTail("+pp.get(i)+");");
            }
            if(m[i].contains("deleteAtIndex")){
                System.out.println("myLinkedList.deleteAtIndex("+pp.get(i)+");");
            }

            if(m[i].contains("get")){
                System.out.println(" System.out.println(myLinkedList.get("+pp.get(i)+"));");
            }
            if(m[i].contains("addAtIndex")){
                String[] s = pp.get(i).split("-");
                System.out.println("myLinkedList.addAtIndex("+s[0]+","+s[1]+");");
            }
        }
    }
}

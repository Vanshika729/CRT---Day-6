import java.util.*;
public class Graph{
    int nodeCount;
    ArrayList<String> nodes;
    ArrayList<ArrayList<Integer>> graph;
    public Graph(){
        nodeCount=0;
        nodes=new ArrayList<>();
        graph=new ArrayList<>();
    }
public void node(String v){
    if(nodes.contains(v)){
        System.out.println(v+" is already present");
    }
    else{
        ++nodeCount;
        nodes.add(v);
        for (ArrayList<Integer> row : graph) {
            row.add(0);
        }
        ArrayList<Integer> temp=new ArrayList<>();
        for(int i=0;i<nodeCount;i++){
            temp.add(0);
        }
        graph.add(temp);
    }
}
public void undweight(String v1,String v2){
    if(!nodes.contains(v1)){
        System.out.println(v1+" not present");
    }
    if(!nodes.contains(v2)){
        System.out.println(v2+" not present");
    }
    int index1=nodes.indexOf(v1);
    int index2=nodes.indexOf(v2);
    graph.get(index1).set(index2, 1);
    graph.get(index2).set(index1, 1);
}
public void undedge(String v1,String v2,int w){
    if(!nodes.contains(v1)){
        System.out.println(v1+" not present");
    }
    if(!nodes.contains(v2)){
        System.out.println(v2+" not present");
    }
    int index1=nodes.indexOf(v1);
    int index2=nodes.indexOf(v2);
    graph.get(index1).set(index2, w);
    graph.get(index2).set(index1, w);
}
public void dweight(String v1,String v2,int w){
    if(!nodes.contains(v1)){
        System.out.println(v1+" not present");
    }
    if(!nodes.contains(v2)){
        System.out.println(v2+" not present");
    }
    int index1=nodes.indexOf(v1);
    int index2=nodes.indexOf(v2);
    graph.get(index1).set(index2, w);
}
public void dedge(String v1,String v2){
    if(!nodes.contains(v1)){
        System.out.println(v1+" not present");
    }
    if(!nodes.contains(v2)){
        System.out.println(v2+" not present");
    }
    int index1=nodes.indexOf(v1);
    int index2=nodes.indexOf(v2);
    graph.get(index1).set(index2, 1);
}
public void print(){
    // for (int i=0;i<nodeCount;i++) {
    //     // for(int j=0;j<graph.get(i).size();j++)
    //     for(int j=0;j<nodeCount;j++){
    //         System.out.print(graph.get(i).get(j)+" ");
    //     }
    //     System.out.println();
    // }
    System.out.print("  ");
    for (int i = 0; i < nodeCount; i++) {
        System.out.print(nodes.get(i) + " ");
    }
    System.out.println();
    for (int i = 0; i < nodeCount; i++) {
        System.out.print(nodes.get(i) + " ");
        for (int j = 0; j < nodeCount; j++) {
            System.out.print(graph.get(i).get(j) + " ");
        }
        System.out.println();
    }
}
public void delete(String v9){
    if(!nodes.contains(v9)){
        System.out.println(v9+" not present");
    }
    else{
        int index=nodes.indexOf(v9);
        nodes.remove(index);
        graph.remove(index);
        for (ArrayList<Integer> row : graph) {
            row.remove(index);
        }
        nodeCount--;
    }
}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Graph g=new Graph();
        while(true){
            System.out.println();
            System.out.println("Enter the choice");
            System.out.println("1.(Insertion) Add a node using adjacency matrix representation");
            System.out.println("2.(Insertion) Add an edge using adjacency matrix representation(undirected unweighted");
            System.out.println("3.(Insertion) Add an edge undirected weighted graph");
            System.out.println("4.(Insertion) Add an edge directed weighted graph");
            System.out.println("5.(Insertion) Add an edge directed unweighted graph");
            System.out.println("6.Print graph");
            System.out.println("7.Delete operation");
            System.out.println("0.Exit");
            int ch=sc.nextInt();
            switch(ch){
                case 1:System.out.println("Enter vertex");
                    String v=sc.next();
                    g.node(v);
                    break;
                case 2:System.out.println(g.nodes);
                    System.out.println("Select first node");
                    String v1=sc.next();
                    System.out.println("Select second node");
                    String v2=sc.next();
                    g.undweight(v1,v2);
                    break;
                case 3:
                    System.out.println(g.nodes);
                    System.out.println("Select first node");
                    String v3=sc.next();
                    System.out.println("Select second node");
                    String v4=sc.next();
                    System.out.println("Enter weight");
                    int w=sc.nextInt();
                    g.undedge(v3,v4,w);
                    break;
                case 4:System.out.println(g.nodes);
                    System.out.println("Select first node");
                    String v5=sc.next();
                    System.out.println("Select second node");
                    String v6=sc.next();
                    System.out.println("Enter weight");
                    int w1=sc.nextInt();
                    g.dweight(v5,v6,w1);
                    break;
                case 5:System.out.println(g.nodes);
                    System.out.println("Select first node");
                    String v7=sc.next();
                    System.out.println("Select second node");
                    String v8=sc.next();
                    g.dedge(v7,v8);
                    break;
                case 6:g.print();
                    break;
                case 7:System.out.println(g.nodes);
                    System.out.println("Enter the node to be deleted");
                    String v9=sc.next();
                    g.delete(v9);
                    break;
                case 0: System.exit(0);
                default:System.out.println("Please enter correct choice");
        }
        }
    }
}

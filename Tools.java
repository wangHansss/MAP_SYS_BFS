import java.util.Iterator;
import java.util.LinkedList;

public class Tools {
                                       //0 1 2 3 4 5 6 7 8 9 10 11 12
    public static  int[][] adjMatrix = {{0,1,0,1,0,0,0,0,0,0,0,0,0},   //0 
                                        {1,0,0,0,1,1,0,0,0,0,0,0,0},   //1
                                        {0,0,0,1,0,0,1,1,0,0,0,0,0},   //2
                                        {1,0,1,0,0,0,0,1,0,0,0,0,0},   //3
                                        {0,1,0,0,0,1,0,0,0,0,0,0,0},   //4
                                        {0,1,0,0,1,0,1,0,1,0,0,0,0},   //5
                                        {0,0,1,0,0,1,0,0,1,0,0,0,0},   //6
                                        {0,0,1,1,0,0,0,0,0,1,1,0,0},   //7 
                                        {0,0,0,0,0,1,1,0,0,1,0,1,0},   //8
                                        {0,0,0,0,0,0,0,1,1,0,0,1,1},   //9
                                        {0,0,0,0,0,0,0,1,0,0,0,0,1},   //10
                                        {0,0,0,0,0,0,0,0,1,1,0,0,1},   //11
                                        {0,0,0,0,0,0,0,0,0,1,1,1,0}};  //12
    //全局链表用于存放路径信息
    public static LinkedList<Integer> list = new LinkedList<>();

    public static void search(int source, int target){
        BFS.bfsMethod(adjMatrix, source);
        Iterable<Integer> temp = BFS.pathTo(target);
        Iterator<Integer> iterator = temp.iterator();
        while (iterator.hasNext()) {
            int x = iterator.next();
            list.add(x);
        }
        System.out.println(BFS.pathTo(target));
    }

}

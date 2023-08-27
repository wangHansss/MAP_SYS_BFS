import java.util.*;

//BFS算法主要运用于遍历

public class BFS {
    //edgeTo代表顶点连通情况，在找出路线时会用到
    public static int[] edgeTo = new int[13];
    //用于判断用户输入的起点是否能够到达，本地图所有点连通，可以忽略
    public static boolean[] marked = new boolean[13];
    //s表示起点
    public static int s;

    public static void bfsMethod(int[][] adjMatrix, int sourceNode){
        //利用队列
        Queue<Integer> queue = new LinkedList<Integer>();
        int numOfNodes = adjMatrix[sourceNode].length;
        int[] isVisited = new int[numOfNodes];//没访问过的初始化为0
        s = sourceNode;
        //因为从起点开始，所以起点首先被访问
        isVisited[sourceNode] = 1;
        //把起点加入队列
        queue.add(sourceNode);
        //i用于后面的遍历
        int i = 0;
        //
        int element = 0;
        //
        marked[i] = true;
        while(!queue.isEmpty()){
            //开始查找队列第一个顶点与其他点连接的情况，并删除自己
            element = queue.remove();
            //打印出来代表这个顶点已经找过了
            System.out.print(element+" ");
            i = 0;
            //这里要循环13次把，每个顶点都找一次
            while(i < numOfNodes){
                //如果邻接矩阵为1则代表这俩顶点是连起来的  &&  这个顶点没被访问过
                if(adjMatrix[element][i] == 1 && isVisited[i] == 0){
                    //按照最先遍历到的1进入队列为原则, 如果有好几个1在一行,也就是一个顶点与多个顶点相连
                    queue.add(i);
                    //该顶点被访问过了
                    isVisited[i] = 1;
                    //下面两句用于寻路，如果想要到i节点可以走element节点
                    edgeTo[i] = element;    
                    //代表能够到达i节点，因为本地图所有点是连通的，这个东西没起到作用
                    marked[i] = true;
                }
                i++;
            }
        }
    }
    //地图连通的，可以忽略
    public static boolean hasPath(int v){
        return marked[v];
    }
    //返回一个迭代器
    public static Iterable<Integer> pathTo(int v){
        //忽略
        if(!hasPath(v))
            return null;
        //新建一个路径栈，用于存放路线信息
        Stack<Integer> path = new Stack<Integer>();
        //edgeTo[x]存放着x顶点的上一节点，一直往上一节点找并压入栈中，到达起点时退出
        for(int x=v; x!=s; x=edgeTo[x])     
            path.push(x);
        //把起点加进去，形成路线
        path.push(s);
        //返回路线用于界面画图
        return path;
    }

    public static void main(String[] args){
                            //0 1 2 3 4 5 6 7 8 9 10 11 12
        int[][] adjMatrix = {{0,1,0,1,0,0,0,0,0,0,0,0,0},   //0 
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

        System.out.println("图的广度优先遍历(BFS)结果为(从0开始编号):");

        //这个函数参数为起点
        bfsMethod(adjMatrix, 3);
        System.out.println();
        
        //pathTo函数为终点
        System.out.println(pathTo(12));
    }
}

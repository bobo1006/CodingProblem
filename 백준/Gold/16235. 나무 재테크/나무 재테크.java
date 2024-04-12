import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    static class Tree implements Comparable<Tree>{
        int x,y;
        int age;
        Tree(int x, int y, int age){
            this.x = x;
            this.y = y;
            this.age = age;
        }
        @Override
        public int compareTo(Tree o){
            return this.age - o.age;
        }
    }
    static PriorityQueue<Tree> trees1 = new PriorityQueue<>();
    static int[][] map, A;
    static int N;
    static int[][] dir = {{-1,-1}, {-1,0}, {-1, 1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i=0;i<N;i++){
            Arrays.fill(map[i], 5);
        }

        A = new int[N][N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees1.add(new Tree(x,y,age));
        }
        Queue<Tree> dead = new LinkedList<>();
        Queue<Tree> breeding = new LinkedList<>();

        for (int i=0;i<K;i++){
            trees1 = spring(dead, breeding);
            summer(dead);
            autumn(breeding);
            winter();
        }
        System.out.println(trees1.size());
    }
    private static PriorityQueue<Tree> spring(Queue<Tree> dead, Queue<Tree> breeding){
        PriorityQueue<Tree> trees2 = new PriorityQueue<>();

        while (!trees1.isEmpty()){
            Tree now = trees1.poll();
            if (now.age > map[now.x][now.y]){
                dead.add(now);
            }
            else{
                map[now.x][now.y] -= now.age;
                Tree tree = new Tree(now.x, now.y, now.age+1);
                if (tree.age % 5 == 0){
                    breeding.add(tree);
                }
                trees2.add(tree);
            }
        }

        return trees2;
    }
    private static void summer(Queue<Tree> dead){
        while (!dead.isEmpty()){
            Tree now = dead.poll();
            map[now.x][now.y] += now.age/2;
        }
    }
    private static void autumn(Queue<Tree> breeding){

        while (!breeding.isEmpty()){
            Tree t = breeding.poll();
            for (int i=0;i<8;i++){
                int nextX = t.x + dir[i][0];
                int nextY = t.y + dir[i][1];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                trees1.add(new Tree(nextX, nextY, 1));
            }
        }
    }
    private static void winter(){
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                map[i][j] += A[i][j];
            }
        }
    }
}
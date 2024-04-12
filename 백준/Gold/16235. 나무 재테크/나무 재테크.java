import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayDeque<Integer>[][] trees;
    static int[][] map, A;
    static int N;
    static int[][] dir = {{-1,-1}, {-1,0}, {-1, 1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        trees = new ArrayDeque[N][N];
        map = new int[N][N];
        for (int i=0;i<N;i++){
            Arrays.fill(map[i], 5);
        }

        A = new int[N][N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                trees[i][j] = new ArrayDeque();
            }
        }
        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees[x][y].add(age);
        }

        for (int i=0;i<K;i++){
            springAndSummer();
            fall();
            winter();
        }
        int total = 0;
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                total += trees[i][j].size();
            }
        }
        System.out.println(total);
    }
    private static void springAndSummer(){
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                int size = trees[i][j].size();
                int nutrient = 0;

                for (int k=0;k<size;k++){
                    int now = trees[i][j].pollFirst();
                    if (map[i][j] < now){
                        nutrient += now/2;
                    }
                    else{
                        map[i][j] -= now;
                        trees[i][j].add(now + 1);
                    }
                }
                map[i][j] += nutrient;
            }
        }

    }
    private static void fall(){
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                int size = trees[i][j].size();

                for (int k=0;k<size;k++){
                    int now = trees[i][j].poll();

                    if (now % 5 == 0){

                        for (int d=0;d<8;d++){
                            int nextX = i + dir[d][0];
                            int nextY = j + dir[d][1];
                            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                            trees[nextX][nextY].addFirst(1);
                        }
                    }
                    trees[i][j].add(now);
                }
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
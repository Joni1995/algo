package SWEA_1953_탈주범검거_현수;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int N, M, R, C, L;
    static int[][] map;
    static int[][] visited;
    //상하좌우 방향
    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0, 0, -1, 1};
     
    static int[][] tunnel = {
        {0, 0, 0, 0},
        {1, 1, 1, 1},
        {1, 1, 0, 0},
        {0, 0, 1, 1},
        {1, 0, 0, 1},
        {0, 1, 0, 1},
        {0, 1, 1, 0},
        {1, 0, 1, 0}
    };
 
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        //테스트 케이스
        int T =sc.nextInt();
         
        for (int tc=1; tc<=T; tc++) {
            //N*M 크기의 지하터널 (5 ≤ N, M ≤ 50)
            N = sc.nextInt();
            M = sc.nextInt();
            //맨홀 뚜껑의 위치 R,C (0 ≤ R ≤ N-1, 0 ≤ C ≤ M-1)
            R = sc.nextInt();
            C = sc.nextInt();
            //탈출 후 소요된 시간 L (1 ≤ L ≤ 20)
            L = sc.nextInt();
             
            map = new int[N+2][M+2];
            visited = new int[N+2][M+2];
             
            //맵 크기를 크게 만들었으므로 좌표 1씩 증가해서 조정 작업
            R+=1;
            C+=1;
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=M; j++) {
                    map[i][j] = sc.nextInt();
                }
            }//map정보 입력 끝
            visited[R][C] = 1;
            bfs();
 
            int cnt = 0;
            for(int[]a : visited) {
                for(int c : a)
                    if(c>0 && c <=L ) cnt++;
            }
            System.out.printf("#%d %d\n",tc, cnt);
             
        }//end test case
             
    }
     
    //bfs탐색 row, col정보, depth:깊이, dir: 이전 터널의 연결정보
    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int row = R;
        int col = C;
        queue.offer(new int[] {row, col});
 
        //queue가 빌 때 까지
        while(!queue.isEmpty()) {
            //queue에서 값 하나 꺼내기
            int[] tmp = queue.poll();
            int currInfo = map[tmp[0]][tmp[1]];
            for(int i=0; i<4; i++) {
                int nr = tmp[0]+dr[i];
                int nc = tmp[1]+dc[i];
                //연결 가능한 방향이라면
                if(tunnel[currInfo][i]==1) {
                    //연결을 원하는 터널에 터널이 있고 연결을 받을 수 있는 터널인지 쳌
                    if(tunnel[map[nr][nc]][changeDir(i)] == 1 && visited[nr][nc]==0) {                      
                        //연결되어 있는 맵 정보 queue에 넣기
                        queue.offer(new int[] {nr, nc});
                        visited[nr][nc] = visited[tmp[0]][tmp[1]] + 1;
                    }
                }
            }
             
        }
    }
    //다음 터널 정보 방향정보를 뒤집어서 전달해주기 위한 메소드
    static int changeDir(int dir) {
        //상이면 하로
        if(dir == 0) return 1;
        //하면 상으로
        else if(dir == 1) return 0;
        //좌면 우로
        else if(dir == 2) return 3;
        //우면 좌로
        else  return 2;
    }
}
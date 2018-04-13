package week01;

import java.util.Stack;

public class Recursion {

    public static void main(String[] args) {

//        System.out.println(recursiveSum(30));

//        Stack<Integer> temp = new Stack<>();
//        pick(5,2,temp);

        boolean result = boggle(2,2,"urcbqwe");
        System.out.println(result);

    }

    //1부터 n까지의 합을 계산하는 재귀 함수
    public static int recursiveSum(int n){
        if(n == 1){
            return 1;
        }
        return n + recursiveSum(n-1);
    }

    //n개의 원소중 m개를 고르는 모든 조합을 찾는 알고리즘
    public static void pick(int n, int m, Stack<Integer> picked){
        // m 개의 숫자를 뽑았을때 결과 출력
        if(m == 0 ){
            System.out.println(picked);
            return ;
        }
        int small = picked.isEmpty() ? 0 : picked.lastElement() + 1;

        for (int next = small; next < n ; ++next){
            picked.push(next);
            pick(n,m-1,picked);
            picked.pop();
        }

    }



    //boggle게임
    public static final int[] gx = {-1,0,1,-1,1,-1,0,1};
    public static final int[] gy = {-1,-1,-1,0,0,1,1,1};
    public static final char[][] test = {
            {'a','b','c','d','e'},
            {'c','r','q','w','e'},
            {'t','y','u','i','p'},
            {'l','k','j','h','g'},
            {'f','z','x','b','m'}
    };

    public static boolean boggle(int x, int y, String word){
        //범위에 벗어나거나 좌표의 글자와 word의 첫글자가 일치하지 않을때 실패
        if(!inRange(x,y) || word.charAt(0) != test[y][x]) return false;
        //위의 조건을 통과하고 word의 길이가 1이면 성공
        if(word.length() == 1){
            return true;
        }
        //기준 좌표 8방을 탐색하고 재귀호출을 통한 값이 모두 true이면 최종적으로 true반환
        for( int i = 0 ; i < 8 ; i++){
            if(boggle(x-gx[i], y-gy[i], word.substring(1))) return true;
        }

        return false;
    }

    //x,y 좌표가 범위를 벗어났을때 처리
    public static boolean inRange(int x, int y){
        try{
            char temp = test[y][x];
        }catch (Exception e){
            return false;
        }
        return true;
    }

}

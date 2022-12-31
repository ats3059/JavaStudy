package lecture;

import java.util.LinkedList;
import java.util.Queue;

public class Truck {
    public static void main(String[] args) {
        int solution = new Truck().solution(2, 10, new int[]{7,4,5,6});
        System.out.println(solution);
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int moveTruckSize = 0;
        Queue<TruckStatus> q = new LinkedList<>();
        Queue<TruckStatus> moveTruckQ = new LinkedList<>();

        for (int i : truck_weights) {
            q.offer(new TruckStatus(i,0));
        }

        TruckStatus firstTruck = q.poll();
        moveTruckQ.offer(firstTruck);
        moveTruckSize += firstTruck.weight;

        while (!q.isEmpty() || !moveTruckQ.isEmpty()) {
            if(!q.isEmpty()){
                if(answer > 0 && q.peek().weight + moveTruckSize <= weight) {
                    TruckStatus truck = q.poll();
                    moveTruckQ.offer(truck);
                    moveTruckSize += truck.weight;
                }
            }

            int moveSize = moveTruckQ.size();

            for (int i = 0; i < moveSize; i++) {
                TruckStatus truckStatus = moveTruckQ.poll();
                if(truckStatus.level < bridge_length) {
                    truckStatus.level += 1;
                    moveTruckQ.offer(truckStatus);
                    if(truckStatus.level == 2) moveTruckSize -= truckStatus.weight;
                }
            }

            answer++;
        }

        return answer;
    }

    static class TruckStatus{

        public TruckStatus(int weight, int level) {
            this.weight = weight;
            this.level = level;
        }

        int weight;
        int level;
    }

}

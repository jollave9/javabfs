/**
 * Queue
 */
public class Queue {

    private int queue[][]=new int[2000][2];
    private int front;
    private int rear;
    private int pointer;

    public Queue(){
        front = 0;
        rear = 0;
        pointer = 0;
    }

    public void enque(int Q,int origin){
        queue[rear][0]=Q;
        queue[rear][1]=origin;
        rear++;
    }

    public boolean contains(int x){
        for(int i=0;i<rear;i++){
			if(this.queue[i][1]==x)
			return true;
		}
		return false;
    }

    public void displayQueue(){
        System.out.println("Queue:");
        for(int i=0;i<rear;i++){
            System.out.println(queue[i][0]+" "+queue[i][1]);
        }
    }

    public int next(int origin){
        origin = queue[pointer++][0];
        return origin;
    }

    public int findPosQ(int path){
        int i = rear-1;
        int pos=0;
        while(i>=0){
            if(queue[i][0]==path){
                pos=i;
                break;
            }
            i--;
        }
        return pos;
    }

    public void displayPath(int start,int goal){
        int path=goal;
        System.out.println("Path:");
        while(path!=start){
            System.out.println(path);
            path = queue[findPosQ(path)][1];
        }
        System.out.println(start);
    }
}
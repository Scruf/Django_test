public class Source{
    static void filling(int []array){
        for(int i=0;i<array.length;i++)
            array[i]=(int)(Math.random()*20);
    }
    static void output(int []array){
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
    }
    static void bubblesort(int []array){
        for(int i=0;i<array.length;i++)
            for(int j=1;j<array.length;j++)
                if(array[j]<array[j-1]){
                    int var=array[j];
                    array[j]=array[j-1];
                    array[j-1]=var;
                }
    }
    static void quickSort(int []array,int first,int last){
        int i,j,pivot;
        if(first<last){
            i=first;
            j=last;
            pivot=first;
            while(i<j){
                while(array[i)<=array[pivot] && i<last)
                    i++;
                while(array[j]>array[pivot])
                    j--;
                if(i<j){
                    int var=array[i];
                    array[i]=array[j];
                    array[j]=var;
                }
            }
            int var=array[pivot];
            array[pivot]=array[j];
            array[j]=var;
            quickSort(array,first,j-1);
            quickSort(array,j+1,last);
        }
    }
    static void merge(int []array,int first,int middle,int last){
        int tempPos=first;
        int leftEnd=middle-1;
        int numberOfElements=(last-first)+1;
        int []temp = new int [array.length];
        while((first<=leftEnd)&&(middle<=last)){
            if(array[first]<array[middle])
                temp[tempPos++]=array[first++];
            else
                temp[tempPos++]=array[middle++];
                
        }
        while(first<=leftEnd)
            temp[tempPos++]=array[first++];
        while(middle<=last)
            temp[tempPos++]=array[middle++];
        for(int i=0;i<numberOfElements;i++){
            array[last]=temp[last];
            last--;
        }
    }
    static void mergeSort(int []array,int first,int last){
        int middle;
        if(first<last){
            middle=(first+last)/2;
            mergeSort(array,first,middle);
            mergeSort(array,middle+1,last);
            merge(array,first,middle+1,last);
            
        }
    }
    static void siftDown(int []array,int start,int end){
        int root=start;
        while(root*2+1<=end){
            int child=root*2+1;
            if(child<=end && array[child)<array[child+1]){
                int var=array[root];
                array[root]=array[child];
                array[child]=var;
                root=child;
            }
            else
                return;
        }
    }
    static void heapify(int []array,int count){
        int start=(count-2)/2;
        while(start>=0){
            siftDown(array,start,count-1);
            start--;
        }
    }
    static void heapSort(int []array){
        int count=array.length;
        heapify(array,count-1);
        int end=count-1;
        while(end>0){
            int var=array[end];
            array[end]=array[0];
            array[0]=var;
            siftDown(array,0,end-1);
            end--;
        }
    }
    static long [][]matrixUnit(int x){
        long [][]result = new long [x][x];
        for(int i=0;i<x;i++)
            result[i][i]=1;
        return result;
    }
    static long [][]matrixAdd(long [][]a,long [][]b){
        int n=a.length;
        int m=a[0].length;
        long [][]result = new long [n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                result[i][j]=a[i][j]+b[i][j];
        return result;
    }
    static long [][]matrixMult(long [][]a,long [][]b){
        int n=a.length;
        int m=a[0].length;
        int k=b.length;
        long [][]result = new long [n][k];
        for(int i=0;i<n;i++)
            for(int j=0;j<k;j++)
                for(int x=0;x<m;x++)
                    result[i][j]+=a[i][x]*b[x][j];
        return result;
    }
    static long [][]matrixPower(long [][]a,int power){
        if(power==0)
            return matrixUnit(a.length-1);
        else if(power%2==0)
            return matrixPower(matrixMult(a,a),power-1);
        else
            return matrixMult(a,matrixPower(a,power/2));
    }
}
public class AVL{
    static class Node{
        int value;
        int height;
        Node leftl
        Node right;
            Node(){
                value=0;
                height=0;
                left=null;
                right=null;
            }
            Node(int n){
                value=n;
                height=0;
                left=null;
                right=null;
            }
    }
    private Node root;
    AVL(){
        root=null;
    }
    private int height(Node N){return N==null ? -1 : 0;}
    private int max(int leftNode,int rightNode){return leftNode > rightNode ? leftNode : rightNode;}
    private Node rotateWithLeftChild(Node N){
        Node n = N.left;
        N.left = n.right;
        n.right = N;
        N.height = max(height(N.left),height(N.right))+1;
        n.height = max(height(n.left),N.height)+1;
        return N;
    }
    private Node rotateWithRightChild(Node N){
        Node n = N.right;
        N.right = n.left;
        n.left = N;
        N.height = max(height(N.left),height(N.right))+1;
        n.height = max(height(n.right),N.height)+1;
        return N;
    }
    private Node doubleWithLeftChild(Node N){
        N.left = rotateWithRightChild(N);
        return rotateWithLeftChild(N);
    }
    private Node doubleWithRightChild(Node N){
        N.right = rotateWithLeftChild(N);
        return rotateWithRightChild(N);
    }
}
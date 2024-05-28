public class SortingTechniques {
    public static void conquer(int[] arr, int si, int mid,int ei){
        int[] merged=new int[ei-si+1];
        int idx1=si,idx2=mid+1,x=0;
        while(idx1<=mid && idx2<=ei){
            if(arr[idx1]<=arr[idx2])
                merged[x++]=arr[idx1++];
            else   
                merged[x++]=arr[idx2++];
        }
        while(idx1<=mid)
            merged[x++]=arr[idx1++];
        while(idx2<=ei)
            merged[x++]=arr[idx2++];
        for(int i=0,j=si;i<merged.length;i++,j++)
            arr[j]=merged[i];

    }
    public static void divide(int[] arr, int si, int ei){
        if(si>=ei)
            return;
        int mid=(si+ei)/2;
        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        conquer(arr,si,mid,ei);
    }
    public static int partition(int[] arr, int low, int high){
        int piv=high;
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<arr[piv]){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        int temp=arr[i];
        arr[i]=arr[piv];
        arr[piv]=temp;
        return i;
    }
    public static void quicksort(int[] arr, int low, int high){
        if(low<high){
            int pivot=partition(arr,low,high);
            quicksort(arr, low, pivot-1);
            quicksort(arr, pivot+1, high);
        }
    }
    public static void main(String[] args){
        int[] arr={1,5,2,4,3};
        divide(arr,0,arr.length-1);
        System.out.println("Sorting using merge sort");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\nSorting using quick sort");
        int[] arr1={1,5,2,4,3};
        quicksort(arr,0,arr1.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

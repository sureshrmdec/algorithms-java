package com.shulga.tc.srm;

class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,2,2,2,3,4,5,6};
        int result = findNumber(arr);
        System.out.println("Ans "+result);
    }

    public static int findNumber(int[] arr)
    {
        int upper = getUpperBound(arr);
        int length = binarySearchLength(arr,0,upper);
        int position = binarySearchDuplicate(arr,0,length-1);
        return position;
    }


    private static int getUpperBound(int[] arr)
    {
        int index = 1;
        while(true)
        {
            try
            {
                int test = arr[(int)Math.pow(2,index)];
            }
            catch(IndexOutOfBoundsException e)
            {
                return (int)Math.pow(2,index);
            }
            index++;
        }
    }

    private static int binarySearchLength(int[] arr, int low, int high)
    {
        int mid = (low+high)/2;
        if(low >= high)
        {
            return mid;
        }
        else
        {
            try
            {
                int test = arr[mid];
                return binarySearchLength(arr,mid+1,high);
            }
            catch(IndexOutOfBoundsException e)
            {
                return binarySearchLength(arr,low,mid-1);
            }
        }
    }

    private static int binarySearchDuplicate(int[] arr, int low, int high)
    {

        int mid = (low+high)/2;
        if(low >= high)
        {
            return mid-1;
        }
        if(arr[mid] == mid)
        {
            return binarySearchDuplicate(arr,low,mid);
        }
        else
        {
            return binarySearchDuplicate(arr,mid+1,high);
        }

    }
}
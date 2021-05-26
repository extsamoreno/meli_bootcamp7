import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class RadixSort
{

	public static void radixSort(int []arr)
	{
        String sArr[] = StringUtil.toStringArray(arr);
        int maxLength = StringUtil.maxLength(sArr);
        StringUtil.lNormalize(sArr, '0');
        for (int i = maxLength-1; i >= 0; i--) {

            List<String>[] myList = new List[10]; 
 
            for (int j = 0; j < sArr.length; j++) {

				int digit = Character.getNumericValue(sArr[j].charAt(i));
				if(myList[digit] == null){
					myList[digit] = new ArrayList<>();
				}
                myList[digit].add(sArr[j]);
            }
			sArr = new String[0];
			for (int x = 0; x < myList.length; x++) {
				if(myList[x] != null){

					sArr = Operations.concat(sArr, myList[x].toArray(new String[myList[x].toArray().length]));
				}

				
            }
		}

		int [] t = StringUtil.toIntArray(sArr);
		for (int i = 0; i < sArr.length; i++) {
			arr[i]= t[i];
		}
		

	}
            
	public static void main(String[] args)
	{
		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
		radixSort(arr);

		for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]+(i<arr.length-1?",":""));
		}
	}
}

import java.util.ArrayList;
import java.util.List;
public class RadixSort
{

	public static void radixSort(int []arr)
	{
        String sArr[] = StringUtil.toStringArray(arr);
        int maxLength = StringUtil.maxLength(sArr);
        StringUtil.lNormalize(sArr, '0');
        for (int i = maxLength-1; i >= 0; i--) {

            List<String>[] lists = groupByDigitPosition(sArr, i);
			sArr = extractFromLists(lists);
			
		}
		int [] iArr = StringUtil.toIntArray(sArr);
		for (int i = 0; i < sArr.length; i++) {
			arr[i]= iArr[i];
		}
		

	}
	private static String[] extractFromLists(List<String>[] lists){
		String[] output = new String[0];

		for (int x = 0; x < lists.length; x++) {
			if(lists[x] != null){

				output = Operations.concat(output, lists[x].toArray(new String[lists[x].toArray().length]));
			}
		}
		return output;
	}

	private static List<String>[] groupByDigitPosition(String[] array, int pos){

		List<String>[] lists = new List[10];

		for (int j = 0; j < array.length; j++) {

			int digit = Character.getNumericValue(array[j].charAt(pos));
			if(lists[digit] == null){
				lists[digit] = new ArrayList<>();
			}
			lists[digit].add(array[j]);
		}

		return lists;
	}
            
	public static void main(String[] args)
	{
		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
		radixSort(arr);

		for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]+(i<arr.length-1?",":""));
		}
		System.out.println("");

	}
}

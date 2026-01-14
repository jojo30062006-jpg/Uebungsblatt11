package h3;

public class H3_main {
	public static void main (String [] args) {
		int[] test = {5, 8, 3, 1, 9, 2, 7};

	    int[] sortiert = mergeSort(test);

	    for (int i = 0; i < sortiert.length; i++) {
	        System.out.print(sortiert[i] + " ");
	    }	
	}
	
	public static int [] mergeSort (int unsortiert []){
		
		 int [] sortiert = new int [unsortiert.length];
				 
		 if(unsortiert.length == 1) {
			 return unsortiert;
		 }
		 
		 int [] links = new int[unsortiert.length / 2];
		 int [] rechts = new int[unsortiert.length - unsortiert.length / 2];
		 
		 for (int l = 0; l < links.length; l++) {
			 links [l] = unsortiert [l];
		 }
		 for (int r = 0; r < rechts.length; r++) {
			 rechts [r] = unsortiert [links.length + r];
		 }
		 
		 links = mergeSort(links);
		 rechts = mergeSort(rechts);
		 
		 int i = 0;
		 int j = 0;
		 int k = 0;
		 while (i < links.length && j < rechts.length) {
			 if (links[i] <= rechts[j]) {
				 sortiert[k] = links[i];
				 i++;
			 }
			 else {
				 sortiert[k] = rechts[j];
				 j++;
			 }
			 k++;
		 }
		 while (i < links.length) {
			    sortiert[k] = links[i];
			    i++;
			    k++;
			}

		while (j < rechts.length) {
			    sortiert[k] = rechts[j];
			    j++;
			    k++;
			}
		 
		 return sortiert;
	}

}

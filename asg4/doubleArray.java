class doubleArray
	{
	public String[][] adventure;
	public String[][] description;
	public String[] name;
	

	public doubleArray(int rooms, int options, int info){
		adventure = new String[rooms][options];
		description = new String[rooms][info];
		name = new String[rooms];

	}

	public void insertOption(int r, int o, String text){
		adventure[r][o] = text;
	}

	public void insertDetail(int r, int d, String text){
		description[r][d] = text;
	}
	public void insertName(int r, String text){
		name[r] = text;
	}


	public void display(){
		for(int i = 0; i < adventure.length; i++)
		{
			for(int j = 0; j < adventure[i].length; j++)
			{
				System.out.print(adventure[i][j]);
				if(j < adventure[i].length -1) System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i = 0; i < description.length; i++)
		{
			for(int j = 0; j < description[i].length; j++)
			{
				System.out.print(description[i][j]);
				if(j < description[i].length -1) System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i = 0; i < name.length; i++){
			System.out.println(name[i]);
		}
		System.out.println();
	}
}